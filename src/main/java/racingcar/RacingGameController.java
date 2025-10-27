package racingcar;

import java.util.List;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputValidator = new InputValidator();
    }

    public void run() {
        List<String> carNames = getCarNames();
        int attemptCount = getAttemptCount();

        RacingGame game = new RacingGame(carNames);
        playGame(game, attemptCount);
        announceWinners(game);
    }

    private List<String> getCarNames() {
        outputView.printCarNamesInputMessage();
        List<String> carNames = inputView.inputCarNames();
        inputValidator.validateCarNames(carNames);
        return carNames;
    }

    private int getAttemptCount() {
        outputView.printAttemptCountInputMessage();
        int attemptCount = inputView.inputAttemptCount();
        inputValidator.validateAttemptCount(attemptCount);
        return attemptCount;
    }

    private void playGame(RacingGame game, int attemptCount) {
        outputView.printRaceResultHeader();
        for (int i = 0; i < attemptCount; i++) {
            game.playRound();
            outputView.printRaceProgress(game.getCars());
        }
    }

    private void announceWinners(RacingGame game) {
        List<String> winners = game.findWinners();
        outputView.printWinners(winners);
    }
}
