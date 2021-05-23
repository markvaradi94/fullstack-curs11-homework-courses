package ro.fasttrackit.curs11.homework.courses.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Builder
@Document(collection = "courseStudents")
@AllArgsConstructor
@NoArgsConstructor
public class CourseStudentEntity {
    @Id
    private String id;

    private String courseId;

    private String studentId;

    private Integer grade;
}
