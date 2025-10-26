package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RaceController;
import racingcar.view.View;

public class Application {
    public static void main(String[] args) {
        RaceController raceController = new RaceController(new View());
        raceController.start();
        Console.close();
    }
}
