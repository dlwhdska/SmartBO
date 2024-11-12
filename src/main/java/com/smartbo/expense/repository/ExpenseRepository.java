package com.smartbo.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartbo.expense.domain.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
