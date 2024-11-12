package com.smartbo.attendance.domain;

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
public class LeaveRequest {

	// 휴가신청 고유 ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "leave_request_id")
	private Long leaveRequestId;
	
	// 직원 고유 ID
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;
	
	// 신청 상태 (PENDING : 신청중, APPROVED : 승인, REJECTED : 반려)
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, columnDefinition = "ENUM('PENDING', 'APPROVED', 'REJECTED') DEFAULT 'PENDING'")
	private Status status;
	
	// 휴가 종류 (ANNUAL : 연차, SICK : 병가, OTHER : 기타 휴가)
	@Enumerated(EnumType.STRING)
	@Column(name = "leave_type", nullable = false, columnDefinition = "ENUM('ANNUAL', 'SICK', 'OTHER')")
	private LeaveType leaveType;
	
	// 휴가 시작일
	@Column(name = "start_date", nullable = false)
	private LocalDate startDate;
	
	// 휴가 종료일
	@Column(name = "end_date", nullable = false)
	private LocalDate endDate;
	
	// 휴가 이유
	@Column(nullable = false, length = 100)
	private String reason;
	
}
