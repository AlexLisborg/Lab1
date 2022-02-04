public class Garage <T extends Car> implements Positionable {

    private Platform<T> platform;
    private int maxCapacity;
    private int currentCapacity; // Maximum
    private double x;
    private double y;

    public Garage(double sizeLimit, int maxCapacity,double x,double y) {
        platform = new Platform<T>(sizeLimit);
        this.maxCapacity = maxCapacity;
        this.x = x;
        this.y = y;
    }

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

    public T unloadItem() {
        return platform.unLoadItem();
    }

    public double getSizeLimit() {return platform.getSizeLimit();}

    public double getCurrentSizeLoad() {return platform.getCurrentSizeLoad();}



    public double getX() {return 0;}

    public double getY() {return 0;}

    public void setX(double x) {}

    public void setY(double y) {}

    public double getSize() {return 0;}
}
