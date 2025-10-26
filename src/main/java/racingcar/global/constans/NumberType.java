package racingcar.global.constans;

public enum NumberType {
    NAME_MAX_LENGTH(5),
    MIN_CAR_SIZE(2),
    MIN_FORWARD_FLAG(4),
    ADVANCE_SIZE(1),
    MIN_RANDOM_NUMBER(0),
    MAX_RANDOM_NUMBER(9),
    ZERO(0),
    MINUS_ONE(-1);
    private final Integer value;

    NumberType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
