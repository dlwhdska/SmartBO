package com.smartbo.payroll.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaryDTO {

	private Long salaryId;
	private String memberName;
	private BigDecimal baseSalary;
	private BigDecimal bonus;
	private BigDecimal tax;
	private BigDecimal deductions;
	private BigDecimal totalSalary;
	private LocalDate paymentDate;
	
}
