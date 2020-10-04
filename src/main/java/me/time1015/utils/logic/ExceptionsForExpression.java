package me.time1015.utils.logic;

final class ExceptionsForExpression {
  public static IllegalArgumentException nullName() {
    return new IllegalArgumentException("Null expression name");
  }

  public static IllegalArgumentException blankName() {
    return new IllegalArgumentException("Blank expression name");
  }

  public static IllegalArgumentException nullTerms() {
    return new IllegalArgumentException("Null term list");
  }

  public static IllegalArgumentException nullInTerms() {
    return new IllegalArgumentException("Term list contains null");
  }

  public static IllegalArgumentException nullGiven() {
    return new IllegalArgumentException("Null given");
  }

  public static IllegalArgumentException nullExpression() {
    return new IllegalArgumentException("Null expression");
  }
}
