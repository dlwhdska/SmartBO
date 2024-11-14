package com.smartbo.member.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartbo.member.domain.Role;
import com.smartbo.member.dto.MemberDTO;
import com.smartbo.member.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;

	@GetMapping("/member/login")
	public void getLogin() {
		
	}
	
	@PostMapping("/member/login")
	public String postLogin(@RequestParam("email") String email, @RequestParam("pwd") String pwd, HttpSession session, Model model) {
		
		try {
			MemberDTO memberDTO = memberService.login(email, pwd);
			session.setAttribute("loginMember", memberDTO);
			if (Role.EMPLOYEE.equals(memberDTO.getRole())) {
				return "redirect:/";
			} else {
				return "redirect:/admin";
			}
		} catch (Exception e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "/member/login";
		}
	}
	
	@GetMapping("/admin/memberList")
    public String getMemberList(@PageableDefault(size = 10, sort = "memberId", direction = Sort.Direction.DESC) Pageable pageable, Model model) {

		Page<MemberDTO> members = memberService.getMemberList(pageable);
        model.addAttribute("members", members);
        
        return "admin/memberList";
    }
}
