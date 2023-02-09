package com.example.springapp.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.springapp.Models.Student;
import com.example.springapp.Repositories.StudentRepo;
import com.mysql.cj.result.Field;




@Service
public class ApiService {

    @Autowired
    public StudentRepo studentRepo;

    public boolean addEmployee(Student student) {
        return studentRepo.save(student) != null ? true : false;
    }

    public List<Student> getSorting(String field) {
        return (List<Student>) studentRepo.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public Page<Student> getPagination(int offset, int pageSize){
        Page<Student> students = studentRepo.findAll(PageRequest.of(offset, pageSize));
        return students;
    }

    public Page<Student> getPaginationWithSorting(int offset, int pageSize, String field){
        Page<Student> students = studentRepo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return students;
    }
    
}
