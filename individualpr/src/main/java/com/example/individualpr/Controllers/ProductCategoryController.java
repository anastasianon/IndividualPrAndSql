package com.example.individualpr.Controllers;

import com.example.individualpr.Models.ProductCategory;
import com.example.individualpr.Models.ProductContent;
import com.example.individualpr.Repos.ProductCategoryRepos;
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
@RequestMapping("/adminProductCategory")
@PreAuthorize("hasAnyAuthority('EMPLOYEE')")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryRepos productCategoryRepos;

    @GetMapping()
    public String prodCategList(Model model){
        Iterable<ProductCategory> productCategories = productCategoryRepos.findAll();
        model.addAttribute("productCategories",productCategories);
        return "ProductCategory/main";
    }

    @GetMapping("/add")
    public String prodCategAdd(ProductCategory productCategory, Model model){
        return "ProductCategory/add";
    }

    @PostMapping("/add")
    public String prodCategAdd(@ModelAttribute("productCategory")@Valid ProductCategory productCategory,
                              BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "ProductCategory/add";
        }
        productCategoryRepos.save(productCategory);
        return "redirect:";
    }

    @GetMapping("/edit/{productCategory}")
    public String prodCategEdit(ProductCategory productCategory, Model model) {
        return "ProductCategory/edit";
    }

    @PostMapping("/edit/{productCategory}")
    public String prodCategPostEdit(
            @ModelAttribute("productCategory") @Valid ProductCategory productCategory,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "ProductCategory/edit";
        }
        productCategoryRepos.save(productCategory);
        return "redirect:../";
    }

    @GetMapping("/del/{productCategory}")
    public String prodCategDel(
            ProductCategory productCategory) {
        productCategoryRepos.delete(productCategory);
        return "redirect:../";
    }
}
