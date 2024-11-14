package com.smartbo.attendance.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.smartbo.attendance.dto.AttendanceDTO;
import com.smartbo.attendance.dto.LeaveRequestDTO;
import com.smartbo.attendance.service.AttendanceService;
import com.smartbo.attendance.service.LeaveRequestService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AttendanceController {
	
	private final AttendanceService attendanceService;
	private final LeaveRequestService leaveRequestService;
	
	@GetMapping("/admin/attendanceList")
	public String getAttendanceList(@PageableDefault(size = 10, sort = "attendanceId", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
		
		Page<AttendanceDTO> attendances = attendanceService.getAttendanceList(pageable);
		model.addAttribute("attendances", attendances);
		
		return "admin/attendanceList";
	}
	
	@GetMapping("/admin/leaveRequestList")
	public String getLeaveRequestList(@PageableDefault(size = 10, sort = "leaveRequestId", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
		
		Page<LeaveRequestDTO> leaveRequests = leaveRequestService.getLeaveRequestList(pageable);
		model.addAttribute("leaveRequests", leaveRequests);
		
		return "admin/leaveRequestList";
	}
}
