package ro.fasttrackit.curs11.homework.courses.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs11.homework.courses.exceptions.CourseNotFoundException;
import ro.fasttrackit.curs11.homework.courses.model.CourseFilters;
import ro.fasttrackit.curs11.homework.courses.model.api.Course;
import ro.fasttrackit.curs11.homework.courses.model.mappers.CourseMapper;
import ro.fasttrackit.curs11.homework.courses.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final CourseMapper mapper;

    @GetMapping
    List<Course> getAll(CourseFilters filters) {
        return mapper.toApi(courseService.getAll(filters));
    }

    @GetMapping("{courseId}")
    Course findById(@PathVariable String courseId) {
        return mapper.toApi(
                courseService.findById(courseId)
                        .orElseThrow(() -> new CourseNotFoundException("Could not find course"))
        );
    }

    @PostMapping
    Course addCourse(@RequestBody Course course) {
        return mapper.toApi(
                courseService.addCourse(mapper.toEntity(course))
        );
    }
}
