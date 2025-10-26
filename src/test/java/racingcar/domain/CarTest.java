package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.global.exceptions.CustomArgumentException;
import racingcar.global.exceptions.ErrorMessage;

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

    @Test
    @DisplayName("이름이 공백/빈 문자열이면 예외를 던진다")
    void createWithBlankName_throwsException() {
        // given
        String blanks = "   ";
        String empty = "";

        // when // then
        assertThatThrownBy(() -> Car.from(blanks))
                .isInstanceOf(CustomArgumentException.class)
                .hasMessageContaining(ErrorMessage.BLANK_INPUT_ERROR.getMessage());

        assertThatThrownBy(() -> Car.from(empty))
                .isInstanceOf(CustomArgumentException.class)
                .hasMessageContaining(ErrorMessage.BLANK_INPUT_ERROR.getMessage());
    }
}