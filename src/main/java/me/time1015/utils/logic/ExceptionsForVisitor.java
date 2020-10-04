package me.time1015.utils.logic;

final class ExceptionsForVisitor {
  public static IllegalArgumentException nullExpression() {
    return new IllegalArgumentException("Null expression");
  }
}
