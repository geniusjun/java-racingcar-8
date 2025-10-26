package racingcar.domain;

import static racingcar.global.constans.NumberType.ADVANCE_SIZE;
import static racingcar.global.constans.NumberType.NAME_MAX_LENGTH;

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
        advance += ADVANCE_SIZE.getValue();
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
            if (name.length() > NAME_MAX_LENGTH.getValue()) {
                throw CustomArgumentException.from(ErrorMessage.NAME_LENGTH_ERROR);
            }
        }
    }
}
