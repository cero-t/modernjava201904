package ninja.cero;

import java.util.List;
import java.util.stream.Collectors;

public class StrategyLambda {
    Selector selector;

    StrategyLambda(Selector selector) {
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
        static Selector oddSelector() {
            return values -> values.stream()
                    .filter(i -> i % 2 == 1)
                    .collect(Collectors.toList());
        }

        static Selector evenSelector() {
            return values -> values.stream()
                    .filter(i -> i % 2 == 0)
                    .collect(Collectors.toList());
        }

        static Selector positiveSelector() {
            return values -> values.stream()
                    .filter(i -> i > 0)
                    .collect(Collectors.toList());
        }

        static Selector negativeSelector() {
            return values -> values.stream()
                    .filter(i -> i < 0)
                    .collect(Collectors.toList());
        }
    }
}
