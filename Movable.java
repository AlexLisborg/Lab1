/***
 * interface for objects that are supposed to move or change angle of direction.
 * @author Eli Uhlin, Alexander Lisborg
 * @version 1.6 21 january 2022
 */
public interface Movable {
    /***
     * Increases the x coordinate with the currentSpeed() times the cosine of the cars angle.
     * Increases the y coordinate with the currentSpeed() times the sine of the cars angle.
     */
    void move();

    /***
     * Increases the angle of the car by the turnSpeed.
     */
    void turnLeft();

    /***
     * Decreases the angle of the car by the turnSpeed.
     */
    void turnRight();
    


}
