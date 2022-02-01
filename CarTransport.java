import java.awt.*;

public abstract class CarTransport extends Car {

    double acceptableCarRange = 2;
    Ramp ramp;
    public CarTransport(int nrDoors, double enginePower, Color color, String modelName, double size, double rampSizeLimit) {
        super(nrDoors, enginePower, color, modelName, size);
        ramp = new Ramp(rampSizeLimit, this);

    }

    public void lowerRamp() {
        if (getCurrentSpeed() == 0) {
            ramp.lowerRamp();
        }
    }


    public boolean inRange(Car car) {
        double deltaY = this.getY() - car.getY();
        double deltaX = this.getX() - car.getX();

        if (Math.sqrt(Math.pow(deltaY,2) + Math.pow(deltaX,2)) <= acceptableCarRange){
            return true;
        }
        else return false;
    }

    public void loadCar(Car car) {
        if(inRange(car) && !(car instanceof CarTransport)) {
            ramp.loadCar(car);}
    }
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
