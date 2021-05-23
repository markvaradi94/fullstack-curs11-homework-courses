package ro.fasttrackit.curs11.homework.courses.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.curs11.homework.courses.model.entity.CourseStudentEntity;

import java.util.Optional;

public interface CourseStudentRepository extends MongoRepository<CourseStudentEntity, String> {
    Optional<CourseStudentEntity> findByCourseId(String courseId);
}
