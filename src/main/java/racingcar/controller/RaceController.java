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
        int count = getCount();
        raceAndResult(count, cars);
        requestWinner(cars);

    }

    private Cars makeCars() {
        view.printlnMessage(MessageType.START_MESSAGE);
        return Cars.from(view.enterMessage());
    }

    private int getCount() {
        view.printlnMessage(MessageType.ADVANCE_MESSAGE);
        try {
            return Integer.parseInt(view.enterMessage());
        } catch (NumberFormatException e) {
            throw CustomArgumentException.from(ErrorMessage.SYSTEM_ERROR);
        }
    }

    private void raceAndResult(int count, Cars cars) {
        view.printlnMessage(MessageType.RESULT_MESSAGE);
        while (count-- > 0) {
            cars.tryAdvance();
            requestResult(cars);
        }
    }

    private void requestResult(Cars cars) {
        cars.stream()
                .forEach(car -> view.printResult(car.getName(), car.getAdvance()));
        view.printlnMessage(MessageType.EMPTY_MESSAGE);
    }

    private void requestWinner(Cars cars) {
        view.printMessage(MessageType.WINNER_MESSAGE);
        view.printWinner(cars.getWinners());
    }
}
