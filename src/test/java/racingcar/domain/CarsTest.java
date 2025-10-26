package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.global.exceptions.CustomArgumentException;
import racingcar.global.exceptions.ErrorMessage;

@DisplayName("Cars 도메인 테스트")
class CarsTest {
    @Test
    @DisplayName("입력 문자열을 콤마로 파싱해 Car 리스트를 생성한다. 비교는 자동차의 이름으로 비교한다.")
    void from_parsesInputToCars() {
        // given
        String input = "pobi,woni,jun";

        // when
        Cars cars = Cars.from(input);
        List<String> carList = cars
                .stream()
                .map(Car::getName)
                .toList();
        // then
        assertThat(carList)
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("차량 수가 최소 개수 미만이면 예외를 던진다. 1대라면 경주의 의미가 희미해진다.")
    void LessThanMinCars_throwsException() {
        // given
        String input = "pobi"; // 1대 → 최소(2) 미만

        // when // then
        assertThatThrownBy(() -> Cars.from(input))
                .isInstanceOf(CustomArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_SIZE_ERROR.getMessage());
    }

    @Test
    @DisplayName("이름이 중복되면 예외를 던진다")
    void from_withDuplicateNames_throwsException() {
        // given
        String input = "pobi,pobi";

        // when // then
        assertThatThrownBy(() -> Cars.from(input))
                .isInstanceOf(CustomArgumentException.class)
                .hasMessageContaining(ErrorMessage.NAME_DUPLICATE_ERROR.getMessage());
    }
}