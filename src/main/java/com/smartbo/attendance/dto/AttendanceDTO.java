package com.smartbo.attendance.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.smartbo.attendance.domain.AbsentYn;
import com.smartbo.member.domain.Member;

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
public class AttendanceDTO {

	private Long attendanceId;
	private String memberName;
	private LocalDate date;
	private LocalTime checkInTime;
	private LocalTime checkOutTime;
	private int overtimeHours;
	private int lateTime;
	private AbsentYn absentYn;
	private String absentReason;
	
}
