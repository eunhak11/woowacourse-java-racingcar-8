package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

class InputValidatorTest {

    private InputValidator validator;

    @BeforeEach
    void setUp() {
        validator = new InputValidator();
    }

    @Test
    @DisplayName("정상적인 자동차 이름 검증 - 성공")
    void validateValidCarNames() {
        List<String> names = Arrays.asList("pobi", "woni", "jun");

        assertThatCode(() -> validator.validateCarNames(names))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("빈 자동차 이름 검증 - 예외 발생")
    void validateEmptyCarName() {
        List<String> names = Arrays.asList("pobi", "", "jun");

        assertThatThrownBy(() -> validator.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("공백 자동차 이름 검증 - 예외 발생")
    void validateBlankCarName() {
        List<String> names = Arrays.asList("pobi", "   ", "jun");

        assertThatThrownBy(() -> validator.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("null 자동차 이름 검증 - 예외 발생")
    void validateNullCarName() {
        List<String> names = Arrays.asList("pobi", null, "jun");

        assertThatThrownBy(() -> validator.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("5자 초과 자동차 이름 검증 - 예외 발생")
    void validateCarNameExceedsMaxLength() {
        List<String> names = Arrays.asList("pobi", "verylongname", "jun");

        assertThatThrownBy(() -> validator.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("중복된 자동차 이름 검증 - 예외 발생")
    void validateDuplicateCarNames() {
        List<String> names = Arrays.asList("pobi", "woni", "pobi");

        assertThatThrownBy(() -> validator.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("정상적인 시도 횟수 검증 - 성공")
    void validateValidAttemptCount() {
        assertThatCode(() -> validator.validateAttemptCount(5))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("0 이하의 시도 횟수 검증 - 예외 발생")
    void validateZeroAttemptCount() {
        assertThatThrownBy(() -> validator.validateAttemptCount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("음수 시도 횟수 검증 - 예외 발생")
    void validateNegativeAttemptCount() {
        assertThatThrownBy(() -> validator.validateAttemptCount(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
