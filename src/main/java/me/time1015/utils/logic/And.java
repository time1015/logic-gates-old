package me.time1015.utils.logic;

import java.util.function.Predicate;

public final class And extends BinaryExpression {
  public static final String NAME = "AND";

  public And(Expression left, Expression right) {
    super(NAME, left, right);
  }

  @Override
  protected boolean onEvaluate(Predicate<String> given) {
    return left().onEvaluate(given) && right().onEvaluate(given);
  }
}
