package com.smartbo.payroll.dto;

import java.time.LocalDateTime;

import com.smartbo.payroll.domain.Salary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaryStatementDTO {

	private Long statementId;
	private Salary salary;
	private String statementPeriod;
	private LocalDateTime createdAt;
	
}
