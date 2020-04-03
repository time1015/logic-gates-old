package io.se7en.utils.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

public class NotTest {
  @Test
  public void name_returnValueInUppercase() {
    assertEquals(Not.NAME, notToTest(someExpression()).name());
  }

  @Test
  public void evaluate_returnNegationOfExpression() {
    Predicate<String> given = v -> true;

    assertTrue(notToTest(expressionReturning(false)).evaluate(given));
    assertFalse(notToTest(expressionReturning(true)).evaluate(given));
  }

  @Test
  public void evaluate_doubleNot_returnExpressionEvaluate() {
    Predicate<String> given = v -> true;

    assertTrue(notToTest(notToTest(expressionReturning(true))).evaluate(given));
    assertFalse(notToTest(notToTest(expressionReturning(false))).evaluate(given));
  }

  private Not notToTest(Expression expression) {
    return new Not(expression);
  }

  private Expression someExpression() {
    return expressionReturning(false);
  }

  private Expression expressionReturning(boolean value) {
    return new TestExpression("name", List.of(), value);
  }
}
