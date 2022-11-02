package com.example.individualpr.Controllers;

import com.example.individualpr.Models.*;
import com.example.individualpr.Repos.ClientRepos;
import com.example.individualpr.Repos.OrderRepos;
import com.example.individualpr.Repos.OrderStatusRepos;
import com.example.individualpr.Repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/orderSotr")
public class OrderController {
    @Autowired
    private OrderStatusRepos orderStatusRepos;

    @Autowired
    private ClientRepos clientRepos;

    @Autowired
    private OrderRepos orderRepos;

    @GetMapping()
    public String orderList(Model model){
        model.addAttribute("orders", orderRepos.findAll());
        model.addAttribute("orderStatus", orderStatusRepos.findAll());
        model.addAttribute("client", clientRepos.findAll());
        return "Order/main";
    }

    @GetMapping("/add")
    @PreAuthorize("hasAnyAuthority('EMPLOYEE')")
    public String orderAdd(Order order, Model model){
        List<Client> clients = clientRepos.findAll();
        model.addAttribute("client", clientRepos.findAll());
        Iterable<OrderStatus> orderStatuses = orderStatusRepos.findAll();
        model.addAttribute("orderStatus", orderStatusRepos.findAll());
        return "Order/add";
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('EMPLOYEE')")
    public String orderAdd(@ModelAttribute("order") @Valid Order order,
                            BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
//            model.addAttribute("orderStatuses", orderStatusRepos.findAll());
//            model.addAttribute("clientes", clientRepos.findAll());
            return "Order/add";
        }
        orderRepos.save(order);
        return "redirect:";
    }

    @GetMapping("/edit/{order}")
    @PreAuthorize("hasAnyAuthority('EMPLOYEE')")
    public String orderEdit(Order order, Model model) {
        List<Client> clients = clientRepos.findAll();
        model.addAttribute("client", clientRepos.findAll());
        Iterable<OrderStatus> orderStatuses = orderStatusRepos.findAll();
        model.addAttribute("orderStatus", orderStatusRepos.findAll());
        return "Order/edit";
    }

    @PostMapping("/edit/{order}")
    @PreAuthorize("hasAnyAuthority('EMPLOYEE')")
    public String orderPostEdit(
            @ModelAttribute("order") @Valid Order order,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "Order/edit";
        }
        orderRepos.save(order);
        return "redirect:../";
    }

    @GetMapping("/detail/{order}")
    public String orderShow(Order order, Model model) {
        return "Order/detail";
    }

    @GetMapping("/del/{order}")
    @PreAuthorize("hasAnyAuthority('EMPLOYEE')")
    public String orderDel(
            Order order) {
        orderRepos.delete(order);
        return "redirect:../";
    }
}
