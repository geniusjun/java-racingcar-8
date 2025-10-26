package racingcar.global.constans;

public enum NumberType {
    NAME_MAX_LENGTH(5);
    private final Integer value;

    NumberType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
