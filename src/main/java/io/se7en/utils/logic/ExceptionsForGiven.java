package io.se7en.utils.logic;

final class ExceptionsForGiven {
  public static IllegalArgumentException nullVariable() {
    return new IllegalArgumentException("Null variable name");
  }

  public static IllegalArgumentException noValueFor(String var) {
    return new IllegalArgumentException("No value for " + var);
  }

  public static IllegalArgumentException nullVariableMap() {
    return new IllegalArgumentException("Null variable map");
  }
}