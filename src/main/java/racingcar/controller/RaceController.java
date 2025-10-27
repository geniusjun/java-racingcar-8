package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.global.constans.MessageType;
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
        Cars cars = createCars();
        int count = getCount();
        raceAndResult(count, cars);
        requestWinner(cars);
    }

    private Cars createCars() {
        outputView.printlnMessage(MessageType.START_MESSAGE);
        return Cars.from(inputView.enterMessage());
    }

    private int getCount() {
        outputView.printlnMessage(MessageType.ADVANCE_MESSAGE);
        return inputView.enterCount();
    }

    private void raceAndResult(int count, Cars cars) {
        outputView.printlnMessage(MessageType.RESULT_MESSAGE);
        while (count-- > 0) {
            cars.tryAdvance();
            requestResult(cars);
        }
    }

    private void requestResult(Cars cars) {
        cars.stream()
                .forEach(car -> outputView.printResult(car.getName(), car.getAdvance()));
        outputView.printlnMessage(MessageType.EMPTY_MESSAGE);
    }

    private void requestWinner(Cars cars) {
        outputView.printMessage(MessageType.WINNER_MESSAGE);
        outputView.printWinner(cars.getWinners());
    }
}
