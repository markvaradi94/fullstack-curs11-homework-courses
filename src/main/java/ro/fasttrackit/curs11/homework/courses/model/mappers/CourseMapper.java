package ro.fasttrackit.curs11.homework.courses.model.mappers;

import org.springframework.stereotype.Component;
import ro.fasttrackit.curs11.homework.courses.model.api.Course;
import ro.fasttrackit.curs11.homework.courses.model.entity.CourseEntity;

@Component
public class CourseMapper implements Mapper<Course, CourseEntity> {
    @Override
    public Course toApi(CourseEntity source) {
        if (source == null) {
            return null;
        }

        var target = new Course();
        target.setId(source.getId());
        target.setDescription(source.getDescription());
        target.setDiscipline(source.getDiscipline());

        return target;
    }

    @Override
    public CourseEntity toEntity(Course source) {
        if (source == null) {
            return null;
        }

        var target = new CourseEntity();
        target.setId(source.getId());
        target.setDescription(source.getDescription());
        target.setDiscipline(source.getDiscipline());

        return target;
    }
}
