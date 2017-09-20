package com.dancingcloudservices.functionaldesign2;

@FunctionalInterface
public interface Criterion<E> {

  boolean test(E a);

  static <E> Criterion<E> not(Criterion<E> crit) {
    return a -> {
      System.out.println("executing inverted test...");
      return !crit.test(a);
    };
  }
  default Criterion<E> not() {
    return a -> {
      return !this.test(a);
    };
  }
  
  default Criterion<E> and(Criterion<E> other) {
    return x -> this.test(x) && other.test(x);
  }
  default Criterion<E> or(Criterion<E> other) {
    return x -> this.test(x) || other.test(x);
  }
}
