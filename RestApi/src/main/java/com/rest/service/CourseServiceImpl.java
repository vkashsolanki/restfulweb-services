package com.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.model.Course;


@Service
public class CourseServiceImpl implements CourseService{
	
	
	List<Course> list;
	
	
	CourseServiceImpl(){
		
		list = new ArrayList();
		list.add(new Course(12, "java", "it is popular languagae"));
		list.add(new Course(10,"python" ,"It is most famous laguage in the world"));
	}

	@Override
	public List<Course> getCourses() {
		
		return list;
	}

	@Override
	public Course getCourses(long id) {
		Course c = null;
		for(Course course: list) {
			if(course.getId() == id) {
				c=course;
				break;
			}
		}
		
		return c;
	}

	@Override
	public Course addCourses(Course course) {
	
		
		list.add(course);
		return course;
	}

}
