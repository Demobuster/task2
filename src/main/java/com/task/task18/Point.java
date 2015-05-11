package com.task.task18;

/**
 * Class represents a point which consists of two coordinates
 * @author Sergey
 */
class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isPointUnderRadius(double radius, Point center) {
        return (Math.pow(x - center.getX(), 2) + Math.pow(y - center.getY(), 2) < Math.pow(radius, 2));
    }
}
