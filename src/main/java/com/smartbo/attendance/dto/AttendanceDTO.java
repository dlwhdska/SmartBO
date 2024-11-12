package com.smartbo.attendance.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.smartbo.attendance.domain.AbsentYn;
import com.smartbo.member.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDTO {

	private Long attendanceId;
	private Member member;
	private LocalDate date;
	private LocalTime checkInTime;
	private LocalTime checkOutTime;
	private int overtimeHours;
	private int lateTime;
	private AbsentYn absentYn;
	private String absentReason;
	
}
