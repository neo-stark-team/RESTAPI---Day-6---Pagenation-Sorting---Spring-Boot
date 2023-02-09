package com.example.springapp.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.springapp.Models.Employee;
import com.example.springapp.Repositories.EmployeeRepo;
import com.mysql.cj.result.Field;




@Service
public class ApiService {

    @Autowired
    public EmployeeRepo employeeRepo;

    public boolean addEmployee(Employee employee) {
        return employeeRepo.save(employee) != null ? true : false;
    }

    public List<Employee> getSorting(String field) {
        return (List<Employee>) employeeRepo.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public Page<Employee> getPagination(int offset, int pageSize){
        Page<Employee> employees = employeeRepo.findAll(PageRequest.of(offset, pageSize));
        return employees;
    }

    public Page<Employee> getPaginationWithSorting(int offset, int pageSize, String field){
        Page<Employee> employees = employeeRepo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return employees;
    }
    
}
