package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputTest {

    // 테스트 헬퍼 메서드(OutputView와 똑같은 문자열 구성)
    private String formatResult(String name, int advance) {
        return name + " : " + "-".repeat(advance);
    }

    // 테스트 헬퍼 메서드
    private String formatWinners(List<String> winners) {
        return String.join(", ", winners);
    }

    @Test
    @DisplayName("결과 포맷: 이름 + ' : ' + '-' 반복")
    void resultFormat_basic() {
        // given
        String name = "pobi";
        int advance = 3;

        // when
        String formatted = formatResult(name, advance);

        // then
        assertEquals("pobi : ---", formatted);
    }

    @Test
    @DisplayName("우승자 포맷: 쉼표+공백으로 연결")
    void winnersFormat_basic() {
        // given
        List<String> winners = List.of("pobi", "woni", "jun");

        // when
        String formatted = formatWinners(winners);

        // then
        assertEquals("pobi, woni, jun", formatted);
    }
}
