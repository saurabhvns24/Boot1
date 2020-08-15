package com.springrest.springrest.services;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entity.Course;
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;
	//List<Course> list;
       public CourseServiceImpl() {
    	/*   list=new ArrayList<>();
           list.add(new Course(145,"java core","This is java course"));
    	   list.add(new Course(146,"java advance","This is java course"));
    	   list.add(new Course(147,"java spring","This is java course"));*/
       }
	@Override
	public List<Course> getCouses() {
		return courseDao.findAll();
	}
	@Override
	public Course getCourse(String id) {
		long courseId=Long.parseLong(id);
		/*Course course1=null;
		for (Course course : list) {
			if(course.getId()==courseId) {
			course1=course;
			break;
			}
		}*/
		return courseDao.getOne(courseId);
	}
	@Override
	public Course addCourse(Course course) {
		courseDao.save(course);
		//list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		/*for (Course course1 : list) {
			if(course.getId()==course1.getId()) {
				course1.setTitle(course.getTitle());
				course1.setDescription(course.getDescription());
				break;
			}
		}*/
		courseDao.save(course);
		return course;
	}
	@Override
	public void deleteCourse(String courseId) {
		long id=Long.parseLong(courseId);
		//list=this.list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
		Course entity=courseDao.getOne(id);
		courseDao.delete(entity);
	}

}
