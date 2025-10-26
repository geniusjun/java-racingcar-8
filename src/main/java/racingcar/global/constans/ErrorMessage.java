package racingcar.global.constans;

public enum ErrorMessage {
    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    NAME_BLANK_ERROR("자동차 이름은 빈 값을 허용하지 않습니다."),
    NAME_LENGTH_ERROR("자동차의 이름은 이름은 5자 이하만 가능합니다."),
    NAME_DUPLICATE_ERROR("자동차의 이름이 중복됩니다."),
    CAR_SIZE_ERROR("자동차는 최소 2대 이상이여야 경주가 가능합니다."),
    SYSTEM_ERROR("알 수 없는 오류입니다."),
    ;
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
