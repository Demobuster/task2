package com.task.task4;

import java.util.TreeSet;

/**
 *
 * @author Sergey
 */
class MySetManager {
    
    /** 
     * @param set1 set to operate
     * @param set2 set to operate

     * @return a TreeSet union
     */
    public static TreeSet<Integer> union(TreeSet<Integer> set1, TreeSet<Integer> set2) {
        TreeSet<Integer> unionSet = new TreeSet<Integer>();
        
        unionSet.addAll(set1);
        unionSet.addAll(set2);
        
        return unionSet;
    }
    /**
     * @param set1 set to operate
     * @param set2 set to operate
     * @return a TreeSet intersect
     */
    public static TreeSet<Integer> intersect(TreeSet<Integer> set1, TreeSet<Integer> set2) {
        TreeSet<Integer> intersectSet = new TreeSet<Integer>();
        
        intersectSet.addAll(set1);
        intersectSet.retainAll(set2);
        
        return intersectSet;
    }
}
