package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("자동차 이름 리스트로 RacingGame 생성")
    void createRacingGameWithCarNames() {
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        RacingGame game = new RacingGame(carNames);

        assertThat(game.getCars()).hasSize(3);
    }

    @Test
    @DisplayName("한 라운드 진행 후 자동차들의 위치 변경")
    void playOneRound() {
        List<String> carNames = Arrays.asList("pobi", "woni");
        RacingGame game = new RacingGame(carNames);

        game.playRound();

        List<Car> cars = game.getCars();
        assertThat(cars.get(0).getPosition()).isGreaterThanOrEqualTo(0);
        assertThat(cars.get(1).getPosition()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("우승자 찾기 - 단독 우승")
    void findSingleWinner() {
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        RacingGame game = new RacingGame(carNames);

        game.getCars().get(0).move(4);
        game.getCars().get(0).move(5);
        game.getCars().get(1).move(4);
        game.getCars().get(2).move(3);

        List<String> winners = game.findWinners();

        assertThat(winners).containsExactly("pobi");
    }

    @Test
    @DisplayName("우승자 찾기 - 공동 우승")
    void findMultipleWinners() {
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        RacingGame game = new RacingGame(carNames);

        game.getCars().get(0).move(4);
        game.getCars().get(0).move(5);
        game.getCars().get(1).move(4);
        game.getCars().get(1).move(5);
        game.getCars().get(2).move(4);

        List<String> winners = game.findWinners();

        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni");
    }

    @Test
    @DisplayName("우승자 찾기 - 모두 같은 위치")
    void findAllWinnersWhenAllAtSamePosition() {
        List<String> carNames = Arrays.asList("pobi", "woni", "jun");
        RacingGame game = new RacingGame(carNames);

        List<String> winners = game.findWinners();

        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni", "jun");
    }
}
