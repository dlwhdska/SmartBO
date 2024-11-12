package com.smartbo.expense.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.smartbo.expense.domain.Category;
import com.smartbo.member.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDTO {

	private Long expenseId;
	private Member member;
	private Category category;
	private BigDecimal amount;
	private String description;
	private LocalDate date;
	
}
