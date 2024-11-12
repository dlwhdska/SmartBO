package com.smartbo.member.domain;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	
	// 직원 고유 ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long memberId;
	
	// 직원 이메일, 로그인 ID
	@Column(nullable = false, length = 100)
	private String email;
	
	// 직원 로그인 PWD
	@Column(nullable = false, length = 255)
	private String pwd;
	
	// 직원 이름
	@Column(nullable = false, length = 50)
	private String name;
	
	// 연락처
	@Column(nullable = false, length = 15)
	private String contact;
	
	// 직책 (JUNIOR_DEVELOPER : 주니어 개발자, SENIOR_DEVELOPER : 시니어 개발자, PROJECT_MANAGER : 프로젝트 매니저, TEAM_LEADER : 팀장)
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, columnDefinition = "ENUM('JUNIOR_DEVELOPER', 'SENIOR_DEVELOPER', 'PROJECT_MANAGER', 'TEAM_LEADER')")
	private Position position;
	
	// 부서
	@Column(nullable = false, length = 50)
	private String department;
	
	// 근무 상태 (ACTIVE : 재직, RETIRED : 퇴직, ON_LEAVE : 휴직)
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, columnDefinition = "ENUM('ACTIVE', 'RETIRED', 'ON_LEAVE') DEFAULT 'ACTIVE'")
	private Status status;
	
	// 권한 및 역할 (EMPLOYEE : 직원, ADMIN : 관리자)
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, columnDefinition = "ENUM('EMPLOYEE', 'ADMIN') DEFAULT 'EMPLOYEE'")
	private Role role;
	
	// 입사일
	@Column(name = "join_date", nullable = false)
	@CreationTimestamp // 기본값이 CURRENT_TIMESTAMP로 설정됨
	private LocalDate joinDate;
	
	// 퇴사일
	@Column(name = "leave_date")
	private LocalDate leaveDate;
	
}
