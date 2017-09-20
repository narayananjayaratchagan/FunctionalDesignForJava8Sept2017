package com.dancingcloudservices.functionaldesign2;

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

  public static Criterion<Automobile> getGasCriterion(final int level) {
    return a -> a.gasLevel > level;
  }
//  public static AutoCriterion getGasCriterion(final int level) {
//    return a -> a.gasLevel > level;
//  }
}
