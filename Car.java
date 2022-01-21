import java.awt.*;
import java.math.*;

/***
 * Abstract superclass defining the attributes of a basic car.
 * @author Eli Uhlin, Alexander Lisborg
 * @version 1.6 21 january 2022
 *
 */
public abstract class Car implements Movable{

    /***
     * X coordinate of the car.
     */
    private double x;

    /***
     * Y coordinate of the car.
     */
    private double y;

    /***
     * The direction of the car
     */
    private double angle;

    /***
     * The turn speed of the car.
     */
    private double turnSpeed = Math.PI / 8;

    /***
     * Number of doors on the car
     */
    private int nrDoors;

    /***
     * Engine power of the car
     */
    private double enginePower;

    /***
     * The current speed of the car
     */
    private double currentSpeed;

    /***
     * Color of the car
     */
    private Color color;

    /***
     * The car model name
     */
    private String modelName;

    /***
     * the start value of the cars engine.
     */
    private double engineStartValue = 0.1;

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
     *
     */
    public abstract double speedFactor();

    /***
     * Increases currentSpeed with speedFactor times the defined amount.
     * @param amount the amount with which we multiply the speedFactor.
     */
    public void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }

    /***
     * Decreases currentSpeed with speedFactor times the defined amount.
     * @param amount the amount with which we multiply the speedFactor.
     */
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    /***
     * Sets currentSpeed to the engineStartValue,
     * allowing for acceleration and deceleration.
     * (see functions incrementSpeed and decrementSpeed)
     */
    public void startEngine(){
        currentSpeed = engineStartValue;
    }

    /***
     * Sets currentSpeed value to zero.
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
    public void setCurrentSpeed(double currentSpeed) {this.currentSpeed = currentSpeed;}

    /***
     * Sets the angle of the car.
     * @param angle the angle which will be set.
     */
    public void setAngle(double angle) {this.angle = angle;}

    /***
     *
     * Returns the angle of the car.
     */
    public double getAngle(){ return angle;}

    /***
     *
     * Gets the x value of the car.
     */
    public double getX() {return x;}

    /***
     *
     * Gets the y value of the car.
     */
    public double getY() {return y;}

    /***
     * increases the angle of the car by the turnSpeed.
     */
    public void turnLeft(){
        this.angle = this.angle - this.turnSpeed;
    }

    /***
     * decreases the angle of the car by the turnSpeed.
     */
    public void turnRight(){
        this.angle = this.angle + this.turnSpeed;
    }

    /***
     * increases the x coordinate with the currentSpeed() times the cosine of the cars angle.
     * increases the y coordinate with the currentSpeed() times the sine of the cars angle.
     */
    public void move() {
        this.x = this.x + getCurrentSpeed() * Math.cos(angle);
        this.y = this.y + getCurrentSpeed() * Math.sin(angle);
    }

}
