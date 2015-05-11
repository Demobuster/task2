package com.task.task16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Class which sort one of the list and union them into one sorted list
 *
 * @author Sergey
 */
class SortedListsUnion {

    private ArrayList<Integer> sortedSequence;
    private ArrayList<Integer> unsortedSequence;

    public SortedListsUnion(String file) {
        boolean flag = false;
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        Scanner scanner;

        try {
            scanner = new Scanner(new File(System.getProperty("user.home") + "/app-root/data/" + file));

            while (scanner.hasNext()) {
                int num = scanner.nextInt();

                if (num < 0) {
                    flag = true;
                    continue;
                }

                if (!flag) {
                    list1.add(num);
                } else {
                    list2.add(num);
                }

            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (list1.size() < list2.size()) {
            Collections.sort(list1);

            sortedSequence = list1;
            unsortedSequence = list2;
        } else if (list2.size() <= list1.size()) {
            Collections.sort(list2);

            sortedSequence = list2;
            unsortedSequence = list1;
        }

    }

    /**
     * Merge two lists
     */
    public ArrayList<Integer> merge() {
        SortedArrayList<Integer> sortedList = new SortedArrayList<Integer>(sortedSequence);
        ArrayList<Integer> res = new ArrayList<Integer>();

        for (Integer num : unsortedSequence) {
            sortedList.add(num);
        }

        for (Integer num : sortedList) {
            res.add(num);
        }

        return res;
    }

    public ArrayList<Integer> getSortedSequence() {
        return sortedSequence;
    }

    public ArrayList<Integer> getUnsortedSequence() {
        return unsortedSequence;
    }

}
