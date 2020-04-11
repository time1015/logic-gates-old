package io.se7en.utils.logic;

import java.util.function.Predicate;

public final class Variable extends NullaryExpression {
  private final String name;

  public Variable(String name) {
    super(name);

    this.name = name;
  }

  @Override
  protected boolean onEvaluate(Predicate<String> given) {
    return given.test(name);
  }
}
