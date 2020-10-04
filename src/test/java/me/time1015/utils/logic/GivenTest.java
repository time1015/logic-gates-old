package me.time1015.utils.logic;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.function.Predicate;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class GivenTest {
  @Nested
  public class AllTrue implements GivenTestContract {
    @Override
    public Predicate<String> givenToTest() {
      return Given.allTrue();
    }

    @Test
    public void givenReturnsTrue() {
      Predicate<String> allTrue = Given.allTrue();

      assertTrue(allTrue.test("some var"));
      assertTrue(allTrue.test("another var"));
      assertTrue(allTrue.test("different var"));
    }
  }

  @Nested
  public class AllFalse implements GivenTestContract {
    @Override
    public Predicate<String> givenToTest() {
      return Given.allFalse();
    }

    @Test
    public void givenReturnsFalse() {
      Predicate<String> allFalse = Given.allFalse();

      assertFalse(allFalse.test("some var"));
      assertFalse(allFalse.test("another var"));
      assertFalse(allFalse.test("different var"));
    }
  }

  @Nested
  public class None implements GivenTestContract {
    @Override
    public Predicate<String> givenToTest() {
      return Given.none();
    }

    @Test
    public void givenThrowsIllegalArgument() {
      Predicate<String> none = Given.none();

      assertThrows(IllegalArgumentException.class, () -> none.test("some var"));
      assertThrows(IllegalArgumentException.class, () -> none.test("another var"));
      assertThrows(IllegalArgumentException.class, () -> none.test("different var"));
    }
  }

  @Nested
  public class FromMap implements GivenTestContract {
    @Override
    public Predicate<String> givenToTest() {
      return Given.from(Map.of());
    }

    @Test
    public void nullMap_throwIllegalArgument() {
      assertThrows(IllegalArgumentException.class, () -> Given.from(null));
    }

    @Test
    public void nameNotFound_throwIllegalArgument() {
      Predicate<String> given = Given.from(Map.of("some var", Boolean.TRUE));

      assertThrows(IllegalArgumentException.class, () -> given.test("another var"));
    }

    @Test
    public void nameFound_withTrueValue_returnTrue() {
      String varName = "some var";
      Map<String, Boolean> map = Map.of(varName, Boolean.TRUE);

      assertTrue(Given.from(map).test(varName));
    }

    @Test
    public void nameFound_withFalseValue_returnFalse() {
      String varName = "some var";
      Map<String, Boolean> map = Map.of(varName, Boolean.FALSE);

      assertFalse(Given.from(map).test(varName));
    }
  }
}
