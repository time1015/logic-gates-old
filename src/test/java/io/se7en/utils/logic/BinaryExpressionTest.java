package io.se7en.utils.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class BinaryExpressionTest {
  @Test
  public void name_returnName() {
    String name = "some name";

    assertEquals(name, testExpression(name, someExpression(), someExpression()).name());
  }

  @Test
  public void terms_returnLeftAndRightAsList() {
    Expression left = someExpression();
    Expression right = someExpression();

    List<Expression> givenTerms = List.of(left, right);
    List<Expression> returnedTerms = testExpression("some name", left, right).terms();

    assertTrue(givenTerms.containsAll(returnedTerms));
    assertTrue(returnedTerms.containsAll(givenTerms));
  }

  @Test
  public void left_returnLeftExpression() {
    Expression left = someExpression();

    assertSame(left, testExpression("some name", left, someExpression()).left());
  }

  @Test
  public void right_returnRightExpression() {
    Expression right = someExpression();

    assertSame(right, testExpression("some name", someExpression(), right).right());
  }

  private TestBinaryExpression testExpression(String name, Expression left, Expression right) {
    return new TestBinaryExpression(name, left, right);
  }

  private Expression someExpression() {
    return new TestExpression("name", List.of(), false);
  }
}
