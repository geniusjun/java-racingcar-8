package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Car 도메인 테스트")
class CarTest {

    @Test
    @DisplayName("정상 이름으로 생성 시 advance는 0이다")
    void createWithValidName_setsAdvanceZero() {
        // given
        String name = "pobi";

        // when
        Car car = Car.from(name);

        // then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getAdvance()).isZero();
    }

}