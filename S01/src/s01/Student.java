/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
package s01;

/**
 * S01 - Manage student
 *
 * @author ThinhNPCE170008
 */
public class Student {

    private String studentCode;
    private String studentName;
    private String dateOfBirth;
    private float learningPoint;

    /**
     * Initializes a new Students object with the provided parameters.
     *
     * @param studentCode Save input student code
     * @param studentName Save input student name
     * @param dateOfBirth Save the date of birth of students
     * @param learningPoint Save student learning point
     */
    public Student(String studentCode, String studentName, String dateOfBirth, float learningPoint) {
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.learningPoint = learningPoint;
    }

    /**
     * Returns the student code.
     *
     * @return the student code
     */
    public String getStudentCode() {
        return studentCode;
    }

    /**
     * Sets the student code.
     *
     * @param studentCode the new student code
     */
    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    /**
     * Returns the student name.
     *
     * @return the student name.
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Sets the student name.
     *
     * @param studentName the new student name
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Returns the date of birth.
     *
     * @return the date of birth.
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth.
     *
     * @param dateOfBirth the new date of birth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Returns the learning point.
     *
     * @return the learning point.
     */
    public float getLearningPoint() {
        return learningPoint;
    }

    /**
     * Sets the learning point.
     *
     * @param learningPoint the new learning point
     */
    public void setLearningPoint(float learningPoint) {
        this.learningPoint = learningPoint;
    }

    /**
     * Student information display method
     *
     * @return a string representation of the student
     */
    @Override
    public String toString() {
        String StudentName = FirstLetters(studentName);
        return "Student code: " + studentCode.toUpperCase() + "\n"
                + "Student name: " + StudentName + "\n"
                + "Date of birth: " + dateOfBirth + "\n"
                + "Learning point: " + learningPoint + "\n"
                + "---------------------------";
    }

    /**
     * Capitalize the first letter of each word in a string
     *
     * @param str the input string
     * @return the string with capitalized first letters
     */
    private String FirstLetters(String str) {
        String[] words = str.split(" ");
        StringBuilder Str = new StringBuilder();
        for (String word : words) {
            Str.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");
        }
        return Str.toString().trim();
    }
}
