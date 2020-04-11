package io.se7en.utils.logic;

import java.util.List;
import java.util.function.Predicate;

final class TestExpression extends Expression {
  private final boolean value;

  TestExpression(String name, List<Expression> terms) {
    this(name, terms, true);
  }

  TestExpression(String name, List<Expression> terms, boolean value) {
    super(name, terms);

    this.value = value;
  }

  @Override
  protected boolean onEvaluate(Predicate<String> given) {
    return value;
  }
}
