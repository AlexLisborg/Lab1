package Vg;

import java.awt.*;

public abstract class Vehicle {
    private double x;
    private double y;
    private double size;
    private Color color;

    private double angle;
    private final double turnSpeed;

    private double currentSpeed;

    public Vehicle(double size, Color color, double turnSpeed) {
        this.size = size;
        this.color = color;
        this.turnSpeed = turnSpeed;
        this.angle = 0;
        this.x = 0;
        this.y = 0;
        this.currentSpeed = 0;
    }

    /***
     * Returns the currentSpeed.
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /***
     * Returns the color.
     */
    public Color getColor(){
        return color;
    }



    /***
     * Sets the color.
     * @param clr the color which will be set.
     */
    public void setColor(Color clr){
        color = clr;
    }

    /***
     * Sets the currentSpeed.
     * @param currentSpeed the speed with which the currentSpeed will be set.
     */
    public void setCurrentSpeed(double currentSpeed) {this.currentSpeed = currentSpeed;}

    /***
     * Sets the angle.
     * @param angle the angle which will be set.
     */
    public void setAngle(double angle) {this.angle = angle;}

    /***
     *
     * Returns the angle.
     */
    public double getAngle(){ return angle;}

    /***
     *
     * Gets the x value.
     */
    public double getX() {return x;}

    /***
     *
     * Gets the y value.
     */
    public double getY() {return y;}

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void turnLeft(){
        this.angle = this.angle - this.turnSpeed;
    }

    public void turnRight(){
        this.angle = this.angle + this.turnSpeed;
    }


    public void move() {
        this.x = this.x + getCurrentSpeed() * Math.cos(angle);
        this.y = this.y + getCurrentSpeed() * Math.sin(angle);
    }







}
