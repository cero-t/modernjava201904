package ninja.cero;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StrategyMoreLambda {
    Selector selector;

    StrategyMoreLambda(Selector selector) {
        this.selector = selector;
    }

    void execute(List<Integer> values) {
        System.out.println(selector.select(values));
    }

    @FunctionalInterface
    interface Selector {
        List<Integer> select(List<Integer> values);
    }

    static class Selectors {
        static Selector of(Predicate<Integer> predicate) {
            return values -> values.stream()
                    .filter(predicate)
                    .collect(Collectors.toList());
        }

        static Selector oddSelector() {
            return of(i -> i % 2 == 1);
        }

        static Selector evenSelector() {
            return of(i -> i % 2 == 0);
        }

        static Selector positiveSelector() {
            return of(i -> i > 0);
        }

        static Selector negativeSelector() {
            return of(i -> i < 0);
        }
    }
}
