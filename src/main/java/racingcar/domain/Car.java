package racingcar.domain;

import racingcar.global.CustomArgumentException;
import racingcar.global.ErrorMessage;

public class Car {
    private final String name;
    private int advance;

    private Car(String name) {
        this.name = name;
        this.advance = 0;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    private static class Validator {
        public static String validate(String name) {
            validateBlankName(name);
            return name;
        }

        private static void validateBlankName(String name) {
            if (name.isBlank()) {
                throw CustomArgumentException.from(ErrorMessage.BLANK_INPUT_ERROR);
            }
        }
    }
}
