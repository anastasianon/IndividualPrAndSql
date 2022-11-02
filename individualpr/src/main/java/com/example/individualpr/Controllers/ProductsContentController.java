package com.example.individualpr.Controllers;

import com.example.individualpr.Models.Post;
import com.example.individualpr.Models.ProductContent;
import com.example.individualpr.Repos.PostRepos;
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
@RequestMapping("/adminProdС")
@PreAuthorize("hasAnyAuthority('EMPLOYEE')")
public class ProductsContentController {
    @Autowired
    private ProductContentRepos productContentRepos;

    @GetMapping()
    public String prodContList(Model model){
        Iterable<ProductContent> productContents = productContentRepos.findAll();
        model.addAttribute("productContents",productContents);
        return "ProductContent/main";
    }

    @GetMapping("/add")
    public String prodContAdd(ProductContent productContent, Model model){
        return "ProductContent/add";
    }

    @PostMapping("/add")
    public String prodContAdd(@ModelAttribute("productContent")@Valid ProductContent productContent,
                          BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "ProductContent/add";
        }
        productContentRepos.save(productContent);
        return "redirect:";
    }

    @GetMapping("/edit/{productContent}")
    public String prodContEdit(ProductContent productContent, Model model) {
        return "ProductContent/edit";
    }

    @PostMapping("/edit/{productContent}")
    public String prodContPostEdit(
            @ModelAttribute("productContent") @Valid ProductContent productContent,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "ProductContent/edit";
        }
        productContentRepos.save(productContent);
        return "redirect:../";
    }

    @GetMapping("/del/{productContent}")
    public String prodContDel(
            ProductContent productContent) {
        productContentRepos.delete(productContent);
        return "redirect:../";
    }
}
