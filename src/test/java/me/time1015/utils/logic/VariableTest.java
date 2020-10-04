package me.time1015.utils.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

public class VariableTest {
  @Test
  public void name_returnName() {
    String name = "some name";

    assertEquals(name, variableToTest(name).name());
  }

  @Test
  public void evaluate_givenReturnsTrue_returnValueFromGiven() {
    String name = "some name";
    Predicate<String> given = someGiven(name, true);

    assertTrue(variableToTest(name).onEvaluate(given));
  }

  @Test
  public void evaluate_givenReturnsFalse_returnValueFromGiven() {
    String name = "some name";
    Predicate<String> given = someGiven(name, false);

    assertFalse(variableToTest(name).onEvaluate(given));
  }

  private Predicate<String> someGiven(String name, boolean value) {
    return Given.from(Map.of(name, Boolean.valueOf(value)));
  }

  private Variable variableToTest(String name) {
    return new Variable(name);
  }
}
