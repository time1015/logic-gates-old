package me.time1015.utils.logic;

import java.util.List;
import java.util.function.Predicate;

public abstract class Expression {
  private final String name;
  private final List<Expression> terms;

  public Expression(String name, List<Expression> terms) {
    validateName(name);
    validateTerms(terms);

    this.name = name;
    this.terms = List.copyOf(terms);
  }

  private static void validateName(String name) {
    if (name == null)
      throw ExceptionsForExpression.nullName();
    if (name.isBlank())
      throw ExceptionsForExpression.blankName();
  }

  private static void validateTerms(List<Expression> terms) {
    if (terms == null)
      throw ExceptionsForExpression.nullTerms();
    if (termsContainNull(terms))
      throw ExceptionsForExpression.nullInTerms();
  }

  private static boolean termsContainNull(List<Expression> terms) {
    // contains() from List.of()/copyOf()
    // throw NullPointerExceptions when
    // null is passed as a parameter;
    // manually check each element instead
    for (Expression term : terms)
      if (term == null)
        return true;

    return false;
  }

  public final String name() {
    return name;
  }

  public final List<Expression> terms() {
    return terms;
  }

  public final boolean evaluate(Predicate<String> given) {
    if (given == null)
      throw ExceptionsForExpression.nullGiven();

    return onEvaluate(given);
  }

  protected abstract boolean onEvaluate(Predicate<String> given);
}
