package com.task.task1;

import java.io.*;
import java.util.*;

/**
 * 
 * @author Sergey
 */
class Reverse {
    private Deque<String> deque;
    
    /**
     * Providing data from file 
     *
     * @param path data file absolute path
     */
    public Reverse(String file) {
        deque = new LinkedList<String>();

        try {
        	BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/app-root/data/" + file));
            String tmp = "";

            while ((tmp = br.readLine()) != null) {
                deque.push(tmp);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Deque<String> getDeque() {
        return deque;
    }
    
    /**
     * Displays rows in the file in reverse order
     */
    public void solve() {
    	PrintWriter outFile;
		try {
			outFile = new PrintWriter(
					new FileWriter(
							new File(System.getProperty("user.home") + "/app-root/data/FirstTaskOutput.doc"), false)); 
			
			while (!deque.isEmpty()) {
				outFile.println(deque.pop() + System.getProperty("line.separator"));
	        }
			outFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
