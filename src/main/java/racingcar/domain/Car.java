package racingcar.domain;

import racingcar.global.CustomArgumentException;
import racingcar.global.constans.ErrorMessage;

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

    public void plusAdvance() {
        this.advance++;
    }

    @Override
    public String toString() {
        return name + " : " + ("-").repeat(advance);
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
