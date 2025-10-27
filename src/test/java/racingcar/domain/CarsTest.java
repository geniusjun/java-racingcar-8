package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static racingcar.global.constans.NumberType.ADVANCE_SIZE;

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
    void withDuplicateNames_throwsException() {
        // given
        String input = "pobi,pobi";

        // when // then
        assertThatThrownBy(() -> Cars.from(input))
                .isInstanceOf(CustomArgumentException.class)
                .hasMessageContaining(ErrorMessage.NAME_DUPLICATE_ERROR.getMessage());
    }

    @Test
    @DisplayName("tryAdvance: 1턴 후 각 차의 전진값은 {0, ADVANCE_SIZE} 중 하나이다")
    void tryAdvance_oneTurn_eachAdvanceIsZeroOrStep() {
        // given
        Cars cars = Cars.from("a,b,c");

        // when
        cars.tryAdvance();

        // then
        int step = ADVANCE_SIZE.getValue();
        assertThat(cars.stream().map(Car::getAdvance).toList())
                .allSatisfy(a -> assertThat(a).isIn(0, step));
    }

    @Test
    @DisplayName("tryAdvance: 여러 턴 후 각 차의 전진값은 ADVANCE_SIZE의 배수이며 0~(턴*ADVANCE_SIZE) 범위이다")
    void tryAdvance_multiTurn_advancesAreMultipleAndWithinRange() {
        // given
        Cars cars = Cars.from("a,b,c");
        int turns = 5;
        int step = ADVANCE_SIZE.getValue();

        // when
        for (int i = 0; i < turns; i++) {
            cars.tryAdvance();
        }

        // then
        int maxPossible = turns * step;
        cars.stream()
                .forEach(car -> {
                    int a = car.getAdvance();
                    assertThat(a % step).isZero();
                    assertThat(a).isBetween(0, maxPossible);
                });
    }

    @Test
    @DisplayName("getWinners: 단일 우승자 이름을 반환한다(수동 전진)")
    void getWinners_returnsSingleWinner_withManualAdvances() {
        // given
        Cars cars = Cars.from("a,b,c");
        advanceNTimes(carByName(cars, "a"), 2); // a는 2칸 전진
        advanceNTimes(carByName(cars, "b"), 1); // b는 1칸 전진

        // when
        List<String> winners = cars.getWinners();

        // then
        assertThat(winners).containsExactly("a");
    }

    @Test
    @DisplayName("getWinners: 복수 우승자 이름을 반환한다(수동 전진)")
    void getWinners_returnsMultipleWinner_withManualAdvances() {
        // given
        Cars cars = Cars.from("a,b,c");
        advanceNTimes(carByName(cars, "a"), 2); // a 2칸 전진
        advanceNTimes(carByName(cars, "b"), 2); // b 2칸 전진

        // when
        List<String> winners = cars.getWinners();

        // then
        assertThat(winners).containsExactly("a", "b");
    }

    // 테스트 헬퍼 메서드
    private static Car carByName(Cars cars, String name) {
        return cars.stream()
                .filter(c
                        -> c.getName()
                        .equals(name)).findFirst().orElseThrow();
    }

    // 테스트 헬퍼 메서드
    private static void advanceNTimes(Car car, int times) {
        for (int i = 0; i < times; i++) {
            car.move();
        }
    }
}