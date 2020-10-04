package me.time1015.utils.logic;

import java.util.function.Predicate;

final class TestBinaryExpression extends BinaryExpression {
  TestBinaryExpression(String name, Expression left, Expression right) {
    super(name, left, right);
  }

  @Override
  protected boolean onEvaluate(Predicate<String> given) {
    return false;
  }
}
