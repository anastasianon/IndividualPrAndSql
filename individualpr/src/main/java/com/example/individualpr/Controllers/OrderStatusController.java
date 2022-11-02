package com.example.individualpr.Controllers;

import com.example.individualpr.Models.Order;
import com.example.individualpr.Models.OrderStatus;
import com.example.individualpr.Models.Post;
import com.example.individualpr.Repos.OrderStatusRepos;
import com.example.individualpr.Repos.PostRepos;
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
@RequestMapping("/adminOrderStatus")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class OrderStatusController {
    @Autowired
    private OrderStatusRepos orderStatusRepos;

    @GetMapping
    public String orderSList(Model model){
        Iterable<OrderStatus> orderStatuses = orderStatusRepos.findAll();
        model.addAttribute("status",orderStatuses);
        return "OrderStatus/main";
    }

    @GetMapping("/add")
    public String orderSAdd(OrderStatus orderStatus, Model model){
        return "OrderStatus/add";
    }

    @PostMapping("/add")
    public String orderSAdd(@ModelAttribute("orderStatus")@Valid OrderStatus orderStatus,
                          BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "OrderStatus/add";
        }
        orderStatusRepos.save(orderStatus);
        return "redirect:/adminOrderStatus";
    }

    @GetMapping("/edit/{orderStatus}")
    public String orderSEdit(OrderStatus orderStatus, Model model) {
        return "OrderStatus/edit";
    }

    @PostMapping("/edit/{orderStatus}")
    public String orderSPostEdit(
            @ModelAttribute("orderStatus") @Valid OrderStatus orderStatus,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "OrderStatus/edit";
        }
        orderStatusRepos.save(orderStatus);
        return "redirect:../";
    }

    @GetMapping("/del/{orderStatus}")
    public String orderSDel(
            OrderStatus orderStatus) {
        orderStatusRepos.delete(orderStatus);
        return "redirect:../";
    }
}
