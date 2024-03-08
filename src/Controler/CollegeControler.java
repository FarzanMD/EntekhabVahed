package Controler;

import Model.College;
import Model.Course;
import View.AdminView;
import View.StudentView;

import java.util.List;

public class CollegeControler {

    public void getColleges(){
        StudentView.showColleges(new College().getItems());
    }

    public void getCourses(String collegeID){
        List<Course> courseList = new College().findByID(Integer.parseInt(collegeID)).getCoursesList();
        AdminView.showCourses(courseList);
    }
}
