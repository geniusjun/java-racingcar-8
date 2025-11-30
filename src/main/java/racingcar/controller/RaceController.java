package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStart();
        Cars cars = makeCars(inputView.readLine());
        outputView.printAdvance();
        int attempt = inputView.readAdvance();
        while (attempt-- > 0) {

        }
    }

    private Cars makeCars(String input) {
        String[] names = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            cars.add(Car.from(names[i]));
        }
        return Cars.from(cars);
    }

}
