package racingcar.console;

import camp.nextstep.edu.missionutils.Console;
import racingcar.global.CustomArgumentException;
import racingcar.global.constans.ErrorMessage;

public class ConsoleReader {
    public static String enterMessage() {
        return Validator.validateBlank(Console.readLine());
    }

    private static class Validator {
        public static String validateBlank(String message) {
            if (message.isBlank()) {
                throw CustomArgumentException.from(ErrorMessage.BLANK_INPUT_ERROR);
            }
            return message;
        }
    }
}
