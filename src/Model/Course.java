package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Course extends Model<Course> {
    private int ID;
    private String name;
    private int unit;
    private int collegeID;
    private String teacherName;
    private String Date1;
    private String Date2;
    private int startTime;
    private int endTime;
    private List<Integer> courseStudents = new ArrayList<>();
    private String examDate;
    private int examTime;
    private int courseCapacity;
    String path = "src/Model/CourseDataBase.txt";


    public Course(int ID, String name, int unit, int collegeID, String teacherName, String date1, String date2, int startTime, int endTime, List<Integer> courseStudents, String examDate, int examTime, int courseCapacity) {
        this.ID = ID;
        this.name = name;
        this.unit = unit;
        this.collegeID = collegeID;
        this.teacherName = teacherName;
        Date1 = date1;
        Date2 = date2;
        this.startTime = startTime;
        this.endTime = endTime;
        this.courseStudents = courseStudents;
        this.examDate = examDate;
        this.examTime = examTime;
        this.courseCapacity = courseCapacity;
    }

    public Course() {
        super();
        read();
    }

    public String getDate1() {
        return Date1;
    }

    public void setDate1(String date1) {
        Date1 = date1;
    }

    public String getDate2() {
        return Date2;
    }

    public void setDate2(String date2) {
        Date2 = date2;
    }

    public void addStudent(int studentID) {
        Student student = new Student();
        if (student.findByID(studentID) != null) {
            courseStudents.add(studentID);
        }
    }
    public void removeStudent(int studentID) {
        Student student = new Student();
        if (student.findByID(studentID) != null) {
            courseStudents.removeIf(s -> s == studentID);
        }
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

@Override
public void read() {
    List<Course> courses = new ArrayList<>();
    try (FileInputStream reader = new FileInputStream(new File("src/Model/CourseDataBase.txt"))) {
        Scanner sc = new Scanner(reader);
        while (sc.hasNextLine()) {
            String[] a = sc.nextLine().split(",");
            List<Integer> studentList = new ArrayList<>();
            if (a[9].length() > 0) {
                for (String c : a[9].split("/")) {
                    studentList.add(Integer.parseInt(c));
                }
            }
            courses.add(new Course(Integer.parseInt(a[0]), a[1], Integer.parseInt(a[2]), Integer.parseInt(a[3]), a[4], a[5], a[6], Integer.parseInt(a[7]), Integer.parseInt(a[8]), studentList, a[10], Integer.parseInt(a[11]), Integer.parseInt(a[12])));
        }

        setItems(courses);
    } catch (IOException e) {
    }
}


//نیاز به تغییرات
@Override
public void updateFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

        for(Course course : getItems()){
            writer.write(course.toWrite());
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
        for(Integer s : courseStudents){
            studentsString += s;
            if(courseStudents.indexOf(s) < courseStudents.size() -1) studentsString += "/";
        }

        return ID +","+name+","+unit+","+collegeID+","+teacherName+","+Date1+","+Date2+","+startTime+","+endTime+","+studentsString+","+examDate+","+examTime+","+courseCapacity;
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

public int getExamTime() {
    return examTime;
}

public void setExamTime(int examTime) {
    this.examTime = examTime;
}

public int getCollegeID() {
    return collegeID;
}

public void setCollegeID(int collegeID) {
    this.collegeID = collegeID;
}

public String getExamDate() {
    return examDate;
}

public void setExamDate(String examDate) {
    this.examDate = examDate;
}

public List<Integer> getCourseStudents() {
    return courseStudents;
}

public void setCourseStudents(List<Integer> courseStudents) {
    this.courseStudents = courseStudents;
}

@Override
public String toString() {
    return ID + "-" + name;
}

public List<Student> getStudentList() {
    List<Student> courseStudent = new ArrayList<>();
    for (Integer courseId : courseStudents) {
        Student student = new Student().findByID(courseId);
        courseStudent.add(student);
    }
    return courseStudent;
}
}
