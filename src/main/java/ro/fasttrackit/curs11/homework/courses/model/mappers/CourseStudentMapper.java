package ro.fasttrackit.curs11.homework.courses.model.mappers;

import org.springframework.stereotype.Component;
import ro.fasttrackit.curs11.homework.courses.model.api.CourseStudent;
import ro.fasttrackit.curs11.homework.courses.model.entity.CourseStudentEntity;

@Component
public class CourseStudentMapper implements Mapper<CourseStudent, CourseStudentEntity> {

    @Override
    public CourseStudent toApi(CourseStudentEntity source) {
        if (source == null) {
            return null;
        }

        var target = new CourseStudent();
        target.setId(source.getId());
        target.setCourseId(source.getCourseId());
        target.setStudentId(source.getStudentId());
        target.setGrade(source.getGrade());

        return target;
    }

    @Override
    public CourseStudentEntity toEntity(CourseStudent source) {
        if (source == null) {
            return null;
        }

        var target = new CourseStudentEntity();
        target.setId(source.getId());
        target.setCourseId(source.getCourseId());
        target.setStudentId(source.getStudentId());
        target.setGrade(source.getGrade());

        return target;
    }
}
