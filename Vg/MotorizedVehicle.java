package Vg;

import java.awt.*;

public class MotorizedVehicle extends Vehicle {

    Engine engine;

    public MotorizedVehicle(double size, Color color, double turnSpeed, double enginePower, double engineStartValue) {
        super(size, color, turnSpeed);
        this.engine = new Engine(enginePower, engineStartValue);
    }
}
