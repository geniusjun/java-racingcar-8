package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final OutputView outputView;
    private final InputView inputView;

    public RaceController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        outputView.printStart();
        Cars cars = Cars.from(inputView.requestLine());
    }
}
