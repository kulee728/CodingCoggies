package coddingcoggies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coddingcoggies.dto.SpecialDate;
import coddingcoggies.mapper.MainPageMapper;

@Service
public class MainPageService {

	@Autowired
	private MainPageMapper mainPageMapper;
	
	public List<SpecialDate> getAllSpecialDate(){
		return mainPageMapper.getAllSpecialDate();
	}
	
}
