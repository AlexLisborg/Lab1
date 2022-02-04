public class Garage <T extends Car> implements Positionable {

    private Platform<T> platform;
    private int maxCapacity;
    private int currentCapacity; // Maximum
    private double x;
    private double y;

    /***
     * Garage constructor, can hold any Car type
     * @param sizeLimit if sum of all Loaded Cars exceeds sizeLimit
     * @param maxCapacity max amount of cars that can be held in the Garage.
     * @param x coordinate
     * @param y coordinate
     */
    public Garage(double sizeLimit, int maxCapacity,double x,double y) {
        platform = new Platform<T>(sizeLimit);
        this.maxCapacity = maxCapacity;
        this.x = x;
        this.y = y;
    }

    /***
     *Loads specified item into the Garage assuming sizeLimit or maxCapacity has not been reached.
     * @param car specified car to be loaded.
     */
    public void loadItem(T car) {
        if (currentCapacity < maxCapacity) {

            platform.loadItem(car);
            currentCapacity++;
        }
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    /***
     * unLoads last loaded Car.
     */
    public T unloadItem() {
        return platform.unLoadItem();
    }

    public double getSizeLimit() {return platform.getSizeLimit();}

    /***
     * returns the sum of size for all currently loaded cars.
     */
    public double getCurrentSizeLoad() {return platform.getCurrentSizeLoad();}



    public double getX() {return 0;}

    public double getY() {return 0;}

    public void setX(double x) {}

    public void setY(double y) {}

    public double getSize() {return 0;}
}
