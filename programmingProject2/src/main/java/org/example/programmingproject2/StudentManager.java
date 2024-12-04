package org.example.programmingproject2;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages a collection of student objects, adding ways to add students, saving to a file,
 * and loading from a file.
 * Implements FileHandler interface for file operations.
 */
public class StudentManager implements  FileHandler{
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    /**
     * Adds a student to the collection.
     * @param student The student object to be added.
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Saves the list of students to a specified file.
     * @param fileName name of the file to save to.
     * @param students list of students to save.
     * @throws IOException  I/O error occurs while writing to the file
     */
    @Override
    public void saveToFile(String fileName, ArrayList<Student> students) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName), true)) {
            for (Student student : students) {
                writer.printf("Name: %s\nID: %d\nGPA: %.2f\n--------------------\n",
                        student.getName(),
                        student.getId(),
                        student.getGpa());
            }
        }
    }

    /**
     * Loads the list of students from a specified file
     * @param fileName name of the file to load from
     * @return Arraylist of students objects loaded from the file
     * @throws IOException I/O error occurs while reading to the file
     */
    @Override
    public ArrayList<Student> loadFromFile(String fileName) throws IOException {
        ArrayList<Student> loadedStudents = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String nameLine = scanner.nextLine();
                String idLine = scanner.nextLine();
                String gpaLine = scanner.nextLine();
                scanner.nextLine();

                String name = nameLine.substring(nameLine.indexOf(":") + 2);
                int id = Integer.parseInt(idLine.substring(idLine.indexOf(":") + 2));
                double gpa = Double.parseDouble(gpaLine.substring(gpaLine.indexOf(":") + 2));

                loadedStudents.add(new Student(name, id, gpa));
            }
            students = loadedStudents;
            return loadedStudents;
        }
    }


    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}