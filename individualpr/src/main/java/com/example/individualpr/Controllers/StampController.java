package com.example.individualpr.Controllers;

import com.example.individualpr.Models.ProductCategory;
import com.example.individualpr.Models.ProductType;
import com.example.individualpr.Models.Stamp;
import com.example.individualpr.Repos.ProductCategoryRepos;
import com.example.individualpr.Repos.ProductTypeRepos;
import com.example.individualpr.Repos.StampRepos;
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
@RequestMapping("/employeeStamp")
@PreAuthorize("hasAnyAuthority('EMPLOYEE')")
public class StampController {
    @Autowired
    private StampRepos stampRepos;

    @Autowired
    private ProductTypeRepos productTypeRepos;

    @GetMapping()
    public String stampList(Model model){
        Iterable<Stamp> stamps = stampRepos.findAll();
        model.addAttribute("stamps",stamps);
        Iterable<ProductType> productTypes = productTypeRepos.findAll();
        model.addAttribute("productTypes", productTypes);

        return "Stamp/main";
    }

    @GetMapping("/add")
    public String stampAdd(Stamp stamp, Model model){
        Iterable<ProductType> productTypes = productTypeRepos.findAll();
        model.addAttribute("productTypes", productTypes);
        return "Stamp/add";
    }

    @PostMapping("/add")
    public String stampAdd(@ModelAttribute("stamp")@Valid Stamp stamp,
                              BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            Iterable<ProductType> productTypes = productTypeRepos.findAll();
            model.addAttribute("productTypes", productTypes);
            return "Stamp/add";
        }
        stampRepos.save(stamp);
        return "redirect:";
    }

    @GetMapping("/edit/{stamp}")
    public String stampEdit(Stamp stamp, Model model) {
        Iterable<ProductType> productTypes = productTypeRepos.findAll();
        model.addAttribute("productTypes", productTypes);
        return "Stamp/edit";
    }

    @PostMapping("/edit/{stamp}")
    public String stampPostEdit(
            @ModelAttribute("stamp") @Valid Stamp stamp,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Iterable<ProductType> productTypes = productTypeRepos.findAll();
            model.addAttribute("productTypes", productTypes);
            return "Stamp/edit";
        }
        stampRepos.save(stamp);
        return "redirect:../";
    }

    @GetMapping("/del/{stamp}")
    public String stampDel(
            Stamp stamp) {
        stampRepos.delete(stamp);
        return "redirect:../";
    }
}
