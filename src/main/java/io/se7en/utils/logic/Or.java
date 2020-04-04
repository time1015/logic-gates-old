package io.se7en.utils.logic;

import java.util.function.Predicate;

public final class Or extends BinaryExpression {
  public static final String NAME = "OR";

  public Or(Expression left, Expression right) {
    super(NAME, left, right);
  }

  @Override
  protected boolean onEvaluate(Predicate<String> given) {
    return left().onEvaluate(given) || right().onEvaluate(given);
  }
}
