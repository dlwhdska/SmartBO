package com.smartbo.expense.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Budget {

	// 예산 고유 ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "budget_id")
	private Long budgetId;
	
	// 예산 카테고리비용 분류 (TRAVEL : 출장비, MEAL : 식비, SUPPLIES : 소모품비)
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, columnDefinition = "ENUM('TRAVEL', 'MEAL', 'SUPPLIES')")
	private Category category;
	
	// 할당 금액
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal allocatedAmount;
	
	// 사용 금액
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal usedAmount;
	
	// 남은 금액
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal remainingAmount;
	
}
