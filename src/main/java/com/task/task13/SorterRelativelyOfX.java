package com.task.task13;

import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Class of sort with respect to X
 */
class SorterRelativelyOfX {

    private static LinkedList<Integer> list;
    private static int x;

    public SorterRelativelyOfX(String sequence, int x) {
        list = new LinkedList<Integer>();

        for (StringTokenizer stringTokenizer = new StringTokenizer(sequence); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken(" ");

            list.add(Integer.parseInt(token));
        }

        SorterRelativelyOfX.x = x;
    }

    /**
     * Sorting method
     */
    public static void solve() {
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) <= x) {
                list.addFirst(list.remove(i));
            }
        }
    }

    public static LinkedList<Integer> getList() {
        return list;
    }
}
