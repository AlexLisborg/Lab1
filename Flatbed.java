public class Flatbed {

    private double angle;
    private final double angleLimit;
    private double incDecSpeed;
    private Car car;

    /***
     *
     * @param angleLimit uses degrees as input
     * @param incDecSpeed uses degrees as input
     */
    public Flatbed(double angleLimit, double incDecSpeed, Car car) {
        angle = 0;
        this.angleLimit = Math.toRadians(angleLimit);
        this.incDecSpeed = Math.toRadians(incDecSpeed);
        //this.car = car;

    }

    public void incrementAngle() {
        if(this.angle <= anglelimit - incDecSpeed && car.getCurrentSpeed() == 0) {
            this.angle+= incDecSpeed;
        }
    }

    /***
     *
     */
    public void decrementAngle() {
        if(this.angle >= 0 + incDecSpeed) {
            this.angle-= incDecSpeed;
        }
    }


    public double getAngle() {
        return angle;
    }

    public double getAngleLimit() {
        return angleLimit;
    }

    public double getIncDecSpeed() {
        return incDecSpeed;
    }

    public void setAngle(double angle) {
        this.angle = Math.toRadians(angle);
    }

    public void setIncDecSpeed(double incDecSpeed) {
        this.incDecSpeed = incDecSpeed;
    }
}
