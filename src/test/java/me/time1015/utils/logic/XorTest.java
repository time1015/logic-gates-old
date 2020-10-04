package me.time1015.utils.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

public class XorTest {
  @Test
  public void name_returnValueInUppercase() {
    assertEquals(Xor.NAME, xorToTest(someExpression(), someExpression()).name());
  }

  @Test
  public void evaluate_returnOrValue() {
    Expression returningTrue = expressionReturning(true);
    Expression returningFalse = expressionReturning(false);
    Predicate<String> given = v -> true;

    assertFalse(xorToTest(returningTrue, returningTrue).evaluate(given));
    assertTrue(xorToTest(returningTrue, returningFalse).evaluate(given));
    assertTrue(xorToTest(returningFalse, returningTrue).evaluate(given));
    assertFalse(xorToTest(returningFalse, returningFalse).evaluate(given));
  }

  private Xor xorToTest(Expression left, Expression right) {
    return new Xor(left, right);
  }

  private Expression someExpression() {
    return expressionReturning(false);
  }

  private Expression expressionReturning(boolean value) {
    return new TestExpression("name", List.of(), value);
  }
}
