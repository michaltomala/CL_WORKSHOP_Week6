package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetRepository tweetRepository;

    @GetMapping("/{id}/tweets")
    public String findAllTweets (Model model, @PathVariable Long id){

    User user =  userRepository.findOne(id);
    model.addAttribute("user",user);
    tweets(user);
    return "user/list";
    }

    @GetMapping("/search-tweets/{title}")
    public String findAllTweetsByTitle(@PathVariable String title){
        tweetsByString(title);
        return "user/secondList";
    }


    @GetMapping("/add")
    public String addUser (Model model , HttpServletRequest request){
        model.addAttribute("book",new User());
        model.addAttribute("formAction",request.getContextPath()+"/user/save");
        return "user/form";
    }

    // todo dam tu w przyszłości walidator jak starczy czasu i wtedy będzie działać
    @PostMapping("/save")
    public String saveUser (/*@Validated({.class}) User user, BindingResult errors,*/User user, HttpServletRequest request){
//        if(errors.hasErrors()){
//            return "user/form";
//        }
        userRepository.save(user);
        return "redirect:"+request.getContextPath()+"/user/list";
    }

    @GetMapping("/all")
    public String showAllUsers(Model model){
        model.addAttribute("users",userRepository.findAll())
        // todo w przyszłości zrobie ten widok
        return "all";
    }

    @ModelAttribute("users")
    public List<User> users(){ return userRepository.findAll(); }

    @ModelAttribute("tweets")
    public List<Tweet> tweets(User user){ return tweetRepository.findAllByUser(user); }

    @ModelAttribute("tweetsByString")
    public List<Tweet> tweetsByString(String title){ return tweetRepository.findAllByTweetTextIsLikeAndOrderByDate(title); }



}

