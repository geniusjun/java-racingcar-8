package racingcar.domain;

import racingcar.global.exceptions.CustomArgumentException;
import racingcar.global.exceptions.ErrorMessage;

public class Car {
    private final String name;
    private int advance;

    private Car(String name) {
        this.name = name;
        this.advance = 0;
    }

    public static Car from(String name) {
        return new Car(Validator.validate(name));
    }

    public String getName() {
        return this.name;
    }

    public int getAdvance() {
        return this.advance;
    }

    public void plusAdvance() {
        this.advance++;
    }

    private static class Validator {
        public static String validate(String name) {
            validateBlankName(name);
            validateNameLength(name);
            return name;
        }

        private static void validateBlankName(String name) {
            if (name.isBlank()) {
                throw CustomArgumentException.from(ErrorMessage.BLANK_INPUT_ERROR);
            }
        }

        private static void validateNameLength(String name) {
            if (name.length() > 5) {
                throw CustomArgumentException.from(ErrorMessage.NAME_LENGTH_ERROR);
            }
        }
    }
}
