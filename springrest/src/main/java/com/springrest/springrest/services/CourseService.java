package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entity.Course;

public interface CourseService {
	public List<Course> getCouses();
	public Course getCourse(String id);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void deleteCourse(String courseId);

}
