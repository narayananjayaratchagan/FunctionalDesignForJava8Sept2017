package iterablex;

import com.dancingcloudservices.functionaldesign2.Automobile;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;

public class IterableX<E> implements Iterable<E> {

  private Iterable<E> wrapped;

  private IterableX() {
  }

  public static <E> IterableX<E> of(Iterable<E> target) {
    IterableX<E> self = new IterableX<>();
    self.wrapped = target;
    return self;
  }

  public IterableX<E> filter(Predicate<E> predicate) {
    ArrayList<E> updated = new ArrayList<>();
    wrapped.forEach(x -> {
      if (predicate.test(x)) {
        updated.add(x);
      }
    });
    return of(updated);
  }

  public <Y> IterableX<Y> flatMap(Function<E, Iterable<Y>> operation) {
    ArrayList<Y> updated = new ArrayList<>();
    wrapped.forEach(x -> {
      operation.apply(x).forEach(y -> updated.add(y));
    });
    return of(updated);
  }

  public <Y> Iterable<Y> map(Function<E, Y> operation) {
    ArrayList<Y> updated = new ArrayList<>();
    wrapped.forEach(x -> updated.add(operation.apply(x)));
    return of(updated);
  }

  public Iterable<E> get() {
    return wrapped;
  }
  
  @Override
  public Iterator<E> iterator() {
    return wrapped.iterator();
  }

  public static void main(String[] args) {
    IterableX<Automobile> fleet = IterableX.of(new ArrayList<>(Arrays.asList(
        new Automobile(Color.RED, 98, "Alan"),
        new Automobile(Color.BLUE, 66, "Jane", "Rachel"),
        new Automobile(Color.WHITE, 72, "John", "Janet"),
        new Automobile(Color.GREEN, 23, "Sue", "Kim", "Eric", "Jo")
    )));

    fleet
        .filter(a -> a.getPassengers().size() > 1)
//        .map(a -> a.getColor() + ", " + a.getGasLevel())
        .flatMap(a->a.getPassengers())
        .forEach(x -> System.out.println(x));
  }
}
