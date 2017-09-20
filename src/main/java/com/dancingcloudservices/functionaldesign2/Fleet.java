package com.dancingcloudservices.functionaldesign2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface AutoCriterion {

  boolean test(Automobile a);
}

public class Fleet {

  public static AutoCriterion not(AutoCriterion crit) {
    return a -> !crit.test(a);
  }

  public static void showAll(List<Automobile> cars) {
    for (Automobile a : cars) {
      System.out.println("> " + a);
    }
    System.out.println("----------------------------------------------");
  }

  public static List<Automobile> getCarsByCriterion(List<Automobile> cars, AutoCriterion criterion) {
    List<Automobile> la = new ArrayList<>();
    for (Automobile a : cars) {
      if (criterion.test(a)) {
        la.add(a);
      }
    }
    return la;
  }

  public static void main(String[] args) {
    List<Automobile> fleet = new ArrayList<>(Arrays.asList(
        new Automobile(Color.RED, 98, "Alan"),
        new Automobile(Color.BLUE, 66, "Jane", "Rachel"),
        new Automobile(Color.WHITE, 72, "John", "Janet"),
        new Automobile(Color.GREEN, 23, "Sue", "Kim", "Eric", "Jo")
    ));
    showAll(fleet);

    AutoCriterion moreThanHalfGas = Automobile.getGasCriterion(50);
    showAll(getCarsByCriterion(fleet, moreThanHalfGas));

    AutoCriterion lessThanHalfGas = not(moreThanHalfGas);
    showAll(getCarsByCriterion(fleet, lessThanHalfGas));
  }
}
