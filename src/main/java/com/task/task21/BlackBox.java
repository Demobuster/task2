package com.task.task21;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Class represents a structure "black box" that stores the set of numbers and having a number K
 * @author Sergey
 */
class BlackBox {

    private TreeSet<Double> numbers;
    private int k;

    public BlackBox() {
        numbers = new TreeSet<Double>();
    }

    public boolean isEmpty() {
        return numbers.isEmpty();
    }

    public boolean add(Double num) {
        return numbers.add(num);
    }
    
    public String toString() {
        return numbers.toString();
    }
    
    public Double getKthMinimum(int k) {
        this.k = k;
        Double number = numbers.first();
        Iterator iterator = numbers.iterator();
        int i = 0;

        if (k >= 0) {

            while (iterator.hasNext() && i != k) {
                number = (Double) iterator.next();
                
                ++i;
            }
        } else {
            return -1.0;
        }

        return number;
    }

}

