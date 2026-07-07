package com.example.course_management.service;

import com.example.course_management.dto.CourseResponse;
import com.example.course_management.model.Course;
import com.example.course_management.repository.CourseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Page<CourseResponse> getPagedCourses(int page, int size, String sortBy, Sort.Direction direction) {
        // Safety check for page parameter
        if (page < 0) {
            page = 0;
        }

        // Apply sorting logic: if sortBy is not passed (null or empty/blank), default to sorting by id
        String sortField = (sortBy == null || sortBy.trim().isEmpty()) ? "id" : sortBy;

        // Apply Sort.Direction to determine sort order (default DESC if direction is null)
        Sort.Direction sortDirection = (direction == null) ? Sort.Direction.DESC : direction;
        Sort sort = Sort.by(sortDirection, sortField);

        // Create Pageable object
        Pageable pageable = PageRequest.of(page, size, sort);

        // Fetch paginated data from database
        Page<Course> coursePage = courseRepository.findAll(pageable);

        // Map Page<Course> to Page<CourseResponse>
        return coursePage.map(course -> new CourseResponse(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getInstructor(),
                course.getPrice()
        ));
    }
}
