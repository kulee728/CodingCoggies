package coddingcoggies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import coddingcoggies.dto.Member;
import coddingcoggies.service.MemberService;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/signUp")
	public String registerForm(Model model) {
		model.addAttribute("newMem", new Member());
		return "signUp";
	}
	
	@PostMapping("/register")
	public String signUpComplete(Member member, Model model) {
		memberService.insertMember(member);
		model.addAttribute("msg", "회원가입 완료!");
		return "redirect:/";
	}
	
}
