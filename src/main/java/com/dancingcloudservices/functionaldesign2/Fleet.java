package com.dancingcloudservices.functionaldesign2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//@FunctionalInterface
//interface AutoCriterion {
//
//  boolean test(Automobile a);
//}

public class Fleet {

  public static <E> void showAll(List<E> input) {
    for (E a : input) {
      System.out.println("> " + a);
    }
    System.out.println("----------------------------------------------");
  }

  public static <E> List<E> filter(List<E> input, Criterion<E> criterion) {
    List<E> la = new ArrayList<>();
    System.out.println("executing filter...");
    for (E a : input) {
      if (criterion.test(a)) {
        la.add(a);
      }
    }
    return la;
  }

//  public static List<Automobile> getCarsByCriterion(List<Automobile> cars, AutoCriterion criterion) {
//    List<Automobile> la = new ArrayList<>();
//    for (Automobile a : cars) {
//      if (criterion.test(a)) {
//        la.add(a);
//      }
//    }
//    return la;
//  }
//
  public static void main(String[] args) {
    List<Automobile> fleet = new ArrayList<>(Arrays.asList(
        new Automobile(Color.RED, 98, "Alan"),
        new Automobile(Color.BLUE, 66, "Jane", "Rachel"),
        new Automobile(Color.WHITE, 72, "John", "Janet"),
        new Automobile(Color.GREEN, 23, "Sue", "Kim", "Eric", "Jo")
    ));
    showAll(fleet);

    Criterion<Automobile> moreThanHalfGas = Automobile.getGasCriterion(50);
    List<Automobile> gotGas = filter(fleet, moreThanHalfGas);

    showAll(gotGas);

    //Higher-order functions -- functions that take functions as arguments and or return computed functions
//    Criterion<Automobile> lessThanHalfGas = Criterion.not(moreThanHalfGas);
    Criterion<Automobile> lessThanHalfGas = moreThanHalfGas.not();
    System.out.println("About to filter low gas");
    List<Automobile> lowGas = filter(fleet, lessThanHalfGas);
    showAll(lowGas);

    System.out.println("with gas again");
//    showAll(gotGas);
    gotGas.forEach(x->System.out.println(">> " + x));
    System.out.println("original fleet");
    showAll(fleet);

    List<String> names = Arrays.asList("Fred", "Algernon", "Jim", "Sheila", "Montgomery");
    names.replaceAll(n->n.toUpperCase());
    names.forEach(n->System.out.println(">>>> " + n));
    showAll(filter(names, s -> s.length() > 4));
    

//    AutoCriterion moreThanHalfGas = Automobile.getGasCriterion(50);
//    showAll(getCarsByCriterion(fleet, moreThanHalfGas));
//
//    AutoCriterion lessThanHalfGas = not(moreThanHalfGas);
//    showAll(getCarsByCriterion(fleet, lessThanHalfGas));

    showAll(fleet);
    Comparator<Automobile> orderByGas = Comparator.comparing(a->a.getGasLevel());
    Collections.sort(fleet, orderByGas.reversed());
    fleet.sort(orderByGas.reversed());
    showAll(fleet);
    
    
  }
}
