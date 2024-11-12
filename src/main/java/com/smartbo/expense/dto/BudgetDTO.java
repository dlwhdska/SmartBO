package com.smartbo.expense.dto;

import java.math.BigDecimal;

import com.smartbo.expense.domain.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDTO {

	private Long budgetId;
	private Category category;
	private BigDecimal allocatedAmount;
	private BigDecimal usedAmount;
	private BigDecimal remainingAmount;
	
}
