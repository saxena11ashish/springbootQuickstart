package com.learning.springbootstarter.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service        //in spring, business services are typically singletons
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring framework", "Spring framework description"),
            new Topic("java", "Core java", "Core java description"),
            new Topic("javascript", "JavaScript", "JS description")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
        for(Topic i: topics) {
            if (id.equals(i.getId())) {
                i.setId(topic.getId());
                i.setDescription(topic.getDescription());
                i.setName(topic.getName());
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
    }
}
