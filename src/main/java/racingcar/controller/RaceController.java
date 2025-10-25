package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.global.CustomArgumentException;
import racingcar.global.constans.ErrorMessage;
import racingcar.global.constans.MessageType;
import racingcar.view.View;

public class RaceController {

    private final View view;

    public RaceController(View view) {
        this.view = view;
    }

    public void start() {
        Cars cars = makeCars();
        int count = advanceCount();
        while (count-- > 0) {

        }

    }

    private Cars makeCars() {
        view.printlnMessage(MessageType.START_MESSAGE);
        return Cars.from(view.enterMessage());
    }

    private int advanceCount() {
        view.printlnMessage(MessageType.ADVANCE_MESSAGE);
        try {
            return Integer.parseInt(view.enterMessage());
        } catch (NumberFormatException e) {
            throw CustomArgumentException.from(ErrorMessage.SYSTEM_ERROR);
        }
    }
}
