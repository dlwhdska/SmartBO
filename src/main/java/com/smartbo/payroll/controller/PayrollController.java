package com.smartbo.payroll.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.smartbo.payroll.dto.SalaryDTO;
import com.smartbo.payroll.service.SalaryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PayrollController {

	private final SalaryService salaryService;
	
	@GetMapping("/admin/salaryList")
	public String getSalaryList(@PageableDefault(size = 10, sort = "member.name", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
		
		Page<SalaryDTO> salarys = salaryService.getSalaryList(pageable);
		model.addAttribute("salarys", salarys);
		
		return "admin/salaryList";
	}
}
