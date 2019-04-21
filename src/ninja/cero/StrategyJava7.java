package ninja.cero;

import java.util.ArrayList;
import java.util.List;

public class StrategyJava7 {
    Selector selector;

    StrategyJava7(Selector selector) {
        this.selector = selector;
    }

    void execute(List<Integer> values) {
        System.out.println(selector.select(values));
    }

    interface Selector {
        List<Integer> select(List<Integer> values);
    }

    static class Selectors {
        static Selector oddSelector() {
            return new OddSelector();
        }

        static Selector evenSelector() {
            return new EvenSelector();
        }

        static Selector positiveSelector() {
            return new PositiveSelector();
        }

        static Selector negativeSelector() {
            return new NegativeSelector();
        }
    }

    private static class OddSelector implements Selector {
        @Override
        public List<Integer> select(List<Integer> values) {
            List<Integer> result = new ArrayList<>();

            for (Integer value : values) {
                if (value % 2 == 1) {
                    result.add(value);
                }
            }

            return result;
        }
    }

    private static class EvenSelector implements Selector {
        @Override
        public List<Integer> select(List<Integer> values) {
            List<Integer> result = new ArrayList<>();

            for (Integer value : values) {
                if (value % 2 == 0) {
                    result.add(value);
                }
            }

            return result;
        }
    }

    private static class PositiveSelector implements Selector {
        @Override
        public List<Integer> select(List<Integer> values) {
            List<Integer> result = new ArrayList<>();

            for (Integer value : values) {
                if (value > 0) {
                    result.add(value);
                }
            }

            return result;
        }
    }

    private static class NegativeSelector implements Selector {
        @Override
        public List<Integer> select(List<Integer> values) {
            List<Integer> result = new ArrayList<>();

            for (Integer value : values) {
                if (value < 0) {
                    result.add(value);
                }
            }

            return result;
        }
    }
}
