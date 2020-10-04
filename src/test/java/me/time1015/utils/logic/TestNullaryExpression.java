package me.time1015.utils.logic;

import java.util.function.Predicate;

public final class TestNullaryExpression extends NullaryExpression {
  TestNullaryExpression(String name) {
    super(name);
  }

  @Override
  protected boolean onEvaluate(Predicate<String> given) {
    return false;
  }
}
