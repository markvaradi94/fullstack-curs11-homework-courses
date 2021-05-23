package ro.fasttrackit.curs11.homework.courses.model;

import lombok.Value;

@Value
public class CourseStudentFilters {
    String studentId;
    String courseId;
    Integer grade;
}
