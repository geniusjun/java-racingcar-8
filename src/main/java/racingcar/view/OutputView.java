package racingcar.view;

import java.util.List;
import racingcar.global.constans.MessageType;

public class OutputView {
    private static final String RESULT_DELIMITER = " : ";
    private static final String RESULT_POSITION_UNIT = "-";
    private static final String FINAL_RESULT_DELIMITER = ", ";

    public void printlnMessage(MessageType messageType) {
        System.out.println(messageType.getMessage());
    }

    public void printMessage(MessageType messageType) {
        System.out.print(messageType.getMessage());
    }

    public void printResult(String name, int advance) {
        System.out.println(name + RESULT_DELIMITER + RESULT_POSITION_UNIT.repeat(advance));
    }

    public void printWinner(List<String> list) {
        System.out.println(String.join(FINAL_RESULT_DELIMITER, list));
    }
}


