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

    public void testAngleIsZeroXAxisShouldChangeWithFullAmountOfCurrentSpeed() {
        Saab95 car = new Saab95();
        double before = car.getX();
        car.setCurrentSpeed(10);
        car.setAngle(0);
        car.gas(1);
        car.move();
        double after = car.getX();
        assertEquals(car.getCurrentSpeed(), after - before);
    }



    public void testTurnLeftAngleShouldBeDifferent() {

        Saab95 car = new Saab95();
        double before = car.getAngle();
        car.turnLeft();
        double after = car.getAngle();
        assertTrue(after != before);

    }



    public void testTurnRightAngleShouldBeDifferent() {

        Saab95 car = new Saab95();
        double before = car.getAngle();
        car.turnRight();
        double after = car.getAngle();
        assertTrue(after != before);

    }

    public void testTurnLeftAngleShouldBeTheSame() {

        Saab95 car = new Saab95();
        double before = car.getAngle();
        car.turnLeft();
        car.turnRight();
        double after = car.getAngle();
        assertEquals(after, before);

    }
    public void testCarShouldHaveFourDoors() {
        Volvo240 car = new Volvo240();
        assertEquals(4, car.getNrDoors());
    }

    public void testCarShouldHaveTwoDoors() {
        Saab95 car = new Saab95();
        assertEquals(2, car.getNrDoors());
    }

    public void testTurboShouldBeOn() {
        Saab95 car = new Saab95();
        car.setTurboOn();
        assertEquals(1.3, car.getTurbo());}

        public void testTurboShouldBeOff() {
            Saab95 car = new Saab95();
            car.setTurboOff();
            assertEquals(1.0, car.getTurbo());

    }

    public void testVolvo240SpeedFactor() {
        Volvo240 car = new Volvo240();
        assertEquals(car.speedFactor(),100*0.01*1.25);
    }

    public void testSaab95SpeedFactor() {
        Saab95 car = new Saab95();
        assertEquals(car.speedFactor(),125*0.01);
    }
}

