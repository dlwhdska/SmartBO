package com.smartbo.member.dto;

import java.time.LocalDate;

import com.smartbo.member.domain.Position;
import com.smartbo.member.domain.Role;
import com.smartbo.member.domain.Status;

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
public class MemberDTO {
	
	private Long memberId;
	private String email;
	private String pwd;
	private String name;
	private String contact;
	private Position position;
	private String department;
	private Status status;
	private Role role;
	private LocalDate joinDate;
	private LocalDate leaveDate;
	
}
