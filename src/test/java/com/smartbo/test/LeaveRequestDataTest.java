package com.smartbo.test;

import java.time.LocalDate;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.smartbo.attendance.domain.LeaveRequest;
import com.smartbo.attendance.domain.LeaveType;
import com.smartbo.attendance.domain.Status;
import com.smartbo.attendance.repository.LeaveRequestRepository;
import com.smartbo.member.domain.Member;
import com.smartbo.member.repository.MemberRepository;

@SpringBootTest
public class LeaveRequestDataTest {

	@Autowired
    private LeaveRequestRepository leaveRequestRepository;
    
	@Autowired
    private MemberRepository memberRepository;
    
//    @Test
    public void generateTestData() {
        Random random = new Random();
        LocalDate baseDate = LocalDate.now();
        
        LeaveType[] leaveTypes = LeaveType.values();
        Status[] statuses = Status.values();
        
        String[] reasons = {
            "개인 휴식",
            "가족 행사",
            "병원 진료",
            "건강 검진",
            "자기 계발",
            "이사",
            "결혼식 참석",
            "여행",
            "육아",
            "학업"
        };
        
        for (int i = 0; i < 100; i++) {
            LeaveRequest leaveRequest = new LeaveRequest();
            
            Long memberId = (long) (random.nextInt(302) + 1);
            Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));
            leaveRequest.setMember(member);
            
            leaveRequest.setLeaveType(leaveTypes[random.nextInt(leaveTypes.length)]);
            
            leaveRequest.setStatus(statuses[random.nextInt(statuses.length)]);
            
            int startDayOffset = random.nextInt(210) - 30;
            LocalDate startDate = baseDate.plusDays(startDayOffset);
            
            int leaveDuration = random.nextInt(7) + 1;
            LocalDate endDate = startDate.plusDays(leaveDuration - 1);
            
            leaveRequest.setStartDate(startDate);
            leaveRequest.setEndDate(endDate);
            
            leaveRequest.setReason(reasons[random.nextInt(reasons.length)]);
            
            leaveRequestRepository.save(leaveRequest);
        }
    }
}