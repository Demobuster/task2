package com.service;

import java.io.File;
import java.util.StringTokenizer;

/**
 *
 * @author Sergey
 */
public class ValidationUtil {

    public static boolean isFileExist(String filePathString) {
        File f = new File(filePathString);
        return (f.exists() && !f.isDirectory());
    }

    public static boolean isNumericSequence(String sequence) {  
        for (StringTokenizer stringTokenizer = new StringTokenizer(sequence); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken();
            if (!isNumeric(token)) {
                return false;
            }
        }
        
        return true;
    }  

    public static boolean isNumeric(String str) {
        try {
            double d = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public static boolean isEquation(String str) {
        str = str.replace(" ", "");
        
        return str.matches("((\\+|-)?\\d+(\\*x\\^)?\\d+)+");
    }
}