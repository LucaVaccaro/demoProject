package org.example.programmingproject2;

import java.io.IOException;
import java.util.ArrayList;

/**
 *  Handles files operations involving Student objects
 */
public interface FileHandler {

    /**
     * Saves a list of students to a specified file
     * @param fileName name of the file to save students to
     * @param students list of Student objects to save
     * @throws IOException I/O error occurs while writing to the file
     */
    void saveToFile(String fileName, ArrayList<Student> students) throws IOException;

    /**
     * Loads a list of students from a specified file
     * @param fileName name of the file to load the students from
     * @return list of Student objects loaded from the file
     * @throws IOException I/O error occurs while reading the file
     */
    ArrayList<Student> loadFromFile(String fileName) throws IOException;
}

