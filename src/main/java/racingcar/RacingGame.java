package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;

    private final List<Car> cars;
    public RacingGame(List<String> carNames) {
        this.cars = createCars(carNames);
    }

    public void playRound() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
            car.move(randomValue);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> findWinners() {
        int maxPosition = findMaxPosition();
        return findCarsAtPosition(maxPosition);
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> createdCars = new ArrayList<>();
        for (String name : carNames) {
            createdCars.add(new Car(name));
        }
        return createdCars;
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private List<String> findCarsAtPosition(int position) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == position) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
