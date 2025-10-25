package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    public static Cars from(String input) {
        new Cars(Arrays.asList(Car.from(input))); // 임시
    }
}
