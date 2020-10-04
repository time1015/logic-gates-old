package me.time1015.utils.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ExpressionTest {
  @Test
  public void constructor_nullName_throwIllegalArgument() {
    assertThrows(IllegalArgumentException.class, () -> new TestExpression(null, List.of()));
  }

  @Test
  public void constructor_emptyName_throwIllegalArgument() {
    assertThrows(IllegalArgumentException.class, () -> new TestExpression("", List.of()));
  }

  @Test
  public void constructor_blankName_throwIllegalArgument() {
    assertThrows(IllegalArgumentException.class, () -> new TestExpression("      ", List.of()));
  }

  @Test
  public void constructor_nullTerms_throwIllegalArgument() {
    assertThrows(IllegalArgumentException.class, () -> new TestExpression("some name", null));
  }

  @Test
  public void constructor_termsContainNull_throwIllegalArgument() {
    assertThrows(IllegalArgumentException.class, () -> new TestExpression("some name", Arrays.asList(null, null)));
  }

  @Test
  public void name_returnName() {
    String name = "some name";

    assertEquals(name, testExpression(name, List.of()).name());
  }

  @Test
  public void terms_returnList() {
    List<Expression> givenTerms = List.of(testExpression("term 1", List.of()), testExpression("term 2", List.of()));

    List<Expression> returnedTerms = testExpression("some name", givenTerms).terms();

    // check only presence of elements in both lists
    assertTrue(returnedTerms.containsAll(givenTerms));
    assertTrue(givenTerms.containsAll(returnedTerms));
  }

  @Test
  public void evaluate_nullGiven_throwIllegalArgument() {
    assertThrows(IllegalArgumentException.class, () -> testExpression("some name", List.of()).evaluate(null));
  }

  private TestExpression testExpression(String name, List<Expression> terms) {
    return new TestExpression(name, terms);
  }
}
