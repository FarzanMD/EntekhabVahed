package Model;

import java.util.List;

public class College extends Model {
    private int ID;
    private String name;
    private List<Integer> collegeCourses ;
    private List<Integer> collegeStudents;

    public College(int ID, String name, List<Integer> collegeCourses, List<Integer> collegeStudents) {
        this.ID = ID;
        this.name = name;
        this.collegeCourses = collegeCourses;
        this.collegeStudents = collegeStudents;
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

    public void setCollegeStudents(List<Integer> collegeStudents) {
        this.collegeStudents = collegeStudents;
    }
}
