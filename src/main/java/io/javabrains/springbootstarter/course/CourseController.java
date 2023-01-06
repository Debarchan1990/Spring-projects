package io.javabrains.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService topicService;

    @RequestMapping("/topics")
    public List<Course> getAllTopics(){
        return topicService.getAllTopic();
    }

    @RequestMapping("/topics/{id}")
    public Course getTopic(@PathVariable  String id){
        return topicService.getTopic(id);
    }
    @RequestMapping(method = RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Course topic){
    topicService.addService(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/topics/{id}")
    public void updateTopic(@RequestBody Course topic, @PathVariable String id){
        topicService.updateService(id,topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/topics/{id}")
    public void deleteTopic(@RequestBody Course topic, @PathVariable String id){
        topicService.deleteService(id);
    }
}
