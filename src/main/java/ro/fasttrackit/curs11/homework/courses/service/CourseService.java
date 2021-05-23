package ro.fasttrackit.curs11.homework.courses.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.curs11.homework.courses.model.CourseFilters;
import ro.fasttrackit.curs11.homework.courses.model.entity.CourseEntity;
import ro.fasttrackit.curs11.homework.courses.repository.CourseMongoDao;
import ro.fasttrackit.curs11.homework.courses.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.unmodifiableList;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseMongoDao courseDao;
    private final CourseRepository courseRepository;

    public List<CourseEntity> getAll(CourseFilters filters) {
        return unmodifiableList(courseDao.findCourses(filters));
    }

    public CourseEntity addCourse(CourseEntity course) {
        return courseRepository.save(course);
    }

    public Optional<CourseEntity> findById(String courseId) {
        return courseRepository.findById(courseId);
    }
}
