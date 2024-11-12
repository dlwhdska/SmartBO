package com.smartbo.member.service;

import org.springframework.stereotype.Service;

import com.smartbo.member.domain.Member;
import com.smartbo.member.dto.MemberDTO;
import com.smartbo.member.repository.MemberRepository;

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
		
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.builder()
			.memberId(member.getMemberId())
			.email(member.getEmail())
			.pwd(member.getPwd())
			.name(member.getName())
			.contact(member.getContact())
			.position(member.getPosition())
			.department(member.getDepartment())
			.status(member.getStatus())
			.role(member.getRole())
			.joinDate(member.getJoinDate())
			.leaveDate(member.getLeaveDate())
			.build();
		
		return memberDTO;
		
	}
}
