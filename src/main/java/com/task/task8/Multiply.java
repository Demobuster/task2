package com.task.task8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class represents opetation of multiplying
 *
 * @author Sergey
 */
class Multiply {

    private static ArrayList<Part> factorsX;
    private static ArrayList<Part> factorsY;

    public Multiply(String equation1, String equation2) {
        factorsX = stringToList(equation1);
        factorsY = stringToList(equation2);
    }

    private static ArrayList<Part> stringToList(String equation) {
        ArrayList<Part> parts = new ArrayList<Part>();
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
                parts.add(new Part(degree, value));
                break;
            }

            parts.add(new Part(degree, value));
        }

        return parts;
    }

    private static String multPerform(ArrayList<Part> x, ArrayList<Part> y) {
        StringBuilder sb = new StringBuilder();

        for (Iterator<Part> iterator = x.iterator(); iterator.hasNext();) {
            Part nextX = iterator.next();

            for (Iterator<Part> iterator1 = y.iterator(); iterator1.hasNext();) {
                Part nextY = iterator1.next();

                sb.append(nextX.getValue() * nextY.getValue());
                sb.append("*x^");
                sb.append(nextX.getDegree() + nextY.getDegree());

                sb.append(" + ");
            }
        }

        return sb.toString();
    }

    public static String solveEquation() {
        return (factorsX.size() > factorsY.size() ? multPerform(factorsX, factorsY) : multPerform(factorsY, factorsX));
    }
}
