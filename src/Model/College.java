package Model;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class College extends Model<College> {
    private int ID;
    private String name;
    private List<Integer> collegeCourses = new ArrayList<>();
    private List<Integer> collegeStudents = new ArrayList<>();
    String path = "src/Model/CollegeDataBase.txt";

    public College(int ID, String name, List<Integer> collegeCourses, List<Integer> collegeStudents) {
        this.ID = ID;
        this.name = name;
        this.collegeCourses = collegeCourses;
        this.collegeStudents = collegeStudents;
    }
    public College(){
        super();
        read();
    }

    @Override
    public void read(){
        List<College> colleges = new ArrayList<>();
        try(FileInputStream reader = new FileInputStream(new File("src/Model/CollegeDataBase.txt"))){
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()){
                String[] a = sc.nextLine().split(",");
                List<Integer> b = new ArrayList<>();
                for (String c : a[2].split("/")){
                    b.add(Integer.parseInt(c));
                }
                List<Integer> d = new ArrayList<>();
                for (String e : a[3].split("/")){
                    d.add(Integer.parseInt(e));
                }
                colleges.add(new College(Integer.parseInt(a[0]) , a[1],b,d));
            }
            setItems(colleges);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

            for(College college : getItems()){
                writer.write(college.toWrite());
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
        for(Integer s : collegeStudents){
            studentsString += s;
            if(collegeStudents.indexOf(s) < collegeStudents.size() -1) studentsString += "/";
        }
        String courseString = "";
        for(Integer s : collegeCourses){
            courseString += s;
            if(collegeCourses.indexOf(s) < collegeCourses.size() -1) courseString += "/";
        }

        return ID +","+name+","+courseString+","+studentsString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<Integer> getCollegeCourses() {
        return collegeCourses;
    }

    public void setCollegeCourses(List<Integer> collegeCourses) {
        this.collegeCourses = collegeCourses;
    }

    public List<Integer> getCollegeStudents() {
        return collegeStudents;
    }

    public List<Course> getCoursesList(){
        List<Course> courses = new ArrayList<>();
        for(Integer courseId : collegeCourses){
            Course course = new Course().findByID(courseId);
            courses.add(course);
        }
        return  courses;
    }
    @Override
    public String toString (){
        return ID + "-" + name;
    }
    public void setCollegeStudents(List<Integer> collegeStudents) {
        this.collegeStudents = collegeStudents;
    }
    public void addCourse(int ID){
        collegeCourses.add(ID);
    }
}
