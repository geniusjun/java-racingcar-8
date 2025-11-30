package racingcar.view;

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
}
