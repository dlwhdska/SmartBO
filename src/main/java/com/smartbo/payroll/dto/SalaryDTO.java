package com.smartbo.payroll.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.smartbo.member.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaryDTO {

	private Long salaryId;
	private Member member;
	private BigDecimal baseSalary;
	private BigDecimal bonus;
	private BigDecimal tax;
	private BigDecimal deductions;
	private BigDecimal totalSalary;
	private LocalDate paymentDate;
	
}
