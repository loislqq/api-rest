package com.practice.restapi.service;

import com.practice.restapi.persistence.Department;
import com.practice.restapi.persistence.DepartmentRepository;
import org.hibernate.query.spi.QueryOptionsAdapter;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartmentService {
    DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public List<Department> getAll(){
        return this.repository.findAll();
    }

    public Department getById(Long id){
        return this.repository.findById(id).get();
    }

    public Department add(Department department){
        return this.repository.saveAndFlush(department);
    }

    public Department update(Long id, Department department){
        Optional<Department> dept = this.repository.findById(id);
        if(dept.isPresent()){
            dept.get().setName(department.getName());
            return this.repository.save(dept.get());
        }
        throw new RuntimeException();
    }

    public void delete(Long id){
        this.repository.deleteById(id);
    }
}
