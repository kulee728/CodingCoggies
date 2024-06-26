package coddingcoggies.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import coddingcoggies.dto.Diary;


@Controller
public class IndexController {


	

	
	@GetMapping("/diaryView")
	public String toDiaryView() {
		return "diaryView";
	}
	@GetMapping("/diaryWrite")
	public String toDiaryWrite(Model model) {
		model.addAttribute("diary", new Diary()); //get = 가져오다. 다이어리 객체에 작성된 빈 공간을
		return "diaryWrite";
	}
	
	@GetMapping("/signUp")
	public String toSignUp() {
		return "signUp";
	}
	
	@GetMapping("/testLink")
	public String toTestLink() {
		return "testLink";
	}

	@GetMapping("/specialDate")
	public String specialDate() {
		return "specialDate";
	}

}

