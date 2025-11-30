package racingcar.global;

public enum ErrorMessage {
    INVALID_NAME_LENGTH("자동차의 이름은 5글자 이하여야 합니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}