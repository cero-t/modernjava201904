package ninja.cero;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        strategyJava7();
        strategyLambda();
        strategyMoreLambda();
    }

    static void strategyJava7() {
        List<Integer> numbers = List.of(3, 1, -4, 1, -5, 9, -2, 6, 5, 3, 5);

        StrategyJava7 sample = new StrategyJava7(StrategyJava7.Selectors.positiveSelector());
        sample.execute(numbers);

        StrategyJava7 sample2 = new StrategyJava7(StrategyJava7.Selectors.evenSelector());
        sample2.execute(numbers);
    }

    static void strategyLambda() {
        List<Integer> numbers = List.of(3, 1, -4, 1, -5, 9, -2, 6, 5, 3, 5);

        StrategyLambda sample = new StrategyLambda(StrategyLambda.Selectors.positiveSelector());
        sample.execute(numbers);

        StrategyLambda sample2 = new StrategyLambda(values ->
                values.stream()
                        .filter(i -> i % 3 == 0)
                        .collect(Collectors.toList()));
        sample2.execute(numbers);
    }

    static void strategyMoreLambda() {
        List<Integer> numbers = List.of(3, 1, -4, 1, -5, 9, -2, 6, 5, 3, 5);

        StrategyMoreLambda sample = new StrategyMoreLambda(StrategyMoreLambda.Selectors.positiveSelector());
        sample.execute(numbers);

        StrategyMoreLambda sample2 = new StrategyMoreLambda(StrategyMoreLambda.Selectors.of(i -> i % 3 == 0));
        sample2.execute(numbers);
    }

}
