package racingcar.global.constans;

public enum MessageType {
    EMPTY_MESSAGE(""),
    START_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ADVANCE_MESSAGE("시도할 횟수는 몇 회인가요?"),
    RESULT_MESSAGE("실행 결과"),
    WINNER_MESSAGE("최종 우승자 :"),
    ;

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
