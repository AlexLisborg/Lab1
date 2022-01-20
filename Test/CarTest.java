import junit.framework.TestCase;
import java.math.*;
import java.awt.*;

public class CarTest extends TestCase {


    public void testIncrementSpeedCanNotSetCurrentSpeedToAnythingGreaterThanEnginePower() {
        Saab95 car = new Saab95();
        car.incrementSpeed(1000);
        assertEquals(car.getCurrentSpeed(), 0);
    }

    public void testDecrementSpeedCanNotSetCurrentSpeedToAnythingLowerThanZero() {
        Saab95 car = new Saab95();
        car.decrementSpeed(1000);
        assertEquals(car.getCurrentSpeed(), 0);
    }

    public void testStartEngineSetsCurrentSpeedToEngineStartValue() {
        Saab95 car = new Saab95();
        car.startEngine();
        assertEquals(car.getCurrentSpeed(),car.getEngineStartValue());
    }

    public void testStopEngineSetsCurrentSpeedToZero() {
        Saab95 car = new Saab95();
        car.startEngine();
        car.stopEngine();
        assertEquals(car.getCurrentSpeed(),0.0);
    }

    public void testSetColorChangesColor(){
        Saab95 car = new Saab95();
        car.setColor(Color.black);
        assertEquals(car.getColor(), Color.black);
    }

    public void testGasInputMustBeBetweenZeroAndOne() {
        Saab95 car = new Saab95();
        double before = car.getCurrentSpeed();
        car.gas(0.5);
        double after = car.getCurrentSpeed();
        assertTrue(!(before == after));
    }

    public void testBrakeInputMustBeBetweenZeroAndOne() {
        Saab95 car = new Saab95();
        double before = car.getCurrentSpeed();
        car.brake(0.5);
        double after = car.getCurrentSpeed();
        assertTrue(!(before == after));
    }


    public void testGasCantResultInCurrentSpeedGettingLower() {
        Saab95 car = new Saab95();
        double before = car.getCurrentSpeed();
        car.gas(1);
        double after = car.getCurrentSpeed();
        assertTrue(before <= after);
    }

    public void testBrakeCantResultInCurrentSpeedGettingHigher() {
        Saab95 car = new Saab95();
        car.setCurrentSpeed(10);
        double before = car.getCurrentSpeed();
        car.brake(0);
        double after = car.getCurrentSpeed();
        assertTrue(before >= after);
    }

    public void testAngleIsZeroYAxisShouldNotChange() {
        Saab95 car = new Saab95();
        double before = car.getY();
        car.setCurrentSpeed(10);
        car.setAngle(0);
        car.gas(1);
        car.move();
        double after = car.getY();
        assertEquals(before, after);
    }

    public void testAngleIs90DegreesXAxisShouldNotChange() {
        Saab95 car = new Saab95();
        double before = car.getX();
        car.setCurrentSpeed(10);
        car.setAngle(Math.PI/2);
        car.gas(1);
        car.move();
        double after = car.getX();
        assertEquals(before, after);
    }

}


