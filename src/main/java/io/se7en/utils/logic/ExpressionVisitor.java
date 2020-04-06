package io.se7en.utils.logic;

import java.util.stream.Stream;

public abstract class ExpressionVisitor {
  public final Stream<Expression> visit(Expression current) {
    if (current == null)
      throw ExceptionsForVisitor.nullExpression();

    return onVisit(current);
  }

  protected abstract Stream<Expression> onVisit(Expression current);
}
