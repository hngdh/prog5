package main_objects;

import java.util.Objects;

public class Coordinates {
    private final float x; //Значение поля должно быть больше -500
    private final float y;

    public Coordinates(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String getX() {
        return String.valueOf(x);
    }

    public String getY() {
        return String.valueOf(y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coordinates)) return false;
        return x == ((Coordinates) o).x && y == ((Coordinates) o).y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}