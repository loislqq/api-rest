package com.practice.restapi.resource;

import com.practice.restapi.persistence.Department;
import com.practice.restapi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/depart")
public class DepartmentResource {

    DepartmentService service;

    @Autowired
    public DepartmentResource(DepartmentService service) {
        this.service = service;
    }

    @GetMapping(value = "/departments")
    public List<Department> getAll(){
        return this.service.getAll();
    }

    @GetMapping(value = "/departments/{id}")
    public Department getById(@PathVariable Long id){
        return this.service.getById(id);
    }

    @PostMapping(value = "/departments")
    public ResponseEntity<Department> add(@RequestBody Department department){
        Department dep = this.service.add(department);
        return new ResponseEntity<>(dep, HttpStatus.CREATED);
    }

    @PutMapping(value = "/departments/{id}", consumes = "application/json")
    public ResponseEntity<Department> update(@PathVariable Long id, @RequestBody Department department){
        Department dep = this.service.update(id, department);
        return new ResponseEntity<>(dep, HttpStatus.OK);
    }

    @DeleteMapping(value = "/departments/{id}")
    public void delete(@PathVariable Long id){
        this.service.delete(id);
    }
}
