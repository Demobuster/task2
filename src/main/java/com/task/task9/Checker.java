package com.task.task9;

import java.util.*;

/**
 * Checks if a given sequence valid
 * @param sequence a sequence to be checked
 * @author Sergey
 */
class Checker {

    public static boolean solve(String sequence, String open, String close) {
        Stack<String> stack = new Stack<String>();
        StringTokenizer st = new StringTokenizer(sequence, "\t\n\r+*/-(){}[]", true);

        while (st.hasMoreElements()) {
            String tmp = st.nextToken();
            
            if (open.contains(tmp)) {
                stack.push(tmp);
            }
            if (close.contains(tmp)) {
                if (stack.isEmpty()) {
                    return false;
                }
                
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}