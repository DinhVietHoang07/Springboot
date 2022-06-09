package com.example.thi_thuc_hanhspringboot.controller;

import com.example.thi_thuc_hanhspringboot.entity.Employees;
import com.example.thi_thuc_hanhspringboot.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path = "api/v1/employees")

public class EmployeesController {

    @Autowired
    EmployeesService employeesService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Employees>> getList(){
        return ResponseEntity.ok(employeesService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> getDetail(@PathVariable String id){
        Optional<Employees> optionalEmployees = employeesService.findById(id);
        if (!optionalEmployees.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalEmployees.get());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Employees> create(@RequestBody Employees employees){
        return ResponseEntity.ok(employeesService.save(employees));
    }


    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        if (!employeesService.findById(id).isPresent()){
            ResponseEntity.badRequest().build();
        }
        employeesService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Employees> update(@PathVariable String id, @RequestBody Employees updateEmployees){
        Optional<Employees> optionalEmployees = employeesService.findById(id);
        if (!optionalEmployees.isPresent()){
            ResponseEntity.badRequest().build();
        }
        Employees existEmployees = optionalEmployees.get();

        existEmployees.setId(existEmployees.getId());
        existEmployees.setName(existEmployees.getName());
        return ResponseEntity.ok(employeesService.save(existEmployees));

    }
}
