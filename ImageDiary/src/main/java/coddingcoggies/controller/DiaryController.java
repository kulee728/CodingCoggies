package coddingcoggies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import coddingcoggies.dto.Diary;
import coddingcoggies.service.DiaryService;

@Controller
@RequestMapping("/diary")
public class DiaryController {
	@Autowired
	private DiaryService diaryService;
	
	@PostMapping("/diaryWrite") //diary/diaryWrite
	public String insertDiary(Diary diary, Model model) {
		diaryService.insertDiary(diary);
		model.addAttribute("msg", "오늘의 일기가 등록되었습니다.");
		return "diaryView";
	}
	

	@GetMapping("/diaryView/{diary_id}") //0626 오후 5시 신우님 여기부터!
	public String getAllDiary(Model model) {
	    List<Diary> diaryView = diaryService.getAllDiary();
	    //model.addAttribute("diaryView", diaryView); // List<Diary>를 추가
	    return "diaryView";
	}

}
