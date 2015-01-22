package forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ForumController {

    @Autowired
    Forum forum;

    private boolean userCheck(String id) {
        if (forum.getUserById(id).login() == null) return true;
        else return false;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView login(String message) {
        return new ModelAndView("login", "message", message);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String login, String password, HttpServletResponse response) {
        User user = forum.getUser(login);
        if (password.equals(user.password())) {
            user.setSessionId();
            Cookie userId = new Cookie("id", user.getSessionId());
            userId.setMaxAge(3600);
            response.addCookie(userId);
            return forum(user.getSessionId());
        } else
            return login("Login or password is incorrect");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletResponse response) {
        Cookie userId = new Cookie("id", "");
        userId.setMaxAge(0);
        response.addCookie(userId);
        return login("");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(String message) {
        return new ModelAndView("register", "message", message);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(String login, String password, String password2) {
        if (!password.equals(password2)) return register("please input correct passwords");
        if (forum.getUser(login).login() != null) return register("User already exist");
        User user = new User(login, password);
        forum.addUser(user);
        return login("User was created. Please login to True Forum");
    }


    @RequestMapping(value = "/forum", method = RequestMethod.GET)
    public ModelAndView forum(@CookieValue("id") String cookieId) {
        if (userCheck(cookieId)) return new ModelAndView("login");
        ModelAndView forumView = new ModelAndView("forum", "topics", forum.getAllTopics());
        forumView.addObject("user", forum.getUserById(cookieId).login());
        return forumView;
    }

    @RequestMapping(value = "/viewTopic", method = RequestMethod.POST)
    public ModelAndView viewTopic(@ModelAttribute("topic") String topic, @CookieValue("id") String cookieId){
        if (userCheck(cookieId)) return new ModelAndView("login");
        return new ModelAndView("topic", "posts", forum.getTopic(topic).getAllPosts());
    }

    @RequestMapping(value = "/addTopic", method = RequestMethod.GET)
    public ModelAndView addTopic(@CookieValue("id") String cookieId){
        if (userCheck(cookieId)) return new ModelAndView("login");
        return new ModelAndView("addTopic", "command", new Post());
    }

    @RequestMapping(value = "/addTopic", method = RequestMethod.POST)
    public ModelAndView addTopic(@ModelAttribute("post") Post post, @CookieValue("id") String cookieId){
        if (userCheck(cookieId)) return new ModelAndView("login");
        post.setUser(forum.getUserById(cookieId).login());
        forum.addTopic(post);
        return viewTopic(post.getTopicName(), cookieId);
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.GET)
    public ModelAndView addPost(@ModelAttribute("topicName") String topicName, @CookieValue("id") String cookieId){
        if (userCheck(cookieId)) return new ModelAndView("login");
        return new ModelAndView("addPost", "post", new Post(topicName));
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    public ModelAndView addPost(@ModelAttribute("post") Post post, @CookieValue("id") String cookieId){
        if (userCheck(cookieId)) return new ModelAndView("login");
        Topic topic = forum.getTopic(post.getTopicName());
        post.setUser(forum.getUserById(cookieId).login());
        topic.addPost(post);
        return viewTopic(post.getTopicName(), cookieId);
    }

    @RequestMapping(value = "/editPost", method = RequestMethod.POST)
    public ModelAndView editPost(@ModelAttribute("post") Post post, HttpServletRequest request, @CookieValue("id") String cookieId){
        if (userCheck(cookieId)) return new ModelAndView("login");
        if (request.getParameter("button").contains("Delete post"))
            forum.getTopic(post.getTopicName()).deletePost(post.getId());

        if (request.getParameter("button").contains("Save post")) {
            Post existPost = forum.getTopic(post.getTopicName()).getPost(post.getId());
            existPost.setText(post.getText());
            existPost.setUser(forum.getUserById(cookieId).login());
        }
        return viewTopic(post.getTopicName(), cookieId);
    }

    @RequestMapping(value = "/editTopicName", method = RequestMethod.POST)
    public ModelAndView editTopicName(@ModelAttribute("topicName") String topicName, HttpServletRequest request, @CookieValue("id") String cookieId){
        if (userCheck(cookieId)) return new ModelAndView("login");
        Topic topic = forum.getTopic(request.getParameter("oldTopicName"));
        for (Post post : topic.getAllPosts())
            post.setTopicName(topicName);
        forum.changeTopic(topic, request.getParameter("oldTopicName"));
        return viewTopic(topicName, cookieId);
    }
}
