package Model;

import java.util.List;

public class Takhasosi extends Course{
    public Takhasosi(int ID, String name, int unit, int collegeID, String teacherName, String date1, String date2, int startTime, int endTime, List<Integer> courseStudents, String examDate, int examTime, int courseCapacity) {
        super(ID, name, unit, collegeID, teacherName, date1, date2, startTime, endTime, courseStudents, examDate, examTime, courseCapacity);
    }
}

