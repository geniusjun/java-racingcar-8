package racingcar.view;

import racingcar.domain.Cars;

public class OutputView {

    public void printStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAdvance() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResult() {
        System.out.println("실행 결과");
    }

    public void printEachCarResult(String name, int advance) {
        System.out.print(name + " : ");
        System.out.print("-".repeat(advance));
        System.out.println();
    }

    public void printEnter() {
        System.out.println();
    }

    public void printWinner(Cars cars) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < cars.getCars().size(); i++) {
            if (i == cars.getCars().size() - 1) {
                System.out.print(cars.getCars().get(i).getName());
            }
            System.out.print(cars.getCars().get(i).getName() + ", ");
        }
    }
}
