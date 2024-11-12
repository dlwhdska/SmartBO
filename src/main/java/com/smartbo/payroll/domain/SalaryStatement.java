package com.smartbo.payroll.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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
public class SalaryStatement {

	// 급여 기록 고유 ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "statement_id")
	private Long statementId;
	
	// 급여 고유 ID
	@ManyToOne
	@JoinColumn(name = "salary_id")
	private Salary salary;
	
	// 급여 주기
	@Column(name = "statement_period", nullable = false, length = 50)
	private String statementPeriod;
	
	// 명세서 생성일
	@Column(name = "created_at", nullable = false)
	@CreationTimestamp // 기본값이 CURRENT_TIMESTAMP로 설정됨
	private LocalDateTime createdAt;
	
}
