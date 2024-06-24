package coddingcoggies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ch.qos.logback.core.model.Model;
import coddingcoggies.dto.Diary;
import coddingcoggies.service.DiaryService;

@Controller
public class DiaryController {
	@Autowired
	private DiaryService diaryService;
	
	@PostMapping("/register-diary")
	public String insertDiary(Diary diary, Model model) {
		diaryService.insertDiary(diary);
		return "diaryView";
	}
	
	@GetMapping("/diaryView")
	public String getAllDiary(Model model) {
	    List<Diary> diaryView = diaryService.getAllDiary();
	    //model.addAttribute("diaryView", diaryView); // List<Diary>를 추가
	    return "diaryView";
	}

}
