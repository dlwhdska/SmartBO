package com.smartbo.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartbo.member.dto.MemberDTO;
import com.smartbo.member.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;

	@GetMapping("/login")
	public void getLogin() {
		
	}
	
	@PostMapping("/login")
	public String postLogin(@RequestParam("email") String email,@RequestParam("pwd") String pwd, HttpSession session, Model model) {
		
		try {
			MemberDTO memberDTO = memberService.login(email, pwd);
			session.setAttribute("loginMember", memberDTO);
			return "redirect:/";
		} catch (Exception e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "/member/login";
		}
	}
}
