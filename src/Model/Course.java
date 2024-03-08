package Model;

import java.util.List;
import java.util.Scanner;

public class Course extends Model<Course> {
    private String name;
    private int ID;
    private int unit;
    private String Date;
    private int startTime;
    private int endTime;
    private int courseCapacity;
    private String teacherName;
    private String examTime;
    private List<Integer> courseStudents;


    public Course(String name, int ID, int unit, String date, int startTime, int endTime, int courseCapacity, String teacherName, String examTime, List<Integer> courseStudents) {
        this.name = name;
        this.ID = ID;
        this.unit = unit;
        Date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.courseCapacity = courseCapacity;
        this.teacherName = teacherName;
        this.examTime = examTime;
        this.courseStudents = courseStudents;
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

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getCourseCapacity() {
        return courseCapacity;
    }

    public void setCourseCapacity(int courseCapacity) {
        this.courseCapacity = courseCapacity;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public List<Integer> getCourseStudents() {
        return courseStudents;
    }

    public void setCourseStudents(List<Integer> courseStudents) {
        this.courseStudents = courseStudents;
    }
}
