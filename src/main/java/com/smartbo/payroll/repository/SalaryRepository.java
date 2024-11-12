package com.smartbo.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartbo.payroll.domain.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {

}
