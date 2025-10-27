package racingcar;

import java.util.List;

public class OutputView {
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RACE_RESULT_HEADER = "\n실행 결과";
    private static final String POSITION_INDICATOR = "-";
    private static final String NAME_POSITION_DELIMITER = " : ";
    private static final String WINNER_MESSAGE_PREFIX = "\n최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";

    public void printCarNamesInputMessage() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
    }

    public void printAttemptCountInputMessage() {
        System.out.println(ATTEMPT_COUNT_INPUT_MESSAGE);
    }

    public void printRaceResultHeader() {
        System.out.println(RACE_RESULT_HEADER);
    }

    public void printRaceProgress(List<Car> cars) {
        for (Car car : cars) {
            printCarStatus(car);
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(WINNER_MESSAGE_PREFIX + String.join(WINNER_DELIMITER, winners));
    }

    private void printCarStatus(Car car) {
        System.out.println(car.getName() + NAME_POSITION_DELIMITER + generatePositionIndicator(car.getPosition()));
    }

    private String generatePositionIndicator(int position) {
        return POSITION_INDICATOR.repeat(position);
    }
}
