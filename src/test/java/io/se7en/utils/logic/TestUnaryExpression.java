package io.se7en.utils.logic;

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
