package com.example.individualpr.Controllers;

import com.example.individualpr.Models.Employee;
import com.example.individualpr.Models.Post;
import com.example.individualpr.Models.User;
import com.example.individualpr.Repos.EmployeeRepos;
import com.example.individualpr.Repos.PostRepos;
import com.example.individualpr.Repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/adminEmployee")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class EmployeeController {

    @Autowired
    private UserRepos userRepository;

    @Autowired
    private EmployeeRepos employeeRepos;

    @Autowired
    private PostRepos postRepos;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String employeeList(Model model){
        model.addAttribute("employeers", employeeRepos.findAll());
        return "Employee/employee-main";
    }

    @GetMapping("/add")
    public String employeeAdd(Employee employee, Model model){
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("posts", postRepos.findAll());
        return "Employee/employee-add";
    }

    @PostMapping("/add")
    public String employeeAdd(@ModelAttribute("employee")@Valid Employee employee,
                              BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("users", userRepository.findAll());
            return "Employee/employee-add";
        }
        employeeRepos.save(employee);
        return "redirect:/adminEmployee";
    }

    @GetMapping("/edit/{employee}")
    @PreAuthorize("isAuthenticated()")
    public String employeeEdit(Employee employee, Model model) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("posts", postRepos.findAll());
        return "Employee/employee-edit";
    }

    @PostMapping("/edit/{employee}")
    @PreAuthorize("isAuthenticated()")
    public String employeePostEdit(
            @ModelAttribute("employee")@Valid Employee employee,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("users", userRepository.findAll());
            return "Employee/employee-edit";
        }
        employeeRepos.save(employee);
        return "redirect:../";
    }

    @GetMapping("/show/{employee}")
    public String employeeShow(
            Employee employee) {
        return "Employee/employee-detail";
    }

    @GetMapping("/del/{employee}")
    @PreAuthorize("isAuthenticated()")
    public String employeeDel(
            Employee employee) {
        employeeRepos.delete(employee);
        return "redirect:../";
    }

    @GetMapping("/filter")
    public String employeeFilter(@RequestParam(defaultValue = "") String surname,
                                 @RequestParam(required = false) boolean accurate_search,
                                 Model model) {
        if (!surname.equals("")) {
            List<Employee> result = accurate_search ? employeeRepos.findBySurname(surname) : employeeRepos.findBySurnameContains(surname);
            model.addAttribute("result", result);
        }
        model.addAttribute("surname", surname);
        model.addAttribute("accurate_search", accurate_search);
        return "Employee/employee-filter";
    }
}