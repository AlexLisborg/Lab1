import java.awt.*;

/***
 * Subclass to car, has a unique value trimfactor that is used in speedFactor function.
 * @author Eli Uhlin, Alexander Lisborg
 * @version 1.6 21 january 2022
 */
public class Volvo240 extends Car{

    /***
     * Used to calculate the speedFactor for the Volvo240 car.
     */
    public final static double trimFactor = 1.25;
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    /***
     * Calculates the speedFactor for the Volvo240 car.
     * @return speedFactor a unique value used to determine the
     * acceleration of the car in increment and decrement speed
     */
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }



