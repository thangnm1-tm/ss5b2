package com.example.course_management.config;

import com.example.course_management.model.Course;
import com.example.course_management.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final CourseRepository courseRepository;

    public DataSeeder(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (courseRepository.count() == 0) {
            courseRepository.saveAll(Arrays.asList(
                    new Course("Java Core", "Basic Java programming concepts", "Nguyen Van A", 500.0),
                    new Course("Spring Boot Basic", "Introduction to Spring Boot framework", "Tran Van B", 750.0),
                    new Course("React JS for Beginners", "Frontend development with React JS", "Le Thi C", 600.0),
                    new Course("Python Programming", "Learn Python programming from scratch", "Pham Van D", 450.0),
                    new Course("Advanced Database Design", "Relational database concepts and sql", "Hoang Thi E", 900.0)
            ));
            System.out.println("Sample courses seeded successfully.");
        }
    }
}
