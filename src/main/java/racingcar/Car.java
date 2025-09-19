package racingcar;

public class Car {
    private static final int MOVE_FORWARD_THRESHOLD = 4;
    private static final int INITIAL_POSITION = 0;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public void move(int randomValue) {
        if (randomValue >= MOVE_FORWARD_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
}
