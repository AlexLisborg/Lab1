
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.math.*;
import java.awt.*;

public class CarTest extends TestCase {

    Saab95 saab = new Saab95();
    Scania scania = new Scania();
    CarTransport carTransport = new Truck();
    CarTransport carTransport2 = new Truck();
    Flatbed flatbed = new Flatbed( 40, 2, scania);
    Garage<Car> carGarage = new Garage<>(300, 2,0,0);

    @Before
    public void initialize() {
        System.out.println();
        saab = new Saab95();
        FlatbedCar scania;
        carTransport = new Truck();
        carTransport.loadItem(saab);
    }

    @Test
    public void testIncrementSpeedCanNotSetCurrentSpeedToAnythingGreaterThanEnginePower() {
        Saab95 car = new Saab95();
        car.incrementSpeed(1000);
        assertTrue(car.getCurrentSpeed() <= car.getEnginePower());

    }

    public void testDecrementSpeedCanNotSetCurrentSpeedToAnythingLowerThanZero() {
        Saab95 car = new Saab95();
        car.decrementSpeed(1000);
        assertEquals(car.getCurrentSpeed(), 0.0);
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

    public void testGetEnginePowerForSaabIsOneHundredAndTwentyFive(){
        Saab95 car = new Saab95();
        assertEquals(car.getEnginePower(),125.0);
    }

    public void testGetCurrentSpeedWorks(){
        Saab95 car = new Saab95();
        car.setCurrentSpeed(5);
        assertEquals(car.getCurrentSpeed(), 5d);
    }

    public void testCarTransportShouldHaveRampUp() {
        carTransport.lowerRamp();
        carTransport.raiseRamp();
        String bef = carTransport.getCurrentRampState();
        carTransport.setCurrentSpeed(4);
        carTransport.lowerRamp();
        assertEquals(carTransport.getCurrentRampState(), bef);
    }

    @Test
    public void testGasInputMustBeBetweenZeroAndOne() {
        Saab95 car = new Saab95();
        double before = car.getCurrentSpeed();
        car.startEngine();
        car.gas(0.5);
        double after = car.getCurrentSpeed();
        assertTrue(before != after);
    }
    public void testBrakeInputMustBeBetweenZeroAndOne() {
        Saab95 car = new Saab95();
        double before = car.getCurrentSpeed();
        car.setCurrentSpeed(10);
        car.brake(0.5);
        double after = car.getCurrentSpeed();
        assertTrue(!(before == after));
    }

   @Before
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


    @Test
    public void testSaabAndCarTransportShouldHaveTheSameCoordinates() {
        carTransport.lowerRamp();
        carTransport.loadItem(saab);
        carTransport.setCurrentSpeed(20);
        carTransport.move();
        double carX = carTransport.getX();
        double saabX = carTransport.peek().getX();
        double carY = carTransport.getY();
        double saabY = carTransport.peek().getY();
        assertTrue(saabX == carX && carY == saabY);

    }



    public void testCarTransportPeekShouldBeSaab() {
        carTransport.lowerRamp();
        carTransport.loadItem(saab);
        carTransport.setCurrentSpeed(20);
        carTransport.move();
        double carTranCord = carTransport.getX();
        double saabCord = carTransport.peek().getX();
        assertEquals(carTransport.peek(), saab);

    }

    public void testCarTransportShouldNotLoadBecauseSpeed() {
        carTransport.setCurrentSpeed(20);
        carTransport.lowerRamp();
        carTransport.loadItem(saab);


        assertEquals(carTransport.peek(), null);

    }

    public void testCarTransportShouldNotLoadBecauseCarisOutOfRange() {
        saab.setX(4);
        saab.setY(8);
        carTransport.lowerRamp();
        carTransport.loadItem(saab);
        assertEquals(carTransport.peek(), null);

    }


    public void testCarTransportShouldNotLoadOntoCarTransport() {
        carTransport.lowerRamp();
        carTransport.loadItem(carTransport);
        assertEquals(carTransport.peek(), null);

    }

    public void testCarTransportPeekShouldBePop (){
        carTransport.lowerRamp();
        carTransport.loadItem(saab);
        assertEquals(carTransport.peek(), carTransport.unLoadItem());
    }


    public void testFlatBedShouldBeDownWhenStartingEngine() {
        scania.setFlatbedAngle(30);
        scania.decrementFlatbed();
        scania.startEngine();
        assertEquals(scania.getCurrentSpeed(),(double)0);
    }
    public void testFlatBedAngleShouldBeBiggerThanZero() {
        initialize();
        scania.incrementFlatbed();

        assertEquals(scania.getFlatbedAngle(), Math.toRadians(1));
    }

    public void testFlatBedAngleShouldBeZero() {
        scania.setAngle(30);
        double before = scania.getAngle();
        scania.decrementFlatbed();
        assertEquals(scania.getAngle(),before);


    }

    public void testFlatBedAngleShouldBeBiggerThan0() {
        flatbed.incrementAngle();
        assertEquals(flatbed.getAngle(), Math.toRadians(2));

    }

    public void testFlatBedAngleShouldBe1Degree() {
        scania.incrementFlatbed();
        assertEquals(scania.getFlatbedAngle(), Math.toRadians(1));



    }

    public void testFlatBedAngleShouldNotPassZero() {
        scania.incrementFlatbed();
        scania.decrementFlatbed();
        scania.decrementFlatbed();

        assertEquals(scania.getFlatbedAngle(),0.0);



    }

    public void testFlatBedAngleLimitShouldNotPassAngleLimit() {
    scania.setFlatbedAngle(70);
    scania.incrementFlatbed();


    }

    public void testFlatBedAngleLimitShouldBe70Degrees() {
        assertEquals(scania.getAngleLimit(), Math.toRadians(70));
    }

    public void testCapacityShouldBe1() {
        carGarage.loadItem(scania);
        assertEquals(carGarage.getCurrentCapacity(),1);
    }

    public void testCapacityShouldBe2() {
        carGarage.loadItem(scania);
        carGarage.loadItem(saab);
        carGarage.loadItem(carTransport);
        assertEquals(carGarage.getCurrentCapacity(),2);}



    public void testGaragePeekShouldBe2() {
        Garage<Car> carGarage = new Garage<>(11, 2, 0, 0);
    carGarage.loadItem(saab);
        carGarage.loadItem(carTransport);
    assertEquals(carGarage.unloadItem().getSize(), 2.0);
    }



   public void testGarageShouldBeMaxCap() {
       Garage<CarTransport> carGarage = new Garage<>(30, 2, 0, 0);
   carGarage.loadItem(carTransport);
       carGarage.loadItem(carTransport2);
       assertEquals(carGarage.getCurrentCapacity(), carGarage.getMaxCapacity());
    }

    public void testGarageShouldBeMaxSize() {
        Garage<CarTransport> carGarage = new Garage<>(30, 2, 0, 0);
        carGarage.loadItem(carTransport);
        carGarage.loadItem(carTransport2);
        assertEquals(carGarage.getCurrentSizeLoad(), carGarage.getSizeLimit());
    }
}



