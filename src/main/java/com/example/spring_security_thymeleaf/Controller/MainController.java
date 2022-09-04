package com.example.spring_security_thymeleaf.Controller;

import com.example.spring_security_thymeleaf.Model.DTOs.UserRegistrationDto;
import com.example.spring_security_thymeleaf.Service.CommentService;
import com.example.spring_security_thymeleaf.Service.TopicService;
import com.example.spring_security_thymeleaf.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;
    private final TopicService topicService;
    private final CommentService commentService;


    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/forum")
    public String forum(Model model){
        model.addAttribute("listOfTopics", topicService.findAllTopics());
        return "forum";
    }

    @PostMapping("/deleteTopic")
    public String deleteComment(@RequestParam String topicId, Model model){
        topicService.deleteTopic(topicId);
        model.addAttribute("listOfTopics", topicService.findAllTopics());
        return "forum";
    }

    @GetMapping("/comment/{id}")
    public String comment(@PathVariable Long id, Model model){
        model.addAttribute("listOfComments", commentService.findAllCommentsByTopic(id));
        model.addAttribute("topicId", id);
        return "comment";
    }

    @PostMapping("/comment/{id}")
    public String addComment(@PathVariable Long id, @RequestParam String text, Model model){
        commentService.saveComment(userService.getLoggedInUserString(), text, id);
        model.addAttribute("username", userService.getLoggedInUserString());
        model.addAttribute("listOfComments", commentService.findAllCommentsByTopic(id));
        return "comment";
    }

    @PostMapping("/deleteComment/{id}")
    public String deleteComment(@PathVariable Long id, @RequestParam String commentId, Model model){
        commentService.deleteComment(commentId);
        model.addAttribute("listOfComments", commentService.findAllCommentsByTopic(id));
        return "comment";
    }
}