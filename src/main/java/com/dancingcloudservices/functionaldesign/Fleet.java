package com.dancingcloudservices.functionaldesign;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fleet {
  
  public static void showAll(List<Automobile> cars) {
    for (Automobile a : cars) {
      System.out.println("> " + a);
    }
  }
  
  public static void main(String[] args) {
    List<Automobile> fleet = new ArrayList<>(Arrays.asList(
        new Automobile(Color.RED, 98, "Alan"),
        new Automobile(Color.BLUE, 66, "Jane", "Rachel"),
        new Automobile(Color.WHITE, 72, "John", "Janet"),
        new Automobile(Color.GREEN, 23, "Sue", "Kim", "Eric", "Jo")
    ));
    showAll(fleet);
  }
}
