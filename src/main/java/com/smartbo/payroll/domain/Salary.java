package com.smartbo.payroll.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.smartbo.member.domain.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Salary {

	// 급여 고유 ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "salary_id")
	private Long salaryId;
	
	// 직원 고유 ID
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;
	
	// 기본급 (precision : 전체 자리수 , scale : 소수점 이하 자리수)
	@Column(name = "base_salary", nullable = false, precision = 10, scale = 2)
	private BigDecimal baseSalary;
	
	// 보너스
	@Column(precision = 10, scale = 2)
	private BigDecimal bonus;
	
	// 세금
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal tax;
	
	// 공제액
	@Column(precision = 10, scale = 2)
	private BigDecimal deductions;
	
	// 총 급여
	@Column(name = "total_salary", nullable = false, precision = 10, scale = 2)
	private BigDecimal totalSalary;
	
	// 지급일
	@Column(name = "payment_date", nullable = false)
	private LocalDate paymentDate;
	
}
