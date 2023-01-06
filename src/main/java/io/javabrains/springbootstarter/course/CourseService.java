package io.javabrains.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository topicRepository;

  /* private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("Spring","Spring Framework","Spring Framework Description"),
                new Topic("java", "Core java" ,"Core Java Description"),
                new Topic("javascript","javascript","javascript description")
   ));*/

   public List<Course> getAllTopic(){
       //
       // return topics;
       List<Course> topics= new ArrayList<>();
       topicRepository.findAll().forEach(topics::add);
       return topics;
   }


    public Course getTopic(String id) {

       //return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
        return topicRepository.findOne(id);
    }

    public void addService(Course topic) {

       //topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateService(String id, Course topic) {
      /* for(int i = 0 ; i<topics.size();i++)
       {
           Topic t = topics.get(i);
           if(t.getId().equals(id)){
               topics.set(i,topic);
               return;
           }}*/
        topicRepository.save(topic);

    }

    public void deleteService(String id) {
     /*   for(int i = 0 ; i<topics.size();i++)
        {
            Topic t = topics.get(i);
            if(t.getId().equals(id)){
                topics.remove(i);
                return;
            }        }
*/
        topicRepository.delete(id);
    }
}
