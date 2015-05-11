package com.task.task3;

import java.util.*;

/**
 *
 * @author Sergey
 */
class Solver {

    private Piece piece;

    /**
     * Initializing the Piece class
     */
    public Solver(String path) {
        piece = new Piece(path);
    }

    /**
     * Sorting method invoke
     */
    public void solve() {
        piece.sort();
    }

    public Piece getPiece() {
        return piece;
    }

}

class StringsLengthComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}