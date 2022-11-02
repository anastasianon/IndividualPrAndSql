package com.example.individualpr.Controllers;

import com.example.individualpr.Models.ProductCategory;
import com.example.individualpr.Models.ProductType;
import com.example.individualpr.Repos.ProductCategoryRepos;
import com.example.individualpr.Repos.ProductTypeRepos;
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
import java.util.List;

@Controller
@RequestMapping("/adminProductType")
@PreAuthorize("hasAnyAuthority('EMPLOYEE')")
public class ProductTypeController {
    @Autowired
    private ProductTypeRepos productTypeRepos;

    @Autowired
    private ProductCategoryRepos productCategoryRepos;

    @GetMapping()
    public String prodTypeList(Model model){
        Iterable<ProductType> productTypes = productTypeRepos.findAll();
        model.addAttribute("productTypes",productTypes);
        model.addAttribute("productCategory",productCategoryRepos.findAll());
        return "ProductType/main";
    }

    @GetMapping("/add")
    public String prodTypeAdd(ProductType productType, Model model){
        Iterable<ProductCategory> productCategories = productCategoryRepos.findAll();
        model.addAttribute("productCategory", productCategoryRepos.findAll());
        return "ProductType/add";
    }

    @PostMapping("/add")
    public String prodTypeAdd(@ModelAttribute("productType")@Valid ProductType productType,
                               BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "ProductType/add";
        }
        productTypeRepos.save(productType);
        return "redirect:";
    }

    @GetMapping("/edit/{productType}")
    public String prodTypeEdit(ProductType productType, Model model) {
        Iterable<ProductCategory> productCategories = productCategoryRepos.findAll();
        model.addAttribute("productCategory", productCategoryRepos.findAll());
        return "ProductType/edit";
    }

    @PostMapping("/edit/{productType}")
    public String prodTypePostEdit(
            @ModelAttribute("productType") @Valid ProductType productType,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "ProductType/edit";
        }
        productTypeRepos.save(productType);
        return "redirect:../";
    }

    @GetMapping("/del/{productType}")
    public String prodTypeDel(
            ProductType productType) {
        productTypeRepos.delete(productType);
        return "redirect:../";
    }
}
