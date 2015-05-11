package com.task.task6;

import java.util.*;

/**
 *
 * @author Sergey
 */
class Task {

    private static NavigableSet<Holder> navigableSet;

    public Task(String sequence) {
        navigableSet = new TreeSet<Holder>(new HolderComparator());

        for (StringTokenizer stringTokenizer = new StringTokenizer(sequence); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken(" ");

            navigableSet.add(new Holder(Double.parseDouble(token)));

        }
    }

    /**
     * Paired sum of any finite number of numbers
     * return a sum value
     */
    public static double getSum() {
        while (navigableSet.size() != 1) {
            navigableSet.add(new Holder(navigableSet.pollLast().getNumber() + navigableSet.pollLast().getNumber()));

        }
        return navigableSet.pollFirst().getNumber();
    }

}

class HolderComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Double d1 = ((Holder) o1).getNumber();
        Double d2 = ((Holder) o2).getNumber();
        
        if (d1.compareTo(d2) == 0) {
            return ((Holder)o1).id - ((Holder)o2).id;
        } else {
            return d1.compareTo(d2);
        }
    }
}
