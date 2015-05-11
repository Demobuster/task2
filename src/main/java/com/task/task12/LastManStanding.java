package com.task.task12;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 * Last man standing game simulation class
 *
 * @author Sergey
 */
class LastManStanding {

    private List<Integer> people;

    /**
     * Procees via ArrayList
     */
    public void viaArrayList(int N, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        people = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            people.add(i + 1);
        }

        out.println(people);

        int i = 0;
        int temp = 0;
        while (people.size() != 1) {
            ArrayList<Integer> res = new ArrayList<Integer>();

            for (; i < people.size(); i += 2) {
                res.add(people.get(i));
                temp = i;
            }

            i = (people.size() == (temp + 1)) ? 1 : 0;
            people = res;

            out.println(people);
        }
    }

    /**
     * Procees via LinkedList 
     */
    public void viaLinkedList(int N, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        people = new LinkedList<Integer>();
        for (int i = 0; i < N; i++) {
            people.add(i + 1);
        }
        out.println(people);

        int i = 0;
        int temp = 0;
        while (people.size() != 1) {
            LinkedList<Integer> res = new LinkedList<Integer>();

            for (; i < people.size(); i += 2) {
                res.add(people.get(i));
                temp = i;
            }

            i = (people.size() == (temp + 1)) ? 1 : 0;
            people = res;

            out.println(people);
        }
    }
}
