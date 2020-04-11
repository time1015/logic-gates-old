package io.se7en.utils.logic;

import java.util.Collections;

abstract class UnaryExpression extends Expression {
  private final Expression term;

  protected UnaryExpression(String name, Expression term) {
    super(name, Collections.singletonList(term));

    this.term = term;
  }

  public final Expression term() {
    return term;
  }
}
