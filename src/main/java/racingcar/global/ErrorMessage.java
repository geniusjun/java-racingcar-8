package racingcar.global;

public enum ErrorMessage {
    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    NAME_BLANK_ERROR("자동차 이름은 빈 값을 허용하지 않습니다."),
    NAME_LENGTH_ERROR("자동차의 이름은 이름은 5자 이하만 가능합니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
