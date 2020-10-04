package me.time1015.utils.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public final class GivenBuilder {
  private final Map<String, Boolean> map;

  public GivenBuilder() {
    this.map = new HashMap<>();
  }

  public GivenBuilder givenTrue(String name) {
    return given(name, true);
  }

  public GivenBuilder givenFalse(String name) {
    return given(name, false);
  }

  public GivenBuilder given(String name, boolean value) {
    if (name == null)
      throw ExceptionsForGiven.nullVariable();

    map.put(name, Boolean.valueOf(value));
    return this;
  }

  public Predicate<String> build() {
    return Given.from(Map.copyOf(map));
  }
}
