package Controler;

import Model.College;
import Model.Course;
import Model.Student;
import View.StudentView;
import View.AdminView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseControler {

    public void getStudents(String courseID) {
        List<Student> coursesListList = new Course().findByID(Integer.parseInt(courseID)).getStudentList();
        AdminView.showStudents(coursesListList);
    }
    public void addStudent(String courseID) {
        Course course = new Course().findByID(Integer.parseInt(courseID));
        if (course == null) {
            System.out.println("course not found");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("enter studentId to add");
        String studentId = sc.nextLine();
        try {
            if (course.getCourseStudents().contains(Integer.parseInt(studentId))) {
                System.out.println("student already in course");
                return;
            }
            Student student = new Student().findByID(Integer.parseInt(studentId));
            if (student == null) {
                System.out.println("no student found");
                return;
            }
            Course newCourses = new Course();
            Course newCourse = newCourses.findByID(course.getID());
            student.addCourses(course.getID());
            newCourse.addStudent(Integer.parseInt(studentId));
             newCourses.updateFile();
            System.out.println("student added");
        } catch (Exception e) {
            System.out.println("invalid id");
        }

    }
    public void removeStudent(String courseID) {
        Course course = new Course().findByID(Integer.parseInt(courseID));
        if (course == null) {
            System.out.println("course not found");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("enter studentId to remove");
        String studentId = sc.nextLine();
        try {
            if (!course.getCourseStudents().contains(Integer.parseInt(studentId))) {
                System.out.println("student in not in course");
                return;
            }
            Student student = new Student().findByID(Integer.parseInt(studentId));
            if (student == null) {
                System.out.println("no student found");
                return;
            }
            Course newCourses = new Course();
            Course newCourse = newCourses.findByID(course.getID());
            student.removeCourse(course.getID());
            newCourse.removeStudent(Integer.parseInt(studentId));
            newCourses.updateFile();
            System.out.println("student removed");
        } catch (Exception e) {
            System.out.println("invalid id");
        }
    }
    public void addCourse(String collegeID){
       Scanner sc = new Scanner(System.in);
        int ID = new Course().createNextId();
        System.out.println("please enter the course name");
        String name = sc.next();

        System.out.println("please enter the course's unit");
        int unit = sc.nextInt();

        int CollegeID = Integer.parseInt(collegeID);

        System.out.println("please enter the teacher name");
        String teacherName = sc.next();

        System.out.println("please enter the first course day");
        String Date1 = sc.next();

        System.out.println("please enter the second course day");
        String Date2 = sc.next();

        System.out.println("please enter the start time");
        int startTime = sc.nextInt();

        System.out.println("please enter the end time");
        int endTime = sc.nextInt();

        List<Integer> studentList = new ArrayList<>();

        System.out.println("please enter the exam date");
        String examDate = sc.next();

        System.out.println("please enter the exam time");
        int examTime = sc.nextInt();

        System.out.println("please enter the course capacity");
        int capacity = sc.nextInt();
        Course course = new Course(ID,name,unit,CollegeID,teacherName,Date1,Date2,startTime,endTime,studentList,examDate,examTime,capacity);
        Course course1 = new Course();
        course1.addItem(course);
        course1.updateFile();
        College colleges = new College();
        colleges.findByID(Integer.parseInt(collegeID)).addCourse(ID);
        colleges.updateFile();
        System.out.println("new course created");
    }
    public void editCapacity(String courseID){
        Course allCourses = new Course();
        Course course = allCourses.findByID(Integer.parseInt(courseID));
        if (course == null) {
            System.out.println("course not found");
            return;
        }
        try {

            Scanner sc = new Scanner(System.in);
            int cpt = course.getCourseCapacity();
            System.out.println("corrent capacity is " + cpt);
            System.out.println("enter new capacity");
            String newCapacity = sc.next();
            course.setCourseCapacity(Integer.parseInt(newCapacity));
            System.out.println("capacity edited");
            allCourses.updateFile();

        }catch (Exception e){

        }
    }

}
