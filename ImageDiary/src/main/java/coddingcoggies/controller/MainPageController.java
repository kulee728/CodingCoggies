package coddingcoggies.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static java.time.temporal.ChronoUnit.DAYS;

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
	public String showMainContents(Model model) {
		
		//List<SpecialDate> specialDateList = mainPageService.getAllSpecialDate();
		//log.info(specialDateList.toString());
		//model.addAttribute("specialDateList",specialDateList);
		getAllSpecialDate(model);
		return "TeachersGift";
	}
	
	/*
	 기념일 영역
	 */
	
	public void getAllSpecialDate(Model model) {
		List<SpecialDate> specialDateList = mainPageService.getAllSpecialDate();
		
		for(SpecialDate sd : specialDateList) {
			if(sd.getSpecialDate_type()==1){{
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
				LocalDate dDay_date = LocalDate.parse(sd.getSpecialDate_date(), formatter);
				LocalDate today_date = LocalDate.now();
				sd.setDateDisplayText("D"+DAYS.between(dDay_date, today_date));
			}
				
			}
			else if(sd.getSpecialDate_type()==2) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
				sd.setDateDisplayText(LocalDate.parse(sd.getSpecialDate_date(), formatter).toString());
			}
		}
		
		model.addAttribute("specialDateList",specialDateList);
		
	}
	
}
