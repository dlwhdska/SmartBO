package com.smartbo.payroll.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.smartbo.payroll.domain.Salary;
import com.smartbo.payroll.dto.SalaryDTO;
import com.smartbo.payroll.repository.SalaryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalaryService {

	private final SalaryRepository salaryRepository;
	
	public Page<SalaryDTO> getSalaryList(Pageable pageable) {
		
		Page<Salary> salaryPage = salaryRepository.findAll(pageable);
		
		return salaryPage.map(salary -> SalaryDTO.builder()
				.salaryId(salary.getSalaryId())
				.memberName(salary.getMember().getName())
				.baseSalary(salary.getBaseSalary())
				.bonus(salary.getBonus())
				.tax(salary.getTax())
				.deductions(salary.getDeductions())
				.totalSalary(salary.getTotalSalary())
				.paymentDate(salary.getPaymentDate())
				.build());
	}
}
