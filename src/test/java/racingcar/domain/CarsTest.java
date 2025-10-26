package racingcar.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}