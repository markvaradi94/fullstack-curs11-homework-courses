package ro.fasttrackit.curs11.homework.courses.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.curs11.homework.courses.model.entity.CourseEntity;

public interface CourseRepository extends MongoRepository<CourseEntity, String> {
}
