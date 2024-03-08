package View;

import Model.College;

import java.util.List;

public class StudentView {

    public static void showColleges(List<College> colleges){
        for(College college : colleges) System.out.println(college.toString());
    }
}
