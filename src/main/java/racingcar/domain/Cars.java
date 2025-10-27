package racingcar.domain;

import static racingcar.global.constans.NumberType.MAX_RANDOM_NUMBER;
import static racingcar.global.constans.NumberType.MINUS_ONE;
import static racingcar.global.constans.NumberType.MIN_CAR_SIZE;
import static racingcar.global.constans.NumberType.MIN_FORWARD_FLAG;
import static racingcar.global.constans.NumberType.MIN_RANDOM_NUMBER;
import static racingcar.global.constans.NumberType.ZERO;

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
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER.getValue(), MAX_RANDOM_NUMBER.getValue());
            if (randomNumber >= MIN_FORWARD_FLAG.getValue()) {
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
                .orElse(ZERO.getValue());
    }

    private static List<Car> parseCars(String input) {
        return Arrays.stream(input.split(",", MINUS_ONE.getValue()))
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
            if (cars.size() < MIN_CAR_SIZE.getValue()) {
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

