package io.se7en.utils.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

public class AndTest {
  @Test
  public void name_returnValueInUppercase() {
    assertEquals(And.NAME, andToTest(someExpression(), someExpression()).name());
  }

  @Test
  public void evaluate_returnOrValue() {
    Expression returningTrue = expressionReturning(true);
    Expression returningFalse = expressionReturning(false);
    Predicate<String> given = v -> true;

    assertTrue(andToTest(returningTrue, returningTrue).evaluate(given));
    assertFalse(andToTest(returningTrue, returningFalse).evaluate(given));
    assertFalse(andToTest(returningFalse, returningTrue).evaluate(given));
    assertFalse(andToTest(returningFalse, returningFalse).evaluate(given));
  }

  private And andToTest(Expression left, Expression right) {
    return new And(left, right);
  }

  private Expression someExpression() {
    return expressionReturning(false);
  }

  private Expression expressionReturning(boolean value) {
    return new TestExpression("name", List.of(), value);
  }
}
