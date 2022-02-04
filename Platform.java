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

    /***
     * Constructor for Platform
     * @param sizeLimit when size Limit is reached items can no longer be loaded.
     */
    public Platform(double sizeLimit) {
        this.stack = new ArrayDeque<>();
        this.sizeLimit = sizeLimit;
        this.size = sizeLimit * 2;
    }

    protected Deque<T> getStack() {
        return stack;
    }

    /***
     * Returns the last loaded item.
     * @return
     */
    protected T peek() {
        return stack.peek();
    }

    /***
     * Checks if an item is in acceptableItemRange, if not – loadItem will not work.
     * @param item specified to be checked.
     */
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

    /***
     * returns last loaded item, and removes it from the stack.
     * @return
     */
    protected T unLoadItem(double x, double y) {
        stack.peek().setX(stack.peek().getX() + x);
        stack.peek().setY(stack.peek().getY() + y);
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