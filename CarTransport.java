import java.awt.*;

public abstract class CarTransport extends Car {


    private double acceptableCarRange = 2;
    protected Ramp ramp;

    public CarTransport(int nrDoors, double enginePower, Color color, String modelName, double size, double rampSizeLimit) {
        super(nrDoors, enginePower, color, modelName, size);
        ramp = new Ramp(rampSizeLimit, this);

    }

    public void lowerRamp() {ramp.lowerRamp();}

    /***
     * checks if car is in range to be loaded onto the Ramp
     * @param car the car which we want to check the range of
     * @return
     */
    public boolean inRange(Car car) {
        double deltaY = this.getY() - car.getY();
        double deltaX = this.getX() - car.getX();

        if (Math.sqrt(Math.pow(deltaY,2) + Math.pow(deltaX,2)) <= acceptableCarRange){
            return true;
        }
        else return false;
    }

    /***
     * loads car onto the Ramp, unless the car is out of range, or the car is another carTransport.
     * @param car the car which is to be loaded
     */
    public void loadCar(Car car) {ramp.loadCar(car);}


    /***
     * changes coordinates of the CarTransport and all loaded vehicles, based on angle and currentSpeed.
     */
    public void move() {
        double newX = getX() + getCurrentSpeed() * Math.cos(getAngle());
        double newY = getY() + getCurrentSpeed() * Math.sin(getAngle());
        setX(newX);
        setY(newY);
        for (Car car : ramp.getStack()) {
            car.setX(newX);
            car.setY(newY);
        }
    }

    public double speedFactor(){
        return getEnginePower() * 0.01;
    }

}
