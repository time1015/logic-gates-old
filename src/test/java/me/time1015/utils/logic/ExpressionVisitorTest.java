package me.time1015.utils.logic;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ExpressionVisitorTest {
  @Test
  public void visit_nullExpression_throwIllegalArgument() {
    assertThrows(IllegalArgumentException.class, () -> testVisitor().visit(null));
  }

  private TestExpressionVisitor testVisitor() {
    return new TestExpressionVisitor();
  }
}
