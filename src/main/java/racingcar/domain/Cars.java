package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import racingcar.global.exceptions.CustomArgumentException;
import racingcar.global.exceptions.ErrorMessage;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    public static Cars from(String input) {
        return new Cars(Validator.validate(parseCars(input)));
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

    private static class Validator {
        public static List<Car> validate(List<Car> cars) {
            validateSize(cars);
            validateDuplicateNames(cars);
            return cars;
        }

        private static void validateSize(List<Car> cars) {
            if (cars.size() < 2) {
                throw CustomArgumentException.from(ErrorMessage.CAR_SIZE_ERROR);
            }
        }

        private static void validateDuplicateNames(List<Car> cars) {
            if (hasDuplicateNames(cars)) {
                throw CustomArgumentException.from(ErrorMessage.NAME_DUPLICATE_ERROR);
            }
        }

        private static boolean hasDuplicateNames(List<Car> cars) {
            int uniqueSize = countUniqueCarNames(cars);
            return uniqueSize != cars.size();
        }

        private static int countUniqueCarNames(List<Car> cars) {
            return (int) cars.stream()
                    .map(Car::getName)
                    .distinct()
                    .count();
        }

    }

}

