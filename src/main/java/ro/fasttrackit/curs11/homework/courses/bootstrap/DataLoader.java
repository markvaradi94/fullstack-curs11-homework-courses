package ro.fasttrackit.curs11.homework.courses.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.fasttrackit.curs11.homework.courses.model.entity.CourseEntity;
import ro.fasttrackit.curs11.homework.courses.service.CourseService;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final CourseService courseService;

    @Override
    public void run(String... args) throws Exception {
        courseService.addCourse(CourseEntity.builder()
                .discipline("Physics")
                .description("101 - Beginners")
                .build()
        );
    }
}
