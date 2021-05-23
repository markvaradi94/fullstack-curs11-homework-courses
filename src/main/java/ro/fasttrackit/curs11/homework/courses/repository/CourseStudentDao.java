package ro.fasttrackit.curs11.homework.courses.repository;

import org.springframework.stereotype.Repository;
import ro.fasttrackit.curs11.homework.courses.model.CourseStudentFilters;
import ro.fasttrackit.curs11.homework.courses.model.entity.CourseStudentEntity;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;

@Repository
public class CourseStudentDao {
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public CourseStudentDao(EntityManager entityManager) {
        this.entityManager = entityManager;
        criteriaBuilder = this.entityManager.getCriteriaBuilder();
    }

    public List<CourseStudentEntity> findAll(CourseStudentFilters filters) {
        CriteriaQuery<CourseStudentEntity> criteria = criteriaBuilder.createQuery(CourseStudentEntity.class);
        Root<CourseStudentEntity> root = criteria.from(CourseStudentEntity.class);

        List<Predicate> whereClause = new ArrayList();
        ofNullable(filters.getCourseId())
                .ifPresent(courseId -> whereClause.add(criteriaBuilder.equal(root.get("courseId"), courseId)));
        ofNullable(filters.getStudentId())
                .ifPresent(studentId -> whereClause.add(criteriaBuilder.equal(root.get("studentId"), studentId)));
        ofNullable(filters.getGrade())
                .ifPresent(grade -> whereClause.add(criteriaBuilder.equal(root.get("grade"), grade)));

        CriteriaQuery<CourseStudentEntity> query = criteria.select(root).where(whereClause.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}
