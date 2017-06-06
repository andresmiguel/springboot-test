package com.home.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>((Arrays.asList(
			new Topic("music", "Best Music", "Talk about the best music"),
			new Topic("guitars", "Guitars", "Best guitars"))));
	
	public List<Topic> getAll() {
		return topics;
	}
	
	public Optional<Topic> get(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst();
	}
	
	public void add(Topic topic) {
		topics.add(topic);
	}

	public void update(Topic topic, String id) {
		for (int i = 0; i < topics.size(); i++) {
			if (topics.get(i).getId().equals(id)){
				topics.set(i, topic);
				return;
			}
		}
	}
	
	public void delete(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
	
}
