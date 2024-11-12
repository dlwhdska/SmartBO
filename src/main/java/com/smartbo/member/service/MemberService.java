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
	
	@Transactional
    public void insertTestMembers() {
        for (int i = 3; i <= 302; i++) {
            Member member = new Member();
            member.setMemberId((long) i);
            member.setEmail("member" + i + "@example.com");
            member.setPwd("password" + i);
            member.setName("이름" + i);
            member.setContact("010-0000-00" + i);
            member.setPosition(Position.values()[i % Position.values().length]); // 4개의 직책 순환
            member.setDepartment("부서" + (i % 5 + 1)); // 5개의 부서 순환
            member.setStatus(i % 3 == 0 ? Status.RETIRED : Status.ACTIVE); // ACTIVE, RETIRED 상태 순환
            member.setRole(i % 5 == 0 ? Role.ADMIN : Role.EMPLOYEE); // 5명마다 ADMIN, 나머지는 EMPLOYEE
            member.setJoinDate(LocalDate.now());
            member.setLeaveDate(i % 10 == 0 ? LocalDate.now().plusDays(365) : null); // 퇴사일을 10명마다 설정

            memberRepository.save(member); // 데이터 저장
        }
    }
	
}
