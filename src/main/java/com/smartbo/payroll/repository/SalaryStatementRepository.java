package com.smartbo.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartbo.payroll.domain.SalaryStatement;

@Repository
public interface SalaryStatementRepository extends JpaRepository<SalaryStatement, Long> {

}
