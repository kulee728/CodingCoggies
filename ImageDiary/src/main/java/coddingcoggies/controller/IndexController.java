package coddingcoggies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/diaryMain")
	public String toDiaryMain() {
		return "diaryMain";
	}
	
	
	@GetMapping("/diaryView")
	public String toDiaryView() {
		return "diaryView";
	}
	@GetMapping("/diaryWrite")
	public String toDiaryWrite() {
		return "diaryWrite";
	}
	
	@GetMapping("/signUp")
	public String toSignUp() {
		return "signUp";
	}

	@GetMapping("/TeachersGift")
	public String TeachersGift() {
		return "TeachersGift";
	}
	
	@GetMapping("/specialDate")
	public String specialDate() {
		return "specialDate";
	}

}
