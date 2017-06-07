package com.home.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.topic.Topic;
import com.home.topic.TopicRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Course> getAll(String id) {
		List<Course> courses = new ArrayList<>();
		Topic topic = topicRepository.findOne(id);
		courses.addAll(topic.getAllCourses());
		
		return courses;
	}
	
	public Optional<Course> get(String id) {
		return Optional.of(courseRepository.findOne(id));
	}
	
	public void update(Course course, String id) {
		courseRepository.save(course);
	}
	
	public void delete(String id) {
		courseRepository.delete(id);
	}
}
