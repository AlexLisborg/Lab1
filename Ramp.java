import java.util.ArrayDeque;
import java.util.Deque;

public class Ramp {


    private enum rampState {
        UP, DOWN
    }


    rampState currentRampState;

    private Deque<Car> stack;
    private final double sizeLimit;
    private double currentSizeLoad;


    public Ramp(double sizeLimit, Car car) {
        currentRampState = rampState.UP;
        stack = new ArrayDeque<>();
        this.sizeLimit = sizeLimit;
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

    /***
     * removes (pops) the last loaded car (the car at the top of the stack)
     */
    public void unLoadCar() {
        if (currentRampState == rampState.DOWN) {
            currentSizeLoad -= stack.pop().getSize();


        }
    }

    public Car peek() {
        return stack.peek();
    }
}
