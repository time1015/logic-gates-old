package io.se7en.utils.logic;

import java.util.Arrays;

abstract class BinaryExpression extends Expression {
  private final Expression left;
  private final Expression right;

  protected BinaryExpression(String name, Expression left, Expression right) {
    super(name, Arrays.asList(left, right));

    this.left = left;
    this.right = right;
  }

  public final Expression left() {
    return left;
  }

  public final Expression right() {
    return right;
  }
}
