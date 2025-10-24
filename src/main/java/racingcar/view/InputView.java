package racingcar.view;

import racingcar.console.ConsoleReader;

public class InputView {
    public String requestLine() {
        return ConsoleReader.enterMessage();
    }
}
