import java.util.ArrayDeque;
import java.util.Deque;

public class Ramp extends Platform<Car> {


    private enum RampState {
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

    /***
     *Tells us if Ramp is currently up or down.
     */
    public String getCurrentRampState() {
        return "Ramp is " + currentRampState;
    }


    public void raiseRamp() {
        currentRampState = RampState.UP;
    }

    public void lowerRamp() {
        currentRampState = rampState.DOWN;
    }

    /***
     * Pushes the specified car object to stack, only if t
     * @param car specified to be loaded
     */
    public void loadItem(Car car) {
        if (currentRampState == RampState.DOWN){
            super.loadItem(car);
        }
    }

    /***
     * removes (pops) the last loaded car (the car at the top of the stack)
     */
    public Car unLoadItem() {
        if (currentRampState == RampState.DOWN) {
           return super.unLoadItem();
        }
        else {
            throw new RuntimeException("Ramp is UP!");
        }}


}
