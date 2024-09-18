package s01;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * S01 - Manage student
 *
 * @author ThinhNPCE170008
 */
public class StudentManagement {

    private List<Student> students = new ArrayList<>();
    private static final String FILE_NAME = "Student.txt";

    /**
     * Main menu of the program
     */
    public void printMenu() {
        System.out.println("1. Enter student list");
        System.out.println("2. Look up student");
        System.out.println("3. Display student list");
        System.out.println("4. Exit");
        System.out.print("Please choose menu (1 - 4): ");
    }

    /**
     * How to add student information
     *
     * @param student List of student information
     */
    public void addStudent(Student student) {
        // Add the student directly to the list
        students.add(student);

        // Sort students by name after adding
        Collections.sort(students, Comparator.comparing(Student::getStudentName));

        System.out.println("Student added successfully.");
    }

    /**
     * Method to check if student code exists or not
     *
     * @param studentCode Pass the student code to the method as input and check
     * it against the student list.
     * @return Returns true if the student code already exists and vice versa.
     */
    public boolean isStudentCode(String studentCode) {
        // Use loop for to check it against the student list.
        for (Student s : students) {
            if (s.getStudentCode().equalsIgnoreCase(studentCode)) {
                return true;
            }
        }
        return false;
    }

    /**
     * How to search student information by name
     *
     * @param name Student name to search
     */
    public void searchStudentByName(String name) {
        name = name.toLowerCase(); // Convert the input name to lowercase
        List<Student> matchingStudents = new ArrayList<>();
        // Check if input name is in library
        for (Student student : students) {
            if (student.getStudentName().toLowerCase().contains(name)) {
                matchingStudents.add(student);
            }
        }
        if (matchingStudents.isEmpty()) {
            System.out.println("No matching students found.");
        } else {
            System.out.println("Matching students:");
            for (Student student : matchingStudents) {
                System.out.println(student.toString());
            }
        }
    }

    /**
     * How to display all student information in the library
     */
    public void displayStudents() {
        // Check if any student information already exists in the library
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("Student list:");
            for (Student student : students) {
                System.out.println(student.toString());
            }
        }
    }

    /**
     * Method of saving student information in library
     */
    public void saveStudents() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            for (Student student : students) {
                // Save student names in lowercase for easy reference
                writer.write(student.getStudentCode().toLowerCase() + "#" + student.getStudentName().toLowerCase() + "#"
                        + student.getDateOfBirth() + "#" + student.getLearningPoint() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * How to read student information in the library
     */
    public void loadStudents() {
        File file = new File(FILE_NAME);

        // Check if the file exists, if not, create an empty file
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    System.out.println("Failed to create " + FILE_NAME);
                }
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
                return;  // Return early since file creation failed
            }
        }

        students.clear(); // Make sure the list is empty before reading from the file.
        try (FileReader reader = new FileReader(FILE_NAME)) {
            StringBuilder content = new StringBuilder();
            int i;
            while ((i = reader.read()) != -1) {
                content.append((char) i);
            }

            // Convert content to string and cut groups when encountering "#"
            String[] lines = content.toString().split("\n");
            for (String line : lines) {
                String[] parts = line.split("#");
                if (parts.length == 4) {
                    students.add(new Student(parts[0], parts[1], parts[2], Float.parseFloat(parts[3])));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
