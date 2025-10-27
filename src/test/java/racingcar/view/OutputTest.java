package racingcar.view;

import java.util.List;

public class OutputTest {

    // 테스트 헬퍼 메서드(출력 문자열 가정)
    private String formatResult(String name, int advance) {
        return name + " : " + "-".repeat(advance);
    }

    // 테스트 헬퍼 메서드
    private String formatWinners(List<String> winners) {
        return String.join(", ", winners);
    }
    
}
