import Model.Course;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println(Course.getItems());
        Course.addItem(new Course("ali"));
        System.out.println(course.getItems().get(0).getName());

    }


}