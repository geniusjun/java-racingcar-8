package racingcar.controller;

import racingcar.view.OutputView;

public class RaceController {

    private final OutputView outputView;

    public RaceController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void start() {
        outputView.start();
    }
}
