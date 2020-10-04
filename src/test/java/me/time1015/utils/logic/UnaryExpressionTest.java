package me.time1015.utils.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;

import org.junit.jupiter.api.Test;

public class UnaryExpressionTest {
  @Test
  public void name_returnName() {
    String name = "some name";

    assertEquals(name, testExpression(name, someExpression()).name());
  }

  @Test
  public void terms_returnSingleton() {
    Expression expression = someExpression();

    assertIterableEquals(List.of(expression), testExpression("some name", expression).terms());
  }

  @Test
  public void expression_returnExpression() {
    Expression expression = someExpression();

    assertSame(expression, testExpression("some name", expression).term());
  }

  private TestUnaryExpression testExpression(String name, Expression term) {
    return new TestUnaryExpression(name, term);
  }

  private Expression someExpression() {
    return new TestExpression("name", List.of(), false);
  }
}
