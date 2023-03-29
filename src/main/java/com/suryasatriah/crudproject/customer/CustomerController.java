package com.suryasatriah.crudproject.customer;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public String getCustomers(Model model) {
        List<Customer> listCustomer = customerService.listCustomers();
        model.addAttribute("listCustomer", listCustomer);
        return "customers";
    }

    @RequestMapping("/new")
    public String newCustomer(Map<String, Object> model) {
        Customer customer = new Customer();
        model.put("customer", customer);
        return "new_customer";
    }

    @RequestMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editCustomer(@PathVariable("id") long id) {
        ModelAndView mav = new ModelAndView("edit_customer");
        Customer customer = customerService.getCustomer(id);
        return mav.addObject("customer", customer);
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        List<Customer> result = customerService.search(keyword);
        model.addAttribute("result", result);
        return "search";
    }

    // Login form
    @RequestMapping("/login.html")
    public String login() {
        return "login.html";
    }

    // Login form with error
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }

    @GetMapping("/customers_ajax")
    public String getCustomersAjax() {
        return "customers_ajax"; 
    }

}