package com.smartbo.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartbo.expense.domain.Budget;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

}
