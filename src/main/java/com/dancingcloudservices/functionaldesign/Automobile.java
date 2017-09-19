package com.dancingcloudservices.functionaldesign;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

public class Automobile {

  private Color color;
  private int gasLevel;
  private List<String> passengers;

  public Automobile(Color color, int gasLevel, String... passengers) {
    this.color = color;
    this.gasLevel = gasLevel;
    this.passengers = Arrays.asList(passengers);
  }

  public Color getColor() {
    return color;
  }

  public int getGasLevel() {
    return gasLevel;
  }

  public List<String> getPassengers() {
    return passengers;
  }

  @Override
  public String toString() {
    return "Automobile{" + "color=" + color + ", gasLevel=" + gasLevel + ", passengers=" + passengers + '}';
  }

  // Lambda expression
  // Expression lambda
  private static final AutoCriterion gasCriterion = a -> a.gasLevel > 50 ;
  
  // Block lambda (full method body)
//  private static final AutoCriterion gasCriterion = (a) -> { return a.gasLevel > 50;};

//  private static final AutoCriterion gasCriterion = /*new AutoCriterion() {*/
////    @Override
//    /*public boolean test*/(/*Automobile*/ a) -> {
//      return a.gasLevel > 70;
//    }
//  /*}*/;
  
//  // Anonymous class
//  // Make this, rather than make Xxxx
//  private static final AutoCriterion gasCriterion = new AutoCriterion() {
//    @Override
//    public boolean test(Automobile a) {
//      return a.gasLevel > 70;
//    }
//  };
//  // Anonymous class
//  // Make this, rather than make Xxxx
//  private static final AutoCriterion gasCriterion = new /*GasCriterion();
//  private static class GasCriterion implements */ AutoCriterion() {
//    @Override
//    public boolean test(Automobile a) {
//      return a.gasLevel > 50;
//    }
//  };

  // Make this a factory / singleton
  public static AutoCriterion getGasCriterion() {
    return a -> a.gasLevel > 50;
  }
//  public static AutoCriterion getGasCriterion() {
//    return gasCriterion;
//  }
  
//
//  private static final AutoCriterion gasCriterion = new GasCriterion();
//  // Make this a factory / singleton
//  public static AutoCriterion getGasCriterion() {
//    return gasCriterion;
//  }
//  
//  private static class GasCriterion implements AutoCriterion {
//    @Override
//    public boolean test(Automobile a) {
//      return a.gasLevel > 50;
//    }
//  }
}
