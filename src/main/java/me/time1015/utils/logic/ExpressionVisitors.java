package me.time1015.utils.logic;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ExpressionVisitors {
  public static ExpressionVisitor prefix() {
    return new BaseVisitor() {
      @Override
      protected Stream<Expression> onVisit(Expression current, Stream<Expression> terms) {
        return Stream.concat(Stream.of(current), terms.flatMap(this::onVisit));
      }
    };
  }

  public static ExpressionVisitor infix() {
    return new BaseVisitor() {
      @Override
      protected Stream<Expression> onVisit(Expression current, Stream<Expression> terms) {
        return terms
          .map(this::onVisit)
          .flatMap(o -> Stream.concat(o, Stream.of(current)))
          .collect(Collectors.collectingAndThen(Collectors.toList(), this::truncateLast))
          .stream();
      }

      private List<Expression> truncateLast(List<Expression> list) {
        return list.subList(0, list.size() - 1);
      }
    };
  }

  public static ExpressionVisitor postfix() {
    return new BaseVisitor() {
      @Override
      protected Stream<Expression> onVisit(Expression current, Stream<Expression> terms) {
        return Stream.concat(terms.flatMap(this::onVisit), Stream.of(current));
      }
    };
  }

  private static abstract class BaseVisitor extends ExpressionVisitor {
    @Override
    protected final Stream<Expression> onVisit(Expression current) {
      List<Expression> terms = current.terms();

      if (terms.isEmpty())
        return Stream.of(current);

      return onVisit(current, terms.stream());
    }

    protected abstract Stream<Expression> onVisit(Expression current, Stream<Expression> terms);
  }
}
