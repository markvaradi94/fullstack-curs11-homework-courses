package ro.fasttrackit.curs11.homework.courses.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.curs11.homework.courses.model.CourseFilters;
import ro.fasttrackit.curs11.homework.courses.model.entity.CourseEntity;

import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;

@Repository
@RequiredArgsConstructor
public class CourseMongoDao {
    private final MongoTemplate mongo;

    public List<CourseEntity> findCourses(CourseFilters filters) {
        Query query = new Query();
        List<Criteria> criteria = buildCriteria(filters);

        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[0])));
        }

        return mongo.find(query, CourseEntity.class);
    }

    private List<Criteria> buildCriteria(CourseFilters filters) {
        List<Criteria> criteria = new ArrayList<>();

        ofNullable(filters.getDescription())
                .ifPresent(description -> criteria.add(Criteria.where("description").regex(description)));
        ofNullable(filters.getDiscipline())
                .ifPresent(discipline -> criteria.add(Criteria.where("discipline").is(discipline)));
        return criteria;
    }
}
