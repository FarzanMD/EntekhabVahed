package Model;

import java.util.List;
import java.util.Scanner;

public class Student extends Model{
    private int ID;
    private String username;
    private String password;
    private int studentCollegeID;
    private List<Integer> studentCourses;

    public Student(int ID, String username, String password, int studentCollegeID, List<Integer> studentCourses) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.studentCollegeID = studentCollegeID;
        this.studentCourses = studentCourses;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public int earnedUnits(){
        Scanner sc = new Scanner("StudentDataBase.txt");
        int a =0;
        return a;
    }

    @Override
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStudentCollegeID() {
        return studentCollegeID;
    }

    public void setStudentCollegeID(int studentCollegeID) {
        this.studentCollegeID = studentCollegeID;
    }

    public List<Integer> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(List<Integer> studentCourses) {
        this.studentCourses = studentCourses;
    }
}
