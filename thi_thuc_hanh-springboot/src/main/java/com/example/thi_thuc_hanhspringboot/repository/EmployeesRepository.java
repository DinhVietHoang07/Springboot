package com.example.thi_thuc_hanhspringboot.repository;

import com.example.thi_thuc_hanhspringboot.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeesRepository extends JpaRepository<Employees, String> {

    List<Employees> findAll();

    Employees save(Employees employees);

    void deleteById(String id);

    Optional<Employees> findById(String id);
}
