package s01;

import java.util.Scanner;

/**
 * S01 - Manage student
 *
 * @author ThinhNPCE170008
 */
public class S01 {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagement stu = new StudentManagement();
        stu.loadStudents(); // Load students from file at the start

        while (true) {
            stu.printMenu();

            int choice = MyLib.getChoiceConditional("", "Invalid choice, please try again.", 1, 4);

            switch (choice) {
                case 1: // Function 1: Enter student list
                    System.out.println("Enter new student:");

                    String studentCode;
                    do {
                        studentCode = MyLib.getValidStudentCode("Student code: ", "Invalid student code, please re-enter");

                        // Check if student code already exists
                        if (stu.isStudentCode(studentCode)) {
                            System.out.println("Student code already exists, please enter a different code.");
                        } else {
                            break; // Exit the loop if the code is unique
                        }
                    } while (true); // Keep prompting until a unique code is entered

                    String studentName = MyLib.getPara("Student name: ", "Invalid student name, please re-enter");

                    String dateOfBirth = MyLib.getValidBirth("Date of birth (dd-MMM-yyyy): ", "");

                    float learningPoint = MyLib.getPositiveFloat("Learning point: ", "Invalid point, please re-enter");

                    Student student = new Student(studentCode, studentName, dateOfBirth, learningPoint);
                    stu.addStudent(student);
                    stu.saveStudents();
                    break;

                case 2: // Function 2: Look up student
                    String name = MyLib.getPara("Please enter student name: ", "Invalid student name, please re-enter");
                    stu.searchStudentByName(name);
                    break;

                case 3: // Function 3: Display student list
                    stu.displayStudents();
                    break;

                case 4: // Stop the program
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }
    }
}
