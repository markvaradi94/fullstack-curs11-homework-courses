package ro.fasttrackit.curs11.homework.courses.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Builder
@Document(collection = "courses")
@NoArgsConstructor
@AllArgsConstructor
public class CourseEntity {
    @Id
    private String id;

    private String discipline;

    private String description;
}
