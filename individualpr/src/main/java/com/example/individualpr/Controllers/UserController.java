package com.example.individualpr.Controllers;

import com.example.individualpr.Models.Role;
import com.example.individualpr.Models.User;
import com.example.individualpr.Repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserRepos userRepository;
    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "User/usermain";
    }

    @GetMapping("/{id}/edit")
    public String userEdit(@PathVariable(value = "id") long id, Model model){
        Optional<User> user = userRepository.findById(id);
        ArrayList<User> res = new ArrayList<>();
        user.ifPresent(res::add);
        model.addAttribute("user", res);
        model.addAttribute("roles", Role.values());
        return "User/useredit";
    }

    @PostMapping
    public String userSave(@RequestParam String username, @RequestParam(name="roles[]", required = false) String[] roles,
                           @RequestParam("userId") User user){
        user.setLogin(username);
        user.getRoles().clear();
        if(roles!=null)
        {
            Arrays.stream(roles).forEach(r->user.getRoles().add(Role.valueOf(r)));
        }
        userRepository.save(user);

        return "redirect:/admin";
    }
}