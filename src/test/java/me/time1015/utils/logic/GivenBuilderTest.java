package me.time1015.utils.logic;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Predicate;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class GivenBuilderTest {
  @Test
  public void givenTrue_nullName_throwIllegalArgument() {
    assertThrows(IllegalArgumentException.class, () -> builderToTest().givenTrue(null));
  }

  @Test
  public void givenTrue_returnItself() {
    GivenBuilder builderToTest = builderToTest();

    assertSame(builderToTest, builderToTest.givenTrue("some var"));
  }

  @Test
  public void givenFalse_nullName_throwIllegalArgument() {
    assertThrows(IllegalArgumentException.class, () -> builderToTest().givenFalse(null));
  }

  @Test
  public void givenFalse_returnItself() {
    GivenBuilder builderToTest = builderToTest();

    assertSame(builderToTest, builderToTest.givenFalse("some var"));
  }

  @Test
  public void given_nullName_throwIllegalArgument() {
    assertThrows(IllegalArgumentException.class, () -> builderToTest().given(null, true));
    assertThrows(IllegalArgumentException.class, () -> builderToTest().given(null, false));
  }

  @Test
  public void given_returnItself() {
    GivenBuilder builderToTest = builderToTest();

    assertSame(builderToTest, builderToTest.given("some var", true));
    assertSame(builderToTest, builderToTest.given("another var", false));
  }

  @Nested
  public class OnBuild implements GivenTestContract {
    @Override
    public Predicate<String> givenToTest() {
      return builderToTest().build();
    }

    @Test
    public void nameNotFound_throwIllegalArgument() {
      Predicate<String> given = buildGiven("some var", true);

      assertThrows(IllegalArgumentException.class, () -> given.test("another var"));
    }

    @Test
    public void nameFound_withTrueValue_returnTrue() {
      String varName = "some var";

      assertTrue(buildGiven(varName, true).test(varName));
    }

    @Test
    public void nameFound_withFalseValue_returnFalse() {
      String varName = "some var";

      assertFalse(buildGiven(varName, false).test(varName));
    }

    private Predicate<String> buildGiven(String name, boolean value) {
      return builderToTest().given(name, value).build();
    }
  }

  private GivenBuilder builderToTest() {
    return new GivenBuilder();
  }
}
