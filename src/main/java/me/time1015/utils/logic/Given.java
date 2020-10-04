package me.time1015.utils.logic;

import java.util.Map;
import java.util.function.Predicate;

public final class Given {
  public static Predicate<String> allTrue() {
    return onNonNullName(var -> true);
  }

  public static Predicate<String> allFalse() {
    return onNonNullName(var -> false);
  }

  public static Predicate<String> none() {
    return onNonNullName(var -> {
      throw ExceptionsForGiven.noValueFor(var);
    });
  }

  public static Predicate<String> from(Map<String, Boolean> map) {
    if (map == null)
      throw ExceptionsForGiven.nullVariableMap();

    if (map.isEmpty())
      return none();

    return onNonNullName(var -> {
      Boolean value = map.get(var);
      if (value == null)
        throw ExceptionsForGiven.noValueFor(var);

      return value.booleanValue();
    });
  }

  private static Predicate<String> onNonNullName(Predicate<String> given) {
    return var -> {
      if (var == null)
        throw ExceptionsForGiven.nullVariable();

      return given.test(var);
    };
  }
}
