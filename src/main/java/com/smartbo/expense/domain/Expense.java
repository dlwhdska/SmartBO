package com.smartbo.expense.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.smartbo.member.domain.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

	// 지출 고유 ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "expense_id")
	private Long expenseId;
	
	// 직원 고유 ID
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;
	
	// 비용 분류 (TRAVEL : 출장비, MEAL : 식비, SUPPLIES : 소모품비)
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, columnDefinition = "ENUM('TRAVEL', 'MEAL', 'SUPPLIES')")
	private Category category;
	
	// 금액
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal amount;
	
	// 상세 내역
	@Column(nullable = false, columnDefinition = "TEXT")
	private String description;
	
	// 지출 일자
	@Column(nullable = false)
	private LocalDate date;
	
}
