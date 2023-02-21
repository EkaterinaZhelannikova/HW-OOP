package lesson1.game;

import java.util.ArrayList;
import java.util.List;

public class RobotMap {

    private final int n;
    private final int m;
    private final int limit;

    private final List<Robot> robots;

    public RobotMap(int n, int m) {
        validateCreateMap(n, m);
        this.n = n;
        this.m = m;
        this.limit = 5;
        this.robots = new ArrayList<>();
    }

    public RobotMap(int n, int m, int limit) {
        validateCreateMap(n, m);
        this.n = n;
        this.m = m;
        this.limit = limit;
        this.robots = new ArrayList<>();
    }

    public Robot createRobot(Point point) {
        validatePoint(point);
        Robot robot = new Robot(point);
        if (robots.size() != limit) {
            robots.add(robot);
        }
        else {
            throw new IllegalStateException("Лимит роботов превышен! Максимальное количество роботов = " + limit + "!");
        }

        return robot;
    }

    private void validatePoint(Point point) {
        validatePointIsCorrect(point);
        validatePointIsFree(point);
    }

    private void validateCreateMap(int n, int m) {
        if (n <= 0 || m <= 0) {
            throw new IllegalStateException("Некоректные значения координат карты!");
        }
    }

    private void validatePointIsCorrect(Point point) {
        if (point.x() < 0 || point.x() > n || point.y() < 0 || point.y() > m) {
            throw new IllegalStateException("Некоректное значение точки!");
        }
    }

    private void validatePointIsFree(Point point) {
        for (Robot robot : robots) {
            Point robotPoint = robot.point;
            if (robotPoint.equals(point)) {
                throw new IllegalStateException("Точка " + point + " занята!");
            }
        }
    }

    public class Robot {

        public static final Direction DEFAULT_DIRECTION = Direction.TOP;

        private Direction direction;
        private Point point;

        public Robot(Point point) {
            this.direction = DEFAULT_DIRECTION;
            this.point = point;
        }

        public void changeDirection(Direction direction) {
            this.direction = direction;
        }

        public void move() {
            Point newPoint = switch (direction) {
                case TOP -> new Point(point.x() - 1, point.y());
                case RIGHT -> new Point(point.x(), point.y() + 1);
                case BOTTOM -> new Point(point.x() + 1, point.y());
                case LEFT -> new Point(point.x(), point.y() - 1);
            };
            validatePoint(newPoint);

            System.out.println("Робот переместился с " + point + " на " + newPoint);
            this.point = newPoint;
        }

        @Override
        public String toString() {
            return point.toString() + ", [" + direction.name() + "]";
        }
    }

}
