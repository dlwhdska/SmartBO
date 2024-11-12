package com.smartbo.member.service;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.smartbo.member.domain.Member;
import com.smartbo.member.domain.Position;
import com.smartbo.member.domain.Role;
import com.smartbo.member.domain.Status;
import com.smartbo.member.dto.MemberDTO;
import com.smartbo.member.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	public MemberDTO login(String email, String pwd) {
		
		Member member = memberRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("가입되지않은 이메일입니다."));
		
		if (!pwd.equals(member.getPwd())) {
			throw new IllegalArgumentException("잘못된 비밀번호입니다.");
		}
		
		if (Role.EMPLOYEE.equals(member.getRole())) {
			
			return MemberDTO.builder()
					.memberId(member.getMemberId())
					.email(member.getEmail())
					.pwd(member.getPwd())
					.name(member.getName())
					.contact(member.getContact())
					.position(member.getPosition())
					.department(member.getDepartment())
					.status(member.getStatus())
					.role(Role.EMPLOYEE)
					.joinDate(member.getJoinDate())
					.leaveDate(member.getLeaveDate())
					.build();
				
		} else {
			
			return MemberDTO.builder()
					.memberId(member.getMemberId())
					.email(member.getEmail())
					.pwd(member.getPwd())
					.name(member.getName())
					.contact(member.getContact())
					.position(member.getPosition())
					.department(member.getDepartment())
					.status(member.getStatus())
					.role(Role.ADMIN)
					.joinDate(member.getJoinDate())
					.leaveDate(member.getLeaveDate())
					.build();
		}
		
	}
	
	public Page<MemberDTO> getMemberList(Pageable pageable) {
		
        Page<Member> memberPage = memberRepository.findByRole(Role.EMPLOYEE, pageable);
        
        return memberPage.map(member -> MemberDTO.builder()
                .memberId(member.getMemberId())
                .email(member.getEmail())
                .name(member.getName())
                .contact(member.getContact())
                .position(member.getPosition())
                .department(member.getDepartment())
                .status(member.getStatus())
                .role(member.getRole())
                .joinDate(member.getJoinDate())
                .leaveDate(member.getLeaveDate())
                .build());
    }
}
