package coddingcoggies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import coddingcoggies.dto.SpecialDate;
import coddingcoggies.service.SpecialDateService;

@Controller
public class SpecialDateController {
	
	@Autowired
	private SpecialDateService specialDateService;
	
	@GetMapping("/specialDate")
	public String specialDate() {
		return "specialDate";
	}
	
	@PostMapping("/specialDate")
	public String specialDateSave(Model model, String specialDate_date,
			int specialDate_type,
			String specialDate_color,
			String specialDate_name,
			int member_no
			) {
		
		SpecialDate specialDate = new SpecialDate();
		specialDate.setSpecialDate_date(specialDate_date);
		specialDate.setSpecialDate_type(specialDate_type);
		specialDate.setSpecialDate_color(specialDate_color);
		specialDate.setSpecialDate_name(specialDate_name);
		specialDate.setMember_no(member_no);
		
		specialDateService.insertSpecialDate(specialDate);
		return "redirect:/diaryMain";
	}
	
}

