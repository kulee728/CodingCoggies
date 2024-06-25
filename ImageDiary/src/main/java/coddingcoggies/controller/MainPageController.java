package coddingcoggies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import coddingcoggies.dto.SpecialDate;
import coddingcoggies.service.MainPageService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainPageController {

	@Autowired
	private MainPageService mainPageService;
	
	
	
	@GetMapping("/TeachersGift")
	public String getAllSpecialDate(Model model) {
		
		List<SpecialDate> specialDateList = mainPageService.getAllSpecialDate();
		log.info(specialDateList.toString());
		model.addAttribute("specialDateList",specialDateList);
		return "TeachersGift";
	}
	
	/*
	 기념일 영역
	 */
	/*
	public void getAllSpecialDate(Model model) {
		
		List<SpecialDate> specialDateList = mainPageService.getAllSpecialDate();
		model.addAttribute("specialDateList",specialDateList);
		log.info(specialDateList.toString());
		
	}
	*/
}
