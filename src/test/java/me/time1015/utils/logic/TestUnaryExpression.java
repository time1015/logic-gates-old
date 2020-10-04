package me.time1015.utils.logic;

import java.util.function.Predicate;

public final class TestUnaryExpression extends UnaryExpression {
  TestUnaryExpression(String name, Expression term) {
    super(name, term);
  }

  @Override
  protected boolean onEvaluate(Predicate<String> given) {
    return false;
  }
}
