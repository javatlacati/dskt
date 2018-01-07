package jaba.adt;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrador on 21/05/2017.
 */
@Getter
@Setter
@AllArgsConstructor
public class Point {
    private double y;
    private double x;

    public Point() {
        x = Math.random();
        y = Math.random();
    }

    double r() {
        return Math.sqrt((x * x) + (y * y));
    }

    double theta() {
        return StrictMath.atan2(x, y);
    }

    double distance(Point point) {
        double dx = x - point.getX();
        double dy = y - point.getY();
        return Math.sqrt((dx * dx) + (dy * dy));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }
}
