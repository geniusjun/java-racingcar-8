package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    public static Cars from(String input) {
        return new Cars(parseCars(input));
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

    public List<String> getWinners() {
        return cars.stream()
                .filter(c -> c.getAdvance() == getMax())
                .map(Car::getName)
                .toList();
    }

    private int getMax() {
        return cars.stream()
                .mapToInt(Car::getAdvance)
                .max()
                .orElse(0);
    }

    private static List<Car> parseCars(String input) {
        return Arrays.stream(input.split(",", -1))
                .map(Car::from)
                .toList();
    }

}
