package io.se7en.utils.logic;

import java.util.function.Predicate;

public final class Constant extends NullaryExpression {
  public static final Constant TRUE = new Constant(true);
  public static final Constant FALSE = new Constant(false);

  private final boolean value;

  private Constant(boolean value) {
    super(Boolean.toString(value).toUpperCase());

    this.value = value;
  }

  @Override
  protected boolean onEvaluate(Predicate<String> given) {
    return value;
  }
}
