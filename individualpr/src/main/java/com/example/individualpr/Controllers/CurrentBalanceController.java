package com.example.individualpr.Controllers;

import com.example.individualpr.Models.CurrentBalance;
import com.example.individualpr.Models.ProductContent;
import com.example.individualpr.Repos.CurrentBalanceRepos;
import com.example.individualpr.Repos.ProductContentRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/employCurrentBalance")
@PreAuthorize("hasAnyAuthority('EMPLOYEE')")
public class CurrentBalanceController {
    @Autowired
    private CurrentBalanceRepos currentBalanceRepos;

    @GetMapping()
    public String curBalList(Model model){
        Iterable<CurrentBalance> currentBalances = currentBalanceRepos.findAll();
        model.addAttribute("currentBalances",currentBalances);
        return "CurrentBalance/main";
    }

    @GetMapping("/add")
    public String curBalAdd(CurrentBalance currentBalance, Model model){
        return "CurrentBalance/add";
    }

    @PostMapping("/add")
    public String curBalAdd(@ModelAttribute("currentBalance")@Valid CurrentBalance currentBalance,
                              BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "CurrentBalance/add";
        }
        currentBalanceRepos.save(currentBalance);
        return "redirect:";
    }

    @GetMapping("/edit/{currentBalance}")
    public String curBalEdit(CurrentBalance currentBalance, Model model) {
        return "CurrentBalance/edit";
    }

    @PostMapping("/edit/{currentBalance}")
    public String curBalPostEdit(
            @ModelAttribute("currentBalance") @Valid CurrentBalance currentBalance,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "CurrentBalance/edit";
        }
        currentBalanceRepos.save(currentBalance);
        return "redirect:../";
    }

    @GetMapping("/del/{currentBalance}")
    public String curBalDel(
            CurrentBalance currentBalance) {
        currentBalanceRepos.delete(currentBalance);
        return "redirect:../";
    }
}
