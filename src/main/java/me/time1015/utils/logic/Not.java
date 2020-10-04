package me.time1015.utils.logic;

import java.util.function.Predicate;

public final class Not extends UnaryExpression {
  public static final String NAME = "NOT";

  public Not(Expression expression) {
    super(NAME, expression);
  }

  @Override
  protected boolean onEvaluate(Predicate<String> given) {
    return !term().onEvaluate(given);
  }
}
