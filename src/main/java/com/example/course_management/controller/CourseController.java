package com.example.course_management.controller;

import com.example.course_management.dto.ApiResponse;
import com.example.course_management.dto.CourseResponse;
import com.example.course_management.dto.PageResponse;
import com.example.course_management.service.CourseService;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public ResponseEntity<ApiResponse<PageResponse<CourseResponse>>> getCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sortBy,
            @RequestParam(defaultValue = "DESC") Sort.Direction direction
    ) {
        PageResponse<CourseResponse> pagedCourses = courseService.getPagedCourses(page, size, sortBy, direction);
        ApiResponse<PageResponse<CourseResponse>> response = ApiResponse.success("Ok", pagedCourses);
        return ResponseEntity.ok(response);
    }
}
