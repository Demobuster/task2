package com.task.task23;

/**
 * Class represents a car with it's speed, start position and id
 * @author Sergey
 */
class Car {

    private int speed;
    private int startPos;
    private int id;

    public Car(int speed, int startPos, int id) {
        this.speed = speed;
        this.startPos = startPos;
        this.id = id;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStartPos() {
        return startPos;
    }

    public int getId() {
        return id;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public void setId(int id) {
        this.id = id;
    }
}
