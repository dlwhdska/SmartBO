package com.smartbo.attendance.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.smartbo.attendance.domain.LeaveRequest;
import com.smartbo.attendance.dto.LeaveRequestDTO;
import com.smartbo.attendance.repository.LeaveRequestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LeaveRequestService {

	private final LeaveRequestRepository leaveRequestRepository;
	
	public Page<LeaveRequestDTO> getLeaveRequestList(Pageable pageable) {
		
		Page<LeaveRequest> leaveRequestPage = leaveRequestRepository.findAll(pageable);
		
		return leaveRequestPage.map(leaveRequest -> LeaveRequestDTO.builder()
				.leaveRequestId(leaveRequest.getLeaveRequestId())
				.memberName(leaveRequest.getMember().getName())
				.status(leaveRequest.getStatus())
				.leaveType(leaveRequest.getLeaveType())
				.startDate(leaveRequest.getStartDate())
				.endDate(leaveRequest.getEndDate())
				.reason(leaveRequest.getReason())
				.build());
				
	}
}
