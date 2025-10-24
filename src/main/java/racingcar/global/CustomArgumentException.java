package racingcar.global;

public class CustomArgumentException extends IllegalArgumentException {

    private CustomArgumentException(ErrorMessage message) {
        super(message.getMessage());
    }

    public static CustomArgumentException from(ErrorMessage errorMessage) {
        return new CustomArgumentException(errorMessage);
    }
}
