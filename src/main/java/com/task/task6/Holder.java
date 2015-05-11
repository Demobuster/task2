package com.task.task6;

/**
 * Sub class to prevent removing equal integers
 * @author Sergey
 */
class Holder {

    public static int curId = 0;
    public final double number;
    public final int id;

    public Holder(final double number) {
        this.number = number;
        this.id = curId++;
    }

    public double getNumber() {
        return number;
    }
    
}