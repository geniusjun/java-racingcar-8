package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.global.constans.MessageType;
import racingcar.view.View;

public class RaceController {

    private final View view;

    public RaceController(View view) {
        this.view = view;
    }

    public void start() {
        view.printlnMessage(MessageType.START_MESSAGE);
        Cars cars = Cars.from(view.enterMessage());

        view.printlnMessage(MessageType.ADVANCE_MESSAGE);
    }
}
