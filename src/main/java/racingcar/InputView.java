package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String DELIMITER = ",";

    public List<String> inputCarNames() {
        String input = Console.readLine();
        return parseCarNames(input);
    }

    public int inputAttemptCount() {
        String input = Console.readLine();
        return parseAttemptCount(input);
    }

    private List<String> parseCarNames(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }

    private int parseAttemptCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }
}
