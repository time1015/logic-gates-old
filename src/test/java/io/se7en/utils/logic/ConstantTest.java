package io.se7en.utils.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Predicate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ConstantTest {
  @Nested
  public class True {
    @Test
    public void name_returnValueInUppercase() {
      assertEquals("TRUE", Constant.TRUE.name());
    }

    @Test
    public void evaluate_returnValue() {
      assertTrue(Constant.TRUE.evaluate(someGiven()));
    }
  }

  @Nested
  public class False {
    @Test
    public void name_returnValueInUppercase() {
      assertEquals("FALSE", Constant.FALSE.name());
    }

    @Test
    public void evaluate_returnValue() {
      assertFalse(Constant.FALSE.evaluate(someGiven()));
    }
  }

  private Predicate<String> someGiven() {
    return var -> {
      Assertions.fail("Given should not be called");
      return false; // dead code; ^ statement will cause test to fail first
    };
  }
}
