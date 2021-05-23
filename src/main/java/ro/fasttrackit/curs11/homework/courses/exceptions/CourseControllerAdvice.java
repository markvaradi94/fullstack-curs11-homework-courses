package ro.fasttrackit.curs11.homework.courses.exceptions;

import lombok.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class CourseControllerAdvice {
    @ExceptionHandler(CourseNotFoundException.class)
    @ResponseStatus(BAD_REQUEST)
    ApiError handleCourseNotFoundException(CourseNotFoundException exception) {
        return new ApiError(exception.getMessage());
    }
}

@Value
class ApiError {
    String message;
}
