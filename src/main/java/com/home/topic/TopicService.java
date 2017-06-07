package com.home.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.course.Course;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getAll() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<Topic> get(String id) {
		return Optional.of(topicRepository.findOne(id));
	}
	
	public void add(Topic topic) {
		topicRepository.save(topic);
	}

	public void update(Topic topic, String id) {
		topicRepository.save(topic);
	}
	
	public void delete(String id) {
		topicRepository.delete(id);
	}
	
	public void addCourseToTopic(String topicId, Course course) {
		Topic topic = topicRepository.findOne(topicId);
		course.setTopic(topic);
		topic.addCourse(course);
		
		topicRepository.save(topic);
	}
	
}
