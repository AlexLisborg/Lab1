import java.awt.*;

/***
 * subclass to car, has a unique value turbo that is used in speedFactor function.
 */
public class Saab95 extends Car {

    /***
     * the turbo amount of the car.
     */
    private double turbo = 1;

    /***
     * true if turbo is on, false if turbo is on.
     */
    private boolean turboOn;

    /***
     * Constructor for car Saab95.
     * turboOn is set to false by default.
     */
    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }

    /***
     * Sets turboOn to true
     * (see function speedFactor for turbo usage)
     */
    public void setTurboOn(){
	    turboOn = true;
        turbo = 1.3;
    }

    public void setTurboOff(){
	    turboOn = false;
        turbo = 1.0;
    }

    public double getTurbo() {
    return this.turbo;

    }


    
    public double speedFactor(){
        return getEnginePower() * 0.01 * turbo;
    }

}
