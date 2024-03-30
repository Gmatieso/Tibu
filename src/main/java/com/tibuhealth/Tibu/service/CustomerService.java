package com.tibuhealth.Tibu.service;

import com.tibuhealth.Tibu.model.Customer;
import com.tibuhealth.Tibu.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    //create a meethod that returns a list of Customer
    public List<Customer> getAllCustomers(){
        // creating a List
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    //get a customer
    public Customer getCustomer(Long id){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        // Check if optional customer contains a value, and return it if present
        if (optionalCustomer.isPresent()){
            return optionalCustomer.get();
        }else {
            //Handle the case where the topic with the given ID was not found
            // here we could throw an exceptional or return null
            return null;
        }

    }

    // Add a Customer
    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    /*
    Loop through every customer depending on the size of the customer for each customer in the list compare with the id
    if it matches update it
     */

    // update a customer
    public void updateCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void deleteCustomer(Customer id){
        customerRepository.delete(id);
    }









}
