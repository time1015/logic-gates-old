package io.se7en.utils.logic;

import java.util.function.Predicate;

public final class Xor extends BinaryExpression {
  public static final String NAME = "XOR";

  public Xor(Expression left, Expression right) {
    super(NAME, left, right);
  }

  @Override
  protected boolean onEvaluate(Predicate<String> given) {
    return left().onEvaluate(given) ^ right().onEvaluate(given);
  }
}
