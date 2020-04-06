package io.se7en.utils.logic;

import java.util.stream.Stream;

import io.se7en.utils.logic.Expression;
import io.se7en.utils.logic.ExpressionVisitor;

final class TestExpressionVisitor extends ExpressionVisitor {
  @Override
  protected Stream<Expression> onVisit(Expression current) {
    return null;
  }
}
