package io.se7en.utils.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

public class OrTest {
  @Test
  public void name_returnValueInUppercase() {
    assertEquals(Or.NAME, orToTest(someExpression(), someExpression()).name());
  }

  @Test
  public void evaluate_returnOrValue() {
    Expression returningTrue = expressionReturning(true);
    Expression returningFalse = expressionReturning(false);
    Predicate<String> given = v -> true;

    assertTrue(orToTest(returningTrue, returningTrue).evaluate(given));
    assertTrue(orToTest(returningTrue, returningFalse).evaluate(given));
    assertTrue(orToTest(returningFalse, returningTrue).evaluate(given));
    assertFalse(orToTest(returningFalse, returningFalse).evaluate(given));
  }

  private Or orToTest(Expression left, Expression right) {
    return new Or(left, right);
  }

  private Expression someExpression() {
    return expressionReturning(false);
  }

  private Expression expressionReturning(boolean value) {
    return new TestExpression("name", List.of(), value);
  }
}
