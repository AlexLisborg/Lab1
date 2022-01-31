import java.util.ArrayDeque;
import java.util.Deque;

public class Ramp {


    private enum rampState {
        UP, DOWN
    }


    rampState currentRampState;

    private Deque<Car> stack;
    private double sizeLimit;
    private double currentSizeLoad;

    public Ramp() {
        currentRampState = rampState.UP;
        stack = new ArrayDeque<>();
    }



    public Deque<Car> getStack() {
        return stack;
    }



    public void setCurrentRampState(rampState newRampState) {
        currentRampState = newRampState;
    }

    public rampState getCurrentRampState() {
        return currentRampState;
    }


    public void raiseRamp() {
        currentRampState = rampState.UP;
    }

    public void lowerRamp() {
        currentRampState = rampState.DOWN;
    }

    public void loadCar(Car car) {
        if (currentRampState == rampState.DOWN && !(currentSizeLoad + car.getSize() > sizeLimit)){
            stack.push(car);
            currentSizeLoad += car.getSize();
        }
    }

    public void unLoadCar() {
        if (currentRampState == rampState.DOWN) {
            currentSizeLoad -= stack.pop().getSize();


        }
    }

    public Car peek() {
        return stack.peek();
    }
}
