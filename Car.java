import java.awt.*;
import java.math.*;
public abstract class Car implements Movable{


    private double x;
    private double y;
    private double angle;
    private double turnSpeed = Math.PI / 8;

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    /***
     * the speed of acceleration and deacceleration
     * (see functions incrementSpeed and decrementSpeed)
     * @return
     */
    public abstract double speedFactor();

    /***
     * Increments the currentSpeed with speedFactor times the defined amount.
     * @param amount the amount with which we multiply the speedFactor.
     */
    public abstract void incrementSpeed(double amount);

    /***
     * Decrements the currentSpeed with speedFactor times the defined amount.
     * @param amount the amount with which we multiply the speedFactor.
     */
    public abstract void decrementSpeed(double amount);

    /***
     * sets currentSpeed to the engineStartValue,
     * allowing for acceleration and deceleration.
     * (see functions incrementSpeed and decrementSpeed)
     */
    public void startEngine(){
        currentSpeed = engineStartValue;
    }

    /***
     * sets currentSpeed value to zero.
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /***
     * Returns the number of doors on the car.
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /***
     * Returns the enginePower of the car.
     */
    public double getEnginePower(){
        return enginePower;
    }

    /***
     * Returns the currentSpeed of the car.
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /***
     * Returns the color of the car.
     */
    public Color getColor(){
        return color;
    }

    /***
     * Sets the color of the car.
     * @param clr the color which will be set.
     */
    public void setColor(Color clr){
        color = clr;
    }

    /***
     * Sets the currentSpeed of the car.
     * @param currentSpeed the speed with which the currentSpeed will be set.
     */
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;

    }

    /***
     * increments the angle of the car by the turnSpeed.
     */
    public void turnLeft(){
        this.angle = this.angle - this.turnSpeed;
    }

    /***
     * decrements the angle of the car by the turnSpeed.
     */
    public void turnRight(){
        this.angle = this.angle + this.turnSpeed;
    }

    /***
     * increments the x coordinate with the currentSpeed() times the cosine of the cars angle.
     * increments the y coordinate with the currentSpeed() times the sine of the cars angle.
     */
    public void move() {
        this.x = this.x + getCurrentSpeed() * Math.cos(angle);
        this.y = this.y + getCurrentSpeed() * Math.sin(angle);
    }

}