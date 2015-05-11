package com.task.task10;

import java.io.*;
import java.util.*;

/**
 * Class represents a task solver which is selecting all different words
 *
 * @author Sergey
 */
class UniqueWordsSplitter {

    private static HashSet<String> uniqueWords;

    public UniqueWordsSplitter() {
        uniqueWords = new HashSet<String>();
    }

    public static HashSet<String> getUniqueWords() {
        return uniqueWords;
    }

    /**
     * Selects a different words
     */
    public static void solve(String file) {
        Scanner scanner;

        try {
            scanner = new Scanner(new File(System.getProperty("user.home") + "/app-root/data/" + file));
            scanner.useDelimiter("[\\W]+");

            while (scanner.hasNext()) {
                String word = scanner.next();
                uniqueWords.add(word.toLowerCase());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
