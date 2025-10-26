package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.global.CustomArgumentException;
import racingcar.global.constans.ErrorMessage;
import racingcar.global.constans.MessageType;

public class View {

    public void printlnMessage(MessageType messageType) {
        System.out.println(messageType.getMessage());
    }

    public void printMessage(MessageType messageType) {
        System.out.print(messageType.getMessage());
    }

    public void printResult(String name, int advance) {
        System.out.println(name + " : " + "-".repeat(advance));
    }

    public void printWinner(List<String> list) {
        System.out.println(String.join(", ", list));
    }

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
    }
}


