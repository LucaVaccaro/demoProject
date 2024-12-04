package org.example.programmingproject2;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;

/**
 * Class for managing the Student management system Gui.
 * This class Handles user input, files and table view updates.
 */
public class StudentController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField nameField;
    @FXML
    private TextField idField;
    @FXML
    private TextField gpaField;
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, Integer> idColumn;
    @FXML
    private TableColumn<Student, Double> gpaColumn;

    private StudentManager studentManager;
    private ObservableList<Student> studentList;

    /**
     * Initializes the controller and sets up the table view with data connections.
     */
    @FXML
    public void initialize() {
        studentManager = new StudentManager();
        studentList = FXCollections.observableArrayList();
        tableView.setItems(studentList);

        nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("Name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("Id"));
        gpaColumn.setCellValueFactory(new PropertyValueFactory<Student, Double>("Gpa"));
    }

    /**
     * Handles the action of adding a new student.
     * Updates the student list and table view.
     */
    @FXML
    protected void onAddStudentClick() {
        try {
            String name = nameField.getText();
            int id = Integer.parseInt(idField.getText());
            double gpa = Double.parseDouble(gpaField.getText());



            Student student = new Student(name, id, gpa);
            studentManager.addStudent(student);
            studentList.add(student);


            nameField.clear();
            idField.clear();
            gpaField.clear();
            welcomeText.setText("Student added successfully!");
        } catch (NumberFormatException e) {
            welcomeText.setText("Please enter valid values for ID and GPA");
        }
    }

    /**
     * Handles the action of searching for a student by ID.
     * Filters the table view to show the student that was searched for or a not-found message.
     */
    @FXML
    protected void onSearchByIdClick() {
        try {
            int searchId = Integer.parseInt(idField.getText());
            studentList.clear();

            for (Student student : studentManager.getStudents()) {
                if (student.getId() == searchId) {
                    studentList.add(student);
                    welcomeText.setText("Student found!");
                    return;
                }
            }
            welcomeText.setText("Student with ID " + searchId + " not found");
        } catch (NumberFormatException e) {
            welcomeText.setText("Please enter a valid numeric ID");
        }
    }

    /**
     * Handles the action of loading student data from a file.
     * Updates the student list and table view with the loaded file.
     */
    @FXML
    protected void onLoadDataClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load Student Data");
        File file = fileChooser.showOpenDialog(new Stage());

        if (file != null) {
            try {
                studentManager.loadFromFile(file.getAbsolutePath());
                studentList.clear();
                studentList.addAll(studentManager.getStudents());
                welcomeText.setText("Data loaded successfully!");
            } catch (IOException e) {
                welcomeText.setText("Failed to load data");
            }
        }
    }

    /**
     * Handles the action of saving student data to a file.
     * Writes the current student list to the chosen file.
     */
    @FXML
    protected void onSaveDataClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Student Data");
        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null) {
            try {
                studentManager.saveToFile(file.getAbsolutePath(), studentManager.getStudents());
                welcomeText.setText("Data saved successfully!");
            } catch (IOException e) {
                welcomeText.setText("Failed to save data");
            }
        }
    }
}
