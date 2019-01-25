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
@RequestMapping("/tweet")
public class TweetController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetRepository tweetRepository;

    @GetMapping("/add")
    public String addTweet (Model model , HttpServletRequest request){
        model.addAttribute("tweet",new Tweet());
        model.addAttribute("formAction",request.getContextPath()+"/tweet/save");
        return "tweet/form";
    }

    // todo dam tu w przyszłości walidator jak starczy czasu i wtedy będzie działać
    @PostMapping("/save")
    @ResponseBody
    public String saveTweet (/* @Validated({.class}) Tweet tweet, BindingResult errors,*/Tweet tweet, HttpServletRequest request){
//        if(errors.hasErrors()){
//            return "tweet/form";
//        }
        tweetRepository.save(tweet);
        return "Okej,udało mi się zapisać !";
    }


    @ModelAttribute("userList")
    public List<User> BooksList(){ return userRepository.findAll(); }

}
