package io.se7en.utils.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class NullaryExpressionTest {
  @Test
  public void name_returnName() {
    String name = "some name";

    assertEquals(name, testExpression(name).name());
  }

  @Test
  public void terms_returnEmpty() {
    assertIterableEquals(List.of(), testExpression("some name").terms());
  }

  private TestNullaryExpression testExpression(String name) {
    return new TestNullaryExpression(name);
  }
}
