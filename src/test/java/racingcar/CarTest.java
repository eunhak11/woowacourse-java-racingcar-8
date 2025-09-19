package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차 생성 테스트")
    void createCarWithNameAndInitialPosition() {
        Car car = new Car("pobi");

        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 전진 테스트 : 랜덤값이 4 이상일 때")
    void moveForwardWhenRandomValueIsGreaterThanOrEqualTo4() {
        Car car = new Car("pobi");

        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 정지 테스트 : 랜덤값이 4 미만일 때")
    void stayWhenRandomValueIsLessThan4() {
        Car car = new Car("pobi");

        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 여러번 전진 테스트")
    void moveMultipleTimes() {
        Car car = new Car("pobi");

        car.move(4);
        car.move(5);
        car.move(3);
        car.move(9);

        assertThat(car.getPosition()).isEqualTo(3);
    }
}
