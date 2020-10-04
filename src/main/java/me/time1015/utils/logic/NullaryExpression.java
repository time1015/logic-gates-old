package me.time1015.utils.logic;

import java.util.Collections;

abstract class NullaryExpression extends Expression {
  protected NullaryExpression(String name) {
    super(name, Collections.emptyList());
  }
}
