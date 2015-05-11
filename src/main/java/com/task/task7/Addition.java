package com.task.task7;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class represents opetation of addition
 *
 * @author Sergey
 */
class Addition {

    private static HashMap<Integer, Integer> mapX;
    private static HashMap<Integer, Integer> mapY;

    public Addition(String equationX, String equationY) {
        mapX = stringToMap(equationX);
        mapY = stringToMap(equationY);
    }

    private static HashMap<Integer, Integer> stringToMap(String equation) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        equation = equation.replace(" ", "");

        Pattern pattern = Pattern.compile("((\\+|-)?\\d+)|(\\d+)");
        Matcher m = pattern.matcher(equation);

        while (true) {
            int degree = 0;
            int value = 0;

            if (m.find()) {
                String temp = m.group();
                value = Integer.parseInt(temp);
            } else {
                break;
            }

            if (m.find()) {
                String temp = m.group();
                degree = Integer.parseInt(temp);
            } else {
                map.put(degree, value);
                break;
            }

            map.put(degree, value);
        }

        return map;
    }

    /**
     * Operation of addition perform
     */
    private static String addPerform(HashMap<Integer, Integer> x, HashMap<Integer, Integer> y) {
        Iterator<Map.Entry<Integer, Integer>> xIterator = x.entrySet().iterator();
        StringBuilder sb = new StringBuilder();

        while (xIterator.hasNext()) {
            Map.Entry<Integer, Integer> entryX = xIterator.next();

            Iterator<Map.Entry<Integer, Integer>> yIterator = y.entrySet().iterator();
            while (yIterator.hasNext()) {
                Map.Entry<Integer, Integer> entryY = yIterator.next();
                if (entryY.getKey().equals(entryX.getKey())) {
                    x.put(entryX.getKey(), entryX.getValue() + entryY.getValue());

                    break;
                }
            }
        }

        xIterator = x.entrySet().iterator();
        while (xIterator.hasNext()) {
            Map.Entry<Integer, Integer> entryX = xIterator.next();
            sb.insert(0, " + " + entryX.getValue() + "*x^" + entryX.getKey());
        }

        return sb.toString();
    }

    public static String solveEquation() {
        return (mapX.size() > mapY.size() ? addPerform(mapX, mapY) : addPerform(mapY, mapX));
    }
}
