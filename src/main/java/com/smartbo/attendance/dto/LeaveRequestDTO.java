package com.smartbo.attendance.dto;

import java.time.LocalDate;

import com.smartbo.attendance.domain.LeaveType;
import com.smartbo.attendance.domain.Status;

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
public class LeaveRequestDTO {

	private Long leaveRequestId;
	private String memberName;
	private Status status;
	private LeaveType leaveType;
	private LocalDate startDate;
	private LocalDate endDate;
	private String reason;
	
}
