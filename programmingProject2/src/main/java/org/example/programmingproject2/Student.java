package org.example.programmingproject2;

/**
 * Represents a student, extending the Person class
 * Stores specific information about a student such as name, ID and GPA.
 */
public class Student extends Person {
    private int id;
    private double gpa;

    public Student(String name, int id, double gpa) {
        super(name);
        this.id = id;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    /**
     * Provides a description of the student.
     * Overrides the abstract method from Person class
     * @return
     */
    @Override
    public String getDescription() {
        return ", Name: " + getName() + "\nStudent ID: " + id + ",\nGPA: " + gpa + "\n--------------------\n";
    }

    /**
     * Converts student's details into a string representation
     * @return a string representation of the student's details
     */
    @Override
    public String toString() {
        return getDescription();
    }
}

