package io.se7en.utils.logic;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

public interface GivenTestContract {
  Predicate<String> givenToTest();

  @Test
  default void nullName_throwIllegalArgument() {
    assertThrows(IllegalArgumentException.class, () -> givenToTest().test(null));
  }
}
