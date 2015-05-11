package com.task.task2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Sergey
 */
class Solver {
    private ArrayList<String> content;  

    public Solver() {
        content = new ArrayList<String>();
    }

    public ArrayList<String> getContent() {
        return content;
    }
    
    /**
     * Recuresively creates a list of the elements directory and subdirectories
     *
     * @param path level of folders tree
     * @param file data file 
    */
    public void printTree(int depth, File file) throws IOException {
        StringBuilder indent = new StringBuilder();
        String name = file.getName();

        for (int i = 0; i < depth; i++) {
            indent.append(".");
        }

        if (file.isDirectory()) {
            //System.out.println(indent.toString() + "|");
            content.add(indent.toString() + "|");
            if (isPrintName(name)) {
                //System.out.println(indent.toString() + "*" + file.getName() + "*");
                content.add(indent.toString() + "*" + file.getName() + "*");
            }
        } 
        else if (isPrintName(name)) {
            //System.out.println(indent.toString() + file.getName());
            content.add(indent.toString() + file.getName());
        }
        
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                printTree(depth + 4, files[i]);
            }
        }
    }

    /**
     * Do we need to print this folder
     *
     * @param name folder name
    */
    public boolean isPrintName(String name) {
        if (name.charAt(0) == '.') {
            return false;
        }
        
        if (name.contains("svn")) {
            return false;
        }
        return true;
    }

}
