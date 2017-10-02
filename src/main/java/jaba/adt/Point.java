package jaba.adt;


/**
 * Created by Administrador on 21/05/2017.
 */
public class Point {
    private double y;
    private double x;

    public Point() {
        x = Math.random();
        y = Math.random();
    }

    @java.beans.ConstructorProperties({"y", "x"})
    public Point(double y, double x) {
        this.y = y;
        this.x = x;
    }

    double r() {
        return Math.sqrt(x * x + y * y);
    }

    double theta() {
        return Math.atan2(x, y);
    }

    double distance(Point point) {
        double dx = x - point.getX();
        double dy = y - point.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }

    public double getY() {
        return this.y;
    }

    public double getX() {
        return this.x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }
}
