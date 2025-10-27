package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.global.constans.NumberType.ADVANCE_SIZE;
import static racingcar.global.constans.NumberType.NAME_MAX_LENGTH;

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

    @Test
    @DisplayName("이름 길이가 최대 길이를 초과하면 예외를 던진다")
    void createWithTooLongName_throwsException() {
        // given
        String over = "a".repeat(NAME_MAX_LENGTH.getValue() + 1);

        // when // then
        assertThatThrownBy(() -> Car.from(over))
                .isInstanceOf(CustomArgumentException.class)
                .hasMessageContaining(ErrorMessage.NAME_LENGTH_ERROR.getMessage());
    }

    @Test
    @DisplayName("plusAdvance() 호출 시 ADVANCE_SIZE만큼 전진한다")
    void plusAdvance_increaseByAdvanceSize() {
        // given
        Car car = Car.from("pobi");

        // when
        car.move();
        int afterOne = car.getAdvance();
        car.move();
        int afterTwo = car.getAdvance();

        // then
        assertThat(afterOne).isEqualTo(ADVANCE_SIZE.getValue());
        assertThat(afterTwo).isEqualTo(ADVANCE_SIZE.getValue() * 2);
    }
}