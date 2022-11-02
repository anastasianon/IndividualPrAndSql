package com.example.individualpr.Controllers;

import com.example.individualpr.Models.Employee;
import com.example.individualpr.Models.Post;
import com.example.individualpr.Models.User;
import com.example.individualpr.Repos.EmployeeRepos;
import com.example.individualpr.Repos.PostRepos;
import com.example.individualpr.Repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/adminPost")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class PostController {

    @Autowired
    private PostRepos postRepos;

    @GetMapping
    public String postList(Model model){
        Iterable<Post> posts = postRepos.findAll();
        model.addAttribute("postest",posts);
        return "Post/main";
    }

    @GetMapping("/add")
    public String postAdd(Post post, Model model){
        Iterable<Post> posts = postRepos.findAll();
        model.addAttribute("postest",posts);
        return "Post/add";
    }

    @PostMapping("/add")
    public String postAdd(@ModelAttribute("post")@Valid Post post,
                              BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "Post/add";
        }
        postRepos.save(post);
        return "redirect:/adminPost";
    }

    @GetMapping("/edit/{post}")
    public String postEdit(Post post, Model model) {
        model.addAttribute("posts", postRepos.findAll());
        return "Post/edit";
    }

    @PostMapping("/edit/{post}")
    public String postPostEdit(
            @ModelAttribute("post") @Valid Post post,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "Post/edit";
        }
        postRepos.save(post);
        return "redirect:../";
    }

    @GetMapping("/del/{post}")
    public String postDel(
            Post post) {
        postRepos.delete(post);
        return "redirect:../";
    }
}
