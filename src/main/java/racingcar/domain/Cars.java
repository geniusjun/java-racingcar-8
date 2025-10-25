package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    public static Cars from(String input) {
        return new Cars(Parser.split(input));
    }

    private static class Parser {
        public static List<Car> split(String input) {
            List<String> names = Arrays.stream(input.split(",")).toList();
            return makeCars(names);
        }

        private static List<Car> makeCars(List<String> names) {
            List<Car> carList = new ArrayList<>();
            for (String name : names) {
                carList.add(Car.from(name));
            }
            return carList;
        }
    }
}
