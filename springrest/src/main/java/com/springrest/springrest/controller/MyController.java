package com.springrest.springrest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entity.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	//dependency injection is use here , and create object its self.
	@Autowired
	private CourseService courseService;
	
@GetMapping("/home")
public String home() {
	return "Saurabh";
}
// get the courses 
     @GetMapping("/courses")
     public List<Course> getCourse(){
      return this.courseService.getCouses();
     }
     //get course with id
     @GetMapping("/courses/{courseId}")
     public Course getSingleCourse(@PathVariable String courseId) {
    	 return this.courseService.getCourse(courseId);
     }
     //post course
     @PostMapping("/courses")
     public Course addCourseRequest(@RequestBody Course course) {
    	 courseService.addCourse(course);
    	 return course;
    	 
     }
     //Update Course using Put Method
     @PutMapping("/courses")
     public Course UpdateRequest(@RequestBody Course course) {
    	 return this.courseService.updateCourse(course);
     }
     
     //delete the course
     @DeleteMapping("/courses/{courseId}")
     public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
    	 try {
    		 this.courseService.deleteCourse(courseId);
    		 return new ResponseEntity<>(HttpStatus.OK);
    	 }
    	 catch(Exception e) {
     }      return new ResponseEntity<>(HttpStatus.OK);
     }
    
}
