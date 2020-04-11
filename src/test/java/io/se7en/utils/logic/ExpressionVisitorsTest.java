package io.se7en.utils.logic;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class ExpressionVisitorsTest {
  @Test
  public void prefix_visitReturnsStream() {
    Expression firstTerm = someExpression();
    Expression secondTerm = someExpression();
    Expression thirdTerm = someExpression();
    Expression expression = someExpression(firstTerm, secondTerm, thirdTerm);
    Stream<Expression> toVisit = Stream.of(expression, firstTerm, secondTerm, thirdTerm);

    Stream<Expression> visited = ExpressionVisitors.prefix().visit(expression);

    assertIterableEquals(toList(toVisit), toList(visited));
  }

  @Test
  public void prefix_visitChildren() {
    Expression firstTerm = someExpression();
    Expression secondTerm = someExpression();
    Expression thirdTerm = someExpression();
    Expression fourthTerm = someExpression(secondTerm, thirdTerm);
    Expression expression = someExpression(firstTerm, fourthTerm);
    Stream<Expression> toVisit = Stream.of(expression, firstTerm, fourthTerm, secondTerm, thirdTerm);

    Stream<Expression> visited = ExpressionVisitors.prefix().visit(expression);

    assertIterableEquals(toList(toVisit), toList(visited));
  }

  @Test
  public void infix_visitReturnsStream() {
    Expression firstTerm = someExpression();
    Expression secondTerm = someExpression();
    Expression thirdTerm = someExpression();
    Expression expression = someExpression(firstTerm, secondTerm, thirdTerm);
    Stream<Expression> toVisit = Stream.of(firstTerm, expression, secondTerm, expression, thirdTerm);

    Stream<Expression> visited = ExpressionVisitors.infix().visit(expression);

    assertIterableEquals(toList(toVisit), toList(visited));
  }

  @Test
  public void infix_visitChildren() {
    Expression firstTerm = someExpression();
    Expression secondTerm = someExpression();
    Expression thirdTerm = someExpression();
    Expression fourthTerm = someExpression(secondTerm, thirdTerm);
    Expression expression = someExpression(firstTerm, fourthTerm);
    Stream<Expression> toVisit = Stream.of(firstTerm, expression, secondTerm, fourthTerm, thirdTerm);

    Stream<Expression> visited = ExpressionVisitors.infix().visit(expression);

    assertIterableEquals(toList(toVisit), toList(visited));
  }

  @Test
  public void postfix_visitReturnsStream() {
    Expression firstTerm = someExpression();
    Expression secondTerm = someExpression();
    Expression thirdTerm = someExpression();
    Expression expression = someExpression(firstTerm, secondTerm, thirdTerm);
    Stream<Expression> toVisit = Stream.of(firstTerm, secondTerm, thirdTerm, expression);

    Stream<Expression> visited = ExpressionVisitors.postfix().visit(expression);

    assertIterableEquals(toList(toVisit), toList(visited));
  }

  @Test
  public void postfix_visitChildren() {
    Expression firstTerm = someExpression();
    Expression secondTerm = someExpression();
    Expression thirdTerm = someExpression();
    Expression fourthTerm = someExpression(secondTerm, thirdTerm);
    Expression expression = someExpression(firstTerm, fourthTerm);
    Stream<Expression> toVisit = Stream.of(firstTerm, secondTerm, thirdTerm, fourthTerm, expression);

    Stream<Expression> visited = ExpressionVisitors.postfix().visit(expression);

    assertIterableEquals(toList(toVisit), toList(visited));
  }

  private List<Expression> toList(Stream<Expression> stream) {
    return stream.collect(Collectors.toList());
  }

  private Expression someExpression(Expression... terms) {
    return new TestExpression("test", List.of(terms));
  }

  private static final class TestExpression extends Expression {
    TestExpression(String name, List<Expression> terms) {
      super(name, terms);
    }

    @Override
    protected boolean onEvaluate(Predicate<String> given) {
      return false;
    }
  }
}
