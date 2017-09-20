package streamcollect;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

class Average {

  private double sum;
  private long count;

  public void include(double val) {
    sum += val;
    count++;
  }

  public void merge(Average a) {
    sum += a.sum;
    count += a.count;
  }

  public double get() {
    return sum / count;
  }
}

public class Averaging {

  public static void main(String[] args) {
    long start = System.nanoTime();

    Average av = Stream.generate(() -> ThreadLocalRandom.current().nextDouble(-Math.PI, Math.PI))
        .parallel()
        .limit(10_000_000)
        .map(x -> Math.sin(x))
        .collect(() -> new Average(), (b, v) -> b.include(v), (b1, b2) -> b1.merge(b2));
    //        .forEach(s->System.out.println(s));
    ;
    long end = System.nanoTime();
    System.out.println("Average is " + av.get() + "\ntime was " + (end - start));
  }
}
