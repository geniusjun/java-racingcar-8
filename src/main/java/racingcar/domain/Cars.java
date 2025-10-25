package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    public static Cars from(String input) {
        return new Cars(Parser.split(input));
    }

    public Stream<Car> stream() {
        return cars.stream();
    }

    public void tryAdvance() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.plusAdvance();
            }
        }
    }

    public List<String> advanceResults() {
        List<String> results = new ArrayList<>();
        for (Car car : cars) {
            results.add(car.toString());
        }
        return results;
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
