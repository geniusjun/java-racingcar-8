package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;

public class InputTest {

    private void setStdin(String s) {
        System.setIn(new ByteArrayInputStream(s.getBytes()));
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }

}
