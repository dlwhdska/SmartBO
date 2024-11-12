package com.smartbo.attendance.dto;

import java.time.LocalDate;

import com.smartbo.attendance.domain.LeaveType;
import com.smartbo.attendance.domain.Status;
import com.smartbo.member.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeaveRequestDTO {

	private Long leaveRequestId;
	private Member member;
	private Status status;
	private LeaveType leaveType;
	private LocalDate startDate;
	private LocalDate endDate;
	private String reason;
	
}
