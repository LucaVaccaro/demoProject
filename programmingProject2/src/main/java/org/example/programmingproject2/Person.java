package org.example.programmingproject2;

/**
 * Abstract class representing a person.
 * This is a base class for specific types of people, like students.
 */
public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Abstract method to get a description of the person.
     * Subclasses must provide their own implementation to describe a person.
     * @return A string containing the description of the person.
     */
    public abstract String getDescription();
}

