package racingcar.domain;

import racingcar.global.ErrorMessage;

public class Car {
    private final String name;
    private int advance;

    private Car(String name) {
        this.name = name;
        this.advance = 0;
    }

    public static Car from(String name) {
        validateName(name);
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getAdvance() {
        return advance;
    }

    public void plusAdvance() {
        this.advance++;
    }

    private static void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
        }
    }
}
