package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.global.CustomArgumentException;
import racingcar.global.constans.ErrorMessage;

public class InputView {

    public String enterMessage() {
        return Validator.validateName(Console.readLine());
    }

    public int enterCount() {
        return Integer.parseInt(Validator.validateCount(Console.readLine()));
    }

    private static class Validator {

        public static String validateName(String message) {
            validateBlank(message);
            return message;
        }

        public static String validateCount(String message) {
            validateBlank(message);
            validateNumberFormat(message);
            validateCountRange(message);
            return message;
        }

        private static void validateBlank(String message) {
            if (message.isBlank()) {
                throw CustomArgumentException.from(ErrorMessage.BLANK_INPUT_ERROR);
            }
        }

        private static void validateNumberFormat(String message) {
            if (!message.matches("\\d+")) {
                throw CustomArgumentException.from(ErrorMessage.NUMBER_FORMAT_ERROR);
            }
        }

        private static void validateCountRange(String message) {
            if (Integer.parseInt(message) <= 0) {
                throw CustomArgumentException.from(ErrorMessage.COUNT_RANGE_ERROR);
            }
        }
    }
}
