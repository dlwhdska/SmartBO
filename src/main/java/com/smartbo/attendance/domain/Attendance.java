package com.smartbo.attendance.domain;

import java.time.LocalDate;
import java.time.LocalTime;

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
public class Attendance {

	// 출결 고유 ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attendance_id")
	private Long attendanceId;

	// 직원 고유 ID
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;
	
	// 출근 날짜
	private LocalDate date;
	
	// 출근 시간
	@Column(name = "check_in_time")
	private LocalTime checkInTime;
	
	// 퇴근 시간
	@Column(name = "check_out_time")
	private LocalTime checkOutTime;
	
	// 연장 근무 시간
	@Column(name = "overtime_hours")
	private int overtimeHours;
	
	// 지각 시간
	@Column(name = "late_time")
	private int lateTime;
	
	// 결근 여부 (Y : 결근, N : 출근)
	@Enumerated(EnumType.STRING)
	@Column(name = "absent_yn", nullable = false, columnDefinition = "ENUM('Y', 'N') DEFAULT 'N'")
	private AbsentYn absentYn;
	
	// 결근 사유
	@Column(name = "absent_reason", length = 100)
	private String absentReason;
	
}
