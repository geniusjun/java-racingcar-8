package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readLine() {
        return Console.readLine();
    }

    public Integer readAdvance() {
        return Integer.parseInt(Console.readLine());
    }
}
