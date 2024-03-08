package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends Model<Student>{
    private int ID;
    private String username;
    private String password;
    private int studentCollegeID;
    private List<Integer> studentCourses;
    String path = "src/Model/StudentDataBase.txt";

    public Student(int ID, String username, String password, int studentCollegeID, List<Integer> studentCourses) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.studentCollegeID = studentCollegeID;
        this.studentCourses = studentCourses;
    }

    public Student() {
        super();
        read();
    }


    public void addCourses(int courseID){
        Course course = new Course();
        if (course.findByID(courseID)!= null){
                    studentCourses.add(courseID);

        }
    }

    public void removeCourse(int courseID){
        Course course = new Course();
        if (course.findByID(courseID)!= null){
            studentCourses.removeIf(c-> c == courseID);
        }
    }

    @Override
    public void read(){
        List<Student> students = new ArrayList<>();
        try(FileInputStream reader = new FileInputStream(new File("src/Model/StudentDataBase.txt"))){
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()){

                String[] a = sc.nextLine().split(",");
                List<Integer> courseList =  new ArrayList<>();
                for (String c : a[4].split("/")){
                    courseList.add(Integer.parseInt(c));
                }
                students.add(new Student(Integer.parseInt(a[0]),a[1],a[2],Integer.parseInt(a[3]),courseList));
            }

            setItems(students);
        } catch (IOException e) {
        }catch (ArrayIndexOutOfBoundsException e){}
    }

    //نیاز به تغییرات
    @Override
    public void updateFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

            for(Student student : getItems()){
                writer.write(student.toWrite());
                writer.newLine();
            }
            writer.flush();
            writer.close();


        } catch (IOException e) {
            //fuck
        }
    }
    public String toWrite(){
        String studentsString = "";
        for(Integer s : studentCourses){
            studentsString += s;
            if(studentsString.indexOf(s) < studentCourses.size() -1) studentsString += "/";
        }

        return ID +","+username+","+password+","+studentCollegeID+","+studentsString;
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
    @Override
    public String toString(){
        return ID + "-" + username;
    }
}
