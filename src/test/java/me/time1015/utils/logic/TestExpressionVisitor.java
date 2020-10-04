package me.time1015.utils.logic;

import java.util.stream.Stream;

final class TestExpressionVisitor extends ExpressionVisitor {
  @Override
  protected Stream<Expression> onVisit(Expression current) {
    return null;
  }
}
