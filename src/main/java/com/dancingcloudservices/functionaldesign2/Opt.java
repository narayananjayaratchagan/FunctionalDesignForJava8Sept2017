package com.dancingcloudservices.functionaldesign2;

import java.util.Optional;

/**
 * @author Simon Roberts
 */
public class Opt {

  public static void main(String[] args) {
    Optional<String> s = Optional.ofNullable("Fred");
    System.out.println("> " + 
    s.map(x -> x.toUpperCase())
        .orElse("No Name Found"));
  }
}
