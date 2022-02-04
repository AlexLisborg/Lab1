import java.util.ArrayDeque;
import java.util.Deque;

public class Platform <T extends Positionable> implements Positionable {
    private double x;
    private double y;
    private final double size;
    private final Deque<T> stack;
    protected double sizeLimit;
    protected double currentSizeLoad;
    private final double acceptableItemRange = 2;

    public Platform(double sizeLimit) {
        this.stack = new ArrayDeque<>();
        this.sizeLimit = sizeLimit;
        this.size = sizeLimit * 2;
    }


    protected Deque<T> getStack() {
        return stack;
    }


    protected T peek() {
        return stack.peek();
    }


    protected double getSizeLimit() {
        return sizeLimit;
    }


    protected double getCurrentSizeLoad() {
        return currentSizeLoad;
    }

    protected boolean inRange(T item) {
        double deltaY = this.getY() - item.getY();
        double deltaX = this.getX() - item.getX();

        if (Math.sqrt(Math.pow(deltaY, 2) + Math.pow(deltaX, 2)) <= acceptableItemRange) {
            return true;
        } else return false;
    }

    protected void loadItem(T item) {
        if (currentSizeLoad + item.getSize() <= sizeLimit && inRange(item)) {
            stack.push(item);
            currentSizeLoad += item.getSize();
        }
    }
    protected T unLoadItem() {
        return stack.pop();
    }


    public double getX() {
        return x;
    }


    public void setX(double x) {
        this.x = x;
    }


    public double getY() {
        return y;
    }


    public void setY(double y) {
        this.y = y;
    }


    public double getSize() {
        return size;
    }




}