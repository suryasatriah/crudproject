package com.suryasatriah.crudproject.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers_ajax/list")
    public ResponseEntity<List<Customer>> getCustomerList() {
        return new ResponseEntity<List<Customer>>(customerService.listCustomers(), HttpStatus.OK);
    }

    @GetMapping("/customer_ajax/{id}")
    public ResponseEntity<Customer> getCompany(@PathVariable Long id) {
        return new ResponseEntity<Customer>(customerService.getCustomer(id), HttpStatus.OK);
    }

    @PostMapping("/customers_ajax/save")
    public ResponseEntity<Void> saveOrUpdateCompany(@RequestBody Customer customer) {
        customerService.save(customer);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/customers_ajax/delete/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
