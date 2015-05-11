package com.task.task22;

import java.util.Comparator;

/**
 * Class represents a car with it's speed, start position and id
 * @author Sergey
 */
class Car {
    private int id;
    private int speed;

    public Car(int id, int speed) {
        this.id = id;
        this.speed = speed;
    }
    

    public int getId() {
        return id;
    }

    public int getSpeed() {
        return speed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}

class CarsSorting implements Comparator<Car> {

    @Override
    public int compare(Car c1, Car c2) {
        return c2.getSpeed() - c1.getSpeed();
    }
    
}