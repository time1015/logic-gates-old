package io.se7en.utils.logic;

import java.util.Collections;

abstract class NullaryExpression extends Expression {
  protected NullaryExpression(String name) {
    super(name, Collections.emptyList());
  }
}
