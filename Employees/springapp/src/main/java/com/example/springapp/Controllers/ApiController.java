package com.example.springapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.Models.Employee;
import com.example.springapp.Services.ApiService;


@RestController
public class ApiController {

    @Autowired
    public ApiService apiService;

    @PostMapping("/")
    public boolean addEmployee(@RequestBody Employee employee){
        return apiService.addEmployee(employee);
    }
    
    @GetMapping("/{field}")
    public List<Employee> getSorting(@PathVariable String field){
        return apiService.getSorting(field);
    }

    @GetMapping("/{offset}/{pagesize}")
    public Page<Employee> getPagination(@PathVariable int offset, @PathVariable int pagesize){
        return apiService.getPagination(offset,pagesize);
    }

    @GetMapping("/{offset}/{pagesize}/{field}")
    public Page<Employee> getPaginationWithSorting(@PathVariable int offset, @PathVariable int pagesize,@PathVariable String field){
        return apiService.getPaginationWithSorting(offset,pagesize,field);
    }

}
