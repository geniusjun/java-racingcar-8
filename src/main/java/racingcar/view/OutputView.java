package racingcar.view;

import java.util.List;
import racingcar.global.constans.MessageType;

public class OutputView {

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
}


