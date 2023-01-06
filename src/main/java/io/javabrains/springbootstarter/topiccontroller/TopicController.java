package io.javabrains.springbootstarter.topiccontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopic();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable  String id){
        return topicService.getTopic(id);
    }
    @RequestMapping(method = RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topic topic){
    topicService.addService(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic,@PathVariable String id){
        topicService.updateService(id,topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/topics/{id}")
    public void deleteTopic(@RequestBody Topic topic,@PathVariable String id){
        topicService.deleteService(id);
    }
}
