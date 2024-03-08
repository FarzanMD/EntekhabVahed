package View;

import Model.College;
import Model.Course;
import Model.Student;

import java.util.List;

public class AdminView {
    //تغییر ظرفیت
    //افزودن دانشجو
    //درست کردن یه کورس جدید


    public AdminView() {
    }
    public static void showStudents(List<Student> students){
        for (Student student : students) System.out.println(student.toString());
    }
    public static void showCourses(List<Course> courses){

        for (Course course : courses) System.out.println(course.toString());
    }

    //increase Capacity (int courseID) : بعد میاد ظرفیت اون کورس رو عوض میکنه

    //add student (int studentID و int courseID) : آیدی دانشجو رو میگیره و به لیست دانشجو های یه کورس خاص که اونم آیدیشو میگیره آضافه میکنه
    //remove student(int studentID) : آیدی دانشجو رو میگیره بعد میاد اون آیدیو از لیست کورس حذف میکنه

    //creat new courses
}
