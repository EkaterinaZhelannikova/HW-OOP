package lesson6.game;
import lesson6.game.RobotMap.Robot;

public interface RobotInterface {
    public void changeDirection(Direction direction);
    public void move();
    public void deleteRobot(Robot robot);
}
