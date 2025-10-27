package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

    private void setStdin(String s) {
        System.setIn(new ByteArrayInputStream(s.getBytes()));
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Test
    @DisplayName("이름 입력: 정상 문자열을 그대로 반환한다")
    void enterMessage_ok() {
        // given
        setStdin("pobi,woni\n");
        InputView view = new InputView();

        // when
        String names = view.enterMessage();

        // then
        assertEquals("pobi,woni", names);
    }
}
