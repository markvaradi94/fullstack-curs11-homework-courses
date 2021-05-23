package ro.fasttrackit.curs11.homework.courses.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs11.homework.courses.model.CourseStudentFilters;
import ro.fasttrackit.curs11.homework.courses.model.entity.CourseStudentEntity;
import ro.fasttrackit.curs11.homework.courses.repository.CourseStudentDao;
import ro.fasttrackit.curs11.homework.courses.repository.CourseStudentRepository;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toUnmodifiableList;

@Service
@RequiredArgsConstructor
public class StudentCourseService {
    private final CourseStudentDao courseStudentDao;
    private final CourseStudentRepository repository;

    public List<CourseStudentEntity> getAll(CourseStudentFilters filters) {
        return unmodifiableList(courseStudentDao.findAll(filters));
    }

    public CourseStudentEntity addCourseStudent(CourseStudentEntity entity) {
        return repository.save(entity);
    }

    public List<CourseStudentEntity> findAllStudentsByCourse(String courseId) {
        return repository.findAll().stream()
                .filter(courseStudent -> courseStudent.getCourseId().equalsIgnoreCase(courseId))
                .collect(toUnmodifiableList());
    }

    public Optional<CourseStudentEntity> findByCourseId(String courseId) {
        return repository.findByCourseId(courseId);
    }
}
