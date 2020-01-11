package com.example.courseapidata.course;

import com.example.courseapidata.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourse(@PathVariable String id){
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicId}/course/{id}")
    public Optional<Course> getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/topics/{topicId}/course")
    public void addCourse(@RequestBody Course course,@PathVariable String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/topics/{topicId}/course/{courseId}")
    public void updateCourse(@RequestBody Course course,@PathVariable String topicId,@PathVariable String courseId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/topics/{topicId}/course")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}
