package com.task.task5;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Sergey
 */
class OrdinaryLeastSquares {
    private ArrayList<Integer> iList;
    private ArrayList<Integer> uList;
    private int n;
    
    /**
     * Initialize I and U values 
     * @param sequenceI I values 
     * @param sequenceU U values 
     * @param n length
     */
    public OrdinaryLeastSquares(String sequenceI, String sequenceU, int n) {
        this.n = n;
        
        iList = new ArrayList<Integer>();
        uList = new ArrayList<Integer>();
        
        int len = 0;
        for (StringTokenizer stringTokenizer = new StringTokenizer(sequenceI); stringTokenizer.hasMoreTokens();) {
            if (len < n) {
                String token = stringTokenizer.nextToken(" ");
                iList.add(Integer.parseInt(token));
                ++len;
            } else {
                break;
            }
        }
        
        len = 0;
        for (StringTokenizer stringTokenizer = new StringTokenizer(sequenceU); stringTokenizer.hasMoreTokens();) {
            if (len < n) {
                String token = stringTokenizer.nextToken(" ");
                uList.add(Integer.parseInt(token));
                ++len;
            } else {
                break;
            }
        }
    }
    
    /**
     * k param computing
     * @return a k value
     */
    private double kCompute() {
        double k =
                (double) (n * sumOfMultiply(iList, uList, n) - sum(iList, n) * sum(uList, n)) / 
                (double) (n * sum(uList, n) - Math.pow((double) sum(iList, n) , 2));

        return k;
    }
    
    /**
     * b param computing
     * @return a b value
     */
    private double bCompute() {
        double b = ((double) (sum(uList, n)) - kCompute() * sum(iList, n)) / (double) n;
        
        return b;
    }
    
    /**
     * copmute U0 from prarm I0
     * @return a U0 value
     */
    private double U0FromI0() {
        return (kCompute() * iList.get(0) + bCompute());
    }
    
    /**
     * Computing resistance approximate values
     * @return a sum value
     */
    public double getResistanceApproximateValue() {
        return (U0FromI0() / (double) iList.get(0));
    }
    
    /**
     * service function
     * @param list list of values
     * @param n length
     * @return a sum value
     */
    private int sum(ArrayList<Integer> list, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += list.get(i);
        }
        
        return sum;
    }
    
    /**
     * service function to get sum of multiplying lists
     * @param a list of values
     * @param b list of values
     * @param n length
     * @return a sum value
     */
    private int sumOfMultiply(ArrayList<Integer> a, ArrayList<Integer> b, int n) {
        int sum = 1;
        for (int i = 0; i < n; i++) {
            sum += (a.get(i) * b.get(i));
        }
        
        return sum;
    }
}