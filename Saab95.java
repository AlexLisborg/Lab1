import java.awt.*;

public class Saab95 extends Car {

    private double turbo = 1;
    private boolean turboOn;

    /***
     * Constructor for car Saab95.
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
     * (see function speedFactor for turbo use)
     */
    private void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    public double speedFactor(){
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }


    public void incrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
    }


    public void decrementSpeed(double amount){
        setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
    //  incrementSpeed(-amount);
        //  alternativt sätt att skriva.
        }
    
    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

}
