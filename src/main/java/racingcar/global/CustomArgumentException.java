package racingcar.global;

import racingcar.global.constans.ErrorMessage;

public class CustomArgumentException extends IllegalArgumentException {
    private static final String PREFIX = "[ERROR] ";

    private CustomArgumentException(ErrorMessage message) {
        super(PREFIX + message.getMessage());
    }

    public static CustomArgumentException from(ErrorMessage errorMessage) {
        return new CustomArgumentException(errorMessage);
    }
}
