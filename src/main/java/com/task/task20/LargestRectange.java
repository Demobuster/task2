package com.task.task20;

import java.util.Stack;

/**
 *
 * @author Sergey
 */
class LargestRectange {

    private int area = 0;
    private int result[][] = null;
    private int width;
    private int hight;
    private int startI, startJ;
    private int endI, endJ;

    public int getWidth() {
        return width;
    }

    public int getHight() {
        return hight;
    }

    public int getStartI() {
        return startI;
    }

    public int getStartJ() {
        return startJ;
    }

    public int getEndI() {
        return endI;
    }

    public int getEndJ() {
        return endJ;
    }

    public int getArea() {
        return this.area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int[][] getResult() {
        return result;
    }

    public void getRectangle(int input[][]) {
        if (input != null || input.length != 0) {
            calculateRectangle(input);
        }
    }

    private void createHistogram(int input[][]) {

        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 1) {
                    input[i][j] += input[i - 1][j];
                }
            }
        }
        
        System.out.println();
    }

    public HightWidth histoArea(int input[], int row) {
        HightWidth hw = new HightWidth();
        Stack<Integer> hights = new Stack<Integer>();
        Stack<Integer> indexs = new Stack<Integer>();

        hights.push(input[0]);
        indexs.push(0);

        int lastindex = 0;
        int carea;
        int maxArea = 0;
        int hight, width;
        for (int i = 1; i < input.length; i++) {

            if (hights.isEmpty() || hights.peek() < input[i]) {
                hights.push(input[i]);
                indexs.push(i);
            } else if (hights.peek() > input[i]) {
                lastindex = 0;
                while (!hights.isEmpty() && hights.peek() > input[i]) {
                    lastindex = indexs.pop();
                    hight = hights.pop();
                    width = i - lastindex;
                    carea = hight * width;
                    if (carea > maxArea) {
                        maxArea = carea;
                        hw.setI(row);
                        hw.setJ(lastindex);
                        hw.setWidth(width);
                        hw.setHight(hight);
                    }
                }

                hights.push(input[i]);
                indexs.push(lastindex);
            }

        }

        while (!hights.isEmpty()) {
            lastindex = indexs.pop();
            hight = hights.pop();
            width = input.length - lastindex;
            carea = hight * width;
            if (carea > maxArea) {
                maxArea = carea;
                hw.setI(row);
                hw.setJ(lastindex);
                hw.setWidth(width);
                hw.setHight(hight);
            }

        }

        return hw;
    }

    private int[][] getCopy(int input[][]) {
        int temp[][] = new int[input.length][input[0].length];
        
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                temp[i][j] = input[i][j];
            }
        }
        return temp;
    }

    private void calculateRectangle(int input[][]) {
        int i = 0, j = 0, width = 0, hight = 0;

        int temp[][] = getCopy(input);
        
        createHistogram(input);
        HightWidth hw = null;
        
        for (int k = 0; k < input.length; k++) {
            hw = histoArea(input[k], k);

            if (this.area < hw.getWidth() * hw.getHight()) {
                i = hw.getI();
                j = hw.getJ();
                width = hw.getWidth();
                hight = hw.getHight();

                this.area = width * hight;
            }
        }

        this.startI = i - hight + 1;
        this.startJ = j;
        this.endI = i;
        this.endJ = j + width - 1;
        this.width = width;
        this.hight = hight;

        createResultMatrix(temp);
    }

    public void createResultMatrix(int input[][]) {

        if (this.area != 0) {
            this.result = new int[this.hight][this.width];
            for (int t = startI; t <= endI; t++) {
                for (int p = startJ; p <= endJ; p++) {
                    this.result[t - startI][p - startJ] = input[t][p];
                }
            }
        }

    }
}
