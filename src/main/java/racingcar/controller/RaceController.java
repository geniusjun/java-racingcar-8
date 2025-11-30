package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
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
        outputView.printResult();
        while (attempt-- > 0) {
            advanceCars(cars);
            showResult(cars);
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

    private void advanceCars(Cars cars) {
        for (int i = 0; i < cars.getCars().size(); i++) {
            int ranNum = Randoms.pickNumberInRange(0, 9);
            if (ranNum >= 4) {
                cars.getCars().get(i).plusAdvance();
            }
        }
    }

    private void showResult(Cars cars) {
        for (int i = 0; i < cars.getCars().size(); i++) {
            outputView.printEachCarResult(cars.getCars().get(i).getName(), cars.getCars().get(i).getAdvance());
        }
        outputView.printEnter();
    }

}
