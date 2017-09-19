package com.dancingcloudservices.functionaldesign;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class OrderByGas implements Comparator<Automobile> {
  @Override
  public int compare(Automobile o1, Automobile o2) {
    return o1.getGasLevel() - o2.getGasLevel();
  }
}

@FunctionalInterface
interface AutoCriterion {
  boolean test(Automobile a);
//  void doStuff();
}

interface BalloonCriterion {
  boolean test(Balloon s);
}
class Balloon {
  public int getGasLevel() {
    return 100;
  }
}
//
//class GasCriterion implements AutoCriterion {
//  @Override
//  public boolean test(Automobile a) {
//    return a.getGasLevel() > 50;
//  }
//}
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
//  public static List<Automobile> getFullishCars(List<Automobile> cars, int level) {
//    List<Automobile> la = new ArrayList<>();
//    for (Automobile a : cars) {
//      if (a.getGasLevel() > level) {
//        la.add(a);
//      }
//    }
//    return la;
//  }
//  public static List<Automobile> getCarsWithPassengers(List<Automobile> cars, int count) {
//    List<Automobile> la = new ArrayList<>();
//    for (Automobile a : cars) {
//      if (a.getPassengers().size() > count) {
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
//    showAll(getFullishCars(fleet,70));
//    
//    fleet.sort(new OrderByGas());
//    showAll(fleet);

  AutoCriterion moreThanHalfGas = Automobile.getGasCriterion(50);
  showAll(getCarsByCriterion(fleet, moreThanHalfGas));
  
  AutoCriterion lessThanHalfGas = not(moreThanHalfGas);
  showAll(getCarsByCriterion(fleet, lessThanHalfGas));
//  showAll(getCarsByCriterion(fleet, (Automobile a) -> { return a.getPassengers().size() > 3;}));
//  
//  Automobile x = new Automobile(Color.RED, 98, "Alan");
//   AutoCriterion ac = (a -> a.getGasLevel() > 50);
//   ac.test(x);
//   ((AutoCriterion)(a -> a.getGasLevel() > 50)).test(x);
//   Balloon b = new Balloon();
//   ((BalloonCriterion)(a -> a.getGasLevel() > 50)).test(b);
  }
}
