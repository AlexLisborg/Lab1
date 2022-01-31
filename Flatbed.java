import java.math.*;

public class Flatbed {

    private double angle;
    private double anglelimit;
    private double incDecSpeed;


    /***
     *
     * @param anglelimit uses degrees as input
     * @param incDecSpeed uses degrees as input
     */
    public Flatbed(double anglelimit, double incDecSpeed) {
        angle = 0;
        this.anglelimit = Math.toRadians(anglelimit);
        this.incDecSpeed = Math.toRadians(incDecSpeed);

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
