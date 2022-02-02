import java.awt.*;

public abstract class FlatbedCar extends Car {
    private Flatbed flatbed;

    /***
     * Constructor for FlatbedCar
     * @param nrDoors the number of doors.
     * @param enginePower
     * @param color
     * @param modelName
     * @param anglelimit the maximum angle of the the cars flatbed measured in degrees
     * @param incDecSpeed the angle changing speed measured in degrees
     */
    public FlatbedCar(int nrDoors, double enginePower, Color color, String modelName, double size, double anglelimit, double incDecSpeed) {
        super(nrDoors, enginePower, color, modelName, size);
        flatbed = new Flatbed(anglelimit, incDecSpeed, this);
    }
    public void startEngine() {
        if (flatbed.getAngle() == 0 && getCurrentSpeed() == 0) {
            setCurrentSpeed(getEngineStartValue());
        }
    }

    public void incrementFlatbed () {
        flatbed.incrementAngle();
    }

    public void decrementFlatbed () {
        flatbed.decrementAngle();
    }

    public double getFlatbedAngle () {return flatbed.getAngle();}

}
