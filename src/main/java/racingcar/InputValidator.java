package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String EMPTY_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름은 공백일 수 없습니다.";
    private static final String NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자 이하만 가능합니다.";
    private static final String DUPLICATE_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름은 중복될 수 없습니다.";
    private static final String INVALID_ATTEMPT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양의 정수여야 합니다.";

    public void validateCarNames(List<String> names) {
        validateNamesNotEmpty(names);
        validateNamesLength(names);
        validateNamesNotDuplicated(names);
    }

    private void validateNamesNotEmpty(List<String> names) {
        for (String name : names) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
            }
        }
    }

    private void validateNamesLength(List<String> names) {
        for (String name : names) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }

    private void validateNamesNotDuplicated(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }

    public void validateAttemptCount(int attemptCount) {
        if (attemptCount <= 0) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_ERROR_MESSAGE);
        }
    }
}
