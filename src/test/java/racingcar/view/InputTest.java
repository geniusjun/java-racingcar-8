package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.global.exceptions.CustomArgumentException;
import racingcar.global.exceptions.ErrorMessage;

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

    @Test
    @DisplayName("이름 입력: 빈 문자열이면 예외")
    void enterMessage_blank_throw() {
        // given
        setStdin("\n");
        InputView view = new InputView();

        // when // then
        Assertions.assertThatThrownBy(() -> view.enterMessage())
                .isInstanceOf(CustomArgumentException.class)
                .hasMessageContaining(ErrorMessage.BLANK_INPUT_ERROR.getMessage());
    }

    @Test
    @DisplayName("이동 횟수: 숫자면 정수로 파싱되어 반환된다")
    void enterCount_ok() {
        // given
        setStdin("5\n");
        InputView view = new InputView();

        // when
        int actual = view.enterCount();

        // then
        assertEquals(5, actual);
    }

    @Test
    @DisplayName("이동 횟수: 숫자 형식이 아니면 예외")
    void enterCount_notNumber_throw() {
        // given
        setStdin("5a\n");
        InputView view = new InputView();

        // when // then
        Assertions.assertThatThrownBy(() -> view.enterCount())
                .isInstanceOf(CustomArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_FORMAT_ERROR.getMessage());
    }

    @Test
    @DisplayName("이동 횟수: 0 이하면 예외")
    void enterCount_nonPositive_throw() {
        // given
        setStdin("-1\n");
        InputView view = new InputView();

        // when // then
        Assertions.assertThatThrownBy(() -> view.enterCount())
                .isInstanceOf(CustomArgumentException.class)
                .hasMessageContaining(ErrorMessage.COUNT_RANGE_ERROR.getMessage());
    }
}
