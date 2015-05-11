package com.task.task11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Class represents a solving task of selecting all different words
 *
 * @author Sergey
 */
class UniqueRegWordsSplitter {

    private static HashMap<String, Integer> uniqueWords;

    public UniqueRegWordsSplitter() {
        uniqueWords = new HashMap<String, Integer>();
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
                Integer value = uniqueWords.get(word);

                if (value != null) {
                    uniqueWords.put(word, value + 1);
                } else {
                    uniqueWords.put(word, 1);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, Integer> getUniqueWords() {
        return uniqueWords;
    }
}

