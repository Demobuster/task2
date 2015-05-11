package com.task.task18;

/**
 * Class represents a square which consists of four points and center point
 * @author Sergey
 */
class Square implements Comparable<Square> {

    private Point A;
    private Point B;
    private Point C;
    private Point D;
    private Point center;
    private double distanceToCenter;

    public Square(Point A, Point circleCenter) {
        setA(A);
        setB();
        setC();
        setD();
        setCenter();
        setDistToCenter(circleCenter);
    }

    private void setA(Point A) {
        this.A = A;
    }

    private void setB() {
        B = new Point(A.getX(), A.getY() + 1);
    }

    private void setC() {
        C = new Point(B.getX() + 1, B.getY());
    }

    private void setD() {
        D = new Point(C.getX(), A.getY());
    }

    public void setCenter() {
        center = new Point(A.getX() + 0.5, A.getY() + 0.5);
    }

    public Point getA() {
        return A;
    }

    public Point getB() {
        return B;
    }

    public Point getC() {
        return C;
    }

    public Point getD() {
        return D;
    }

    public Point getCenter() {
        return center;
    }

    public Double getDistanceToCenter() {
        return distanceToCenter;
    }

    public boolean isSquareUnderRadius(double radius, Point circleCenter) {
        return (A.isPointUnderRadius(radius, circleCenter) && B.isPointUnderRadius(radius, circleCenter)
                && C.isPointUnderRadius(radius, circleCenter) && D.isPointUnderRadius(radius, circleCenter));
    }

    public void setDistToCenter(Point circleCenter) {        
        distanceToCenter
                = Math.sqrt(Math.abs(Math.pow(this.center.getX() - circleCenter.getX(), 2) + Math.pow(this.center.getY() - circleCenter.getY(), 2)));
    }
    
    @Override
    public String toString() {
        return "Point=[" + getA().getX() + ";" + getA().getY() + "] ["
                            + getB().getX() + ";" + getB().getY() + "] ["
                            + getC().getX() + ";" + getC().getY() + "] ["
                            + getD().getX() + ";" + getD().getY() + "]"; 
    }

	@Override
	public int compareTo(Square s1) {
		return this.getDistanceToCenter().compareTo(s1.getDistanceToCenter());
	}

}
