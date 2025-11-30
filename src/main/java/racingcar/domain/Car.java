package racingcar.domain;

public class Car {
    private final String name;
    private int advance;

    private Car(String name) {
        this.name = name;
        this.advance = 0;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }
}
