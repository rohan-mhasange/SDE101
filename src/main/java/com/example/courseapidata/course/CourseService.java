package com.example.courseapidata.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    private List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course("spring","spring framework","spring framework description"),
            new Course("java","core java","core java description"),
            new Course("javascript","javascript","javascript description")
    ));

    public List<Course> getAllCourses(String id) {
        List<Course> courses = new ArrayList<Course>();

        courseRepository.findByTopicId(id).forEach(courses:: add);
        return courses;
    }
    public Optional<Course> getCourse(String courseId) {
        return courseRepository.findById(courseId);
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }
    public void updateCourse(Course course){
        courseRepository.save(course);
    }
    public void deleteCourse(String id){
        courseRepository.deleteById(id);
    }
}
