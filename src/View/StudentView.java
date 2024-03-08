package View;

import Model.College;
import Model.Course;

import java.util.List;

public class StudentView {
    public StudentView() {
    }

    public static void showColleges(List<College> colleges) {
        for (College college : colleges) System.out.println(college.toString());
    }

    public void showCourses(List<Course> courses) {
        for (Course course : courses) System.out.println(course.toString());
    }

    public void showMassage(String massage) {
        System.out.println(massage);
    }

    //showMyCourses (int studentID) : then show courses if this specefic student's courses

    // add course(int courseID) : add courses to some list then write the list in file infront of that specefic student
    // remove course
    //در واقع بیاد کلا هر دفعه که یه چیزی ادد یا ریموو میشه بیاد یه دور آپدیت کنه فایلو

    // boolean haveCapacity
    // boolean haveOverlap



}
