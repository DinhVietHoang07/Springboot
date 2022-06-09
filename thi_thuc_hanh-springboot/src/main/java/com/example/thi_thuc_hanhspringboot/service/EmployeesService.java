package com.example.thi_thuc_hanhspringboot.service;

import com.example.thi_thuc_hanhspringboot.entity.Employees;
import com.example.thi_thuc_hanhspringboot.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService {
    @Autowired
    private EmployeesRepository employeesRepository;

    public List<Employees> findAll(){
        return employeesRepository.findAll();
    }
    public Optional<Employees> findById(String id){
        return employeesRepository.findById(id);
    }
    public Employees save(Employees employees){
        return employeesRepository.save(employees);
    }
    public void deleteById(String id){
        employeesRepository.deleteById(id);
    }
}
