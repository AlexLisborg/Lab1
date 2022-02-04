package Vg;

public class Engine {

    enum EngineState {
        ON, OFF
    }

    EngineState engineState;
    public double enginePower;
    double engineStartValue;


    public Engine(double enginePower, double engineStartValue) {
        this.engineState = EngineState.OFF;
        this.engineStartValue = engineStartValue;
        this.enginePower = enginePower;
    }

    /***
     * Sets currentSpeed value to zero.
     */
    public void stopEngine() {
        engineState = EngineState.OFF;
    }


    public void startEngine() {
        engineState = EngineState.ON;
    }


    /***
     * Returns the enginePower.
     */
    public double getEnginePower() {
        return enginePower;
    }

    /***
     *
     * Returns the engine start value.
     */
    public double getEngineStartValue() {
        return engineStartValue;
    }

    public EngineState getEngineState() {
        return engineState;
    }
}


