package com.smartbo.attendance.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.smartbo.attendance.domain.Attendance;
import com.smartbo.attendance.dto.AttendanceDTO;
import com.smartbo.attendance.repository.AttendanceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttendanceService {
	
	private final AttendanceRepository attendanceRepository;
	
	public Page<AttendanceDTO> getAttendanceList(Pageable pageable) {
		
		Page<Attendance> attendancePage = attendanceRepository.findAll(pageable);
		
		return attendancePage.map(attendance -> AttendanceDTO.builder()
				.attendanceId(attendance.getAttendanceId())
				.memberName(attendance.getMember().getName())
				.date(attendance.getDate())
				.checkInTime(attendance.getCheckInTime())
				.checkOutTime(attendance.getCheckOutTime())
				.overtimeHours(attendance.getOvertimeHours())
				.absentYn(attendance.getAbsentYn())
				.absentReason(attendance.getAbsentReason())
				.build());
	}

}
