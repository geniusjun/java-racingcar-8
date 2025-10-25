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

    public void printList(List<String> list) {
        for (String string : list) {
            System.out.println(string);
        }
        System.out.println();
    }

    public String enterMessage() {
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


