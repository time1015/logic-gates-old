package io.se7en.utils.logic;

final class ExceptionsForVisitor {
  public static IllegalArgumentException nullExpression() {
    return new IllegalArgumentException("Null expression");
  }
}
