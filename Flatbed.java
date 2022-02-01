public class Flatbed {

    private double angle;
    private double anglelimit;
    private double incDecSpeed;
    private Car car;


    /***
     *
     * @param anglelimit uses degrees as input
     * @param incDecSpeed uses degrees as input
     */
    public Flatbed(double anglelimit, double incDecSpeed, Car car) {
        angle = 0;
        this.anglelimit = Math.toRadians(anglelimit);
        this.incDecSpeed = Math.toRadians(incDecSpeed);
        //this.car = car;

    }

    public void incrementAngle(boolean isMoving) {
        if(this.angle <= anglelimit - incDecSpeed && !isMoving) {
            this.angle+= incDecSpeed;
        }
    }

    public void decrementAngle() {
        if(this.angle >= 0 + incDecSpeed) {
            this.angle-= incDecSpeed;
        }
    }


    public double getAngle() {
        return angle;
    }


}
