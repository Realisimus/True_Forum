package forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ForumController {

    @Autowired
    Forum forum;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allTopics() {
        return new ModelAndView("forum", "topics", forum.getAllTopics());
    }

    @RequestMapping(value = "/viewTopic", method = RequestMethod.POST)
    public ModelAndView viewTopic(@ModelAttribute("topic") String topic){
        return new ModelAndView("topic", "posts", forum.getTopic(topic).getAllPosts());
    }

    @RequestMapping(value = "/addTopic", method = RequestMethod.GET)
    public ModelAndView addTopic(){
        return new ModelAndView("addTopic", "command", new Post());
    }

    @RequestMapping(value = "/addTopic", method = RequestMethod.POST)
    public ModelAndView addTopic(@ModelAttribute("post") Post post){
        forum.addTopic(post);
        return viewTopic(post.getTopicName());
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.GET)
    public ModelAndView addPost(@ModelAttribute("topicName") String topicName){
        return new ModelAndView("addPost", "post", new Post(topicName));
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    public ModelAndView addPost(@ModelAttribute("post") Post post){
        Topic topic = forum.getTopic(post.getTopicName());
        topic.addPost(post);
        return viewTopic(post.getTopicName());
    }

    @RequestMapping(value = "/editPost", method = RequestMethod.POST)
    public ModelAndView editPost(@ModelAttribute("post") Post post, HttpServletRequest request){
        if (request.getParameter("button").contains("Delete post"))
            forum.getTopic(post.getTopicName()).deletePost(post.getId());

        if (request.getParameter("button").contains("Save post")) {
            Post existPost = forum.getTopic(post.getTopicName()).getPost(post.getId());
            existPost.setText(post.getText());
        }
        return viewTopic(post.getTopicName());
    }

    @RequestMapping(value = "/editTopicName", method = RequestMethod.POST)
    public ModelAndView editTopicName(@ModelAttribute("topicName") String topicName, HttpServletRequest request){
        Topic topic = forum.getTopic(request.getParameter("oldTopicName"));
        for (Post post : topic.getAllPosts())
            post.setTopicName(topicName);
        forum.changeTopic(topic, request.getParameter("oldTopicName"));
        return viewTopic(topicName);
    }
}
