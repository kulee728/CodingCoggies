package ImageDiary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ImageDiary.dto.SpecialDate;
import ImageDiary.mapper.MainPageMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MainPageService {

	@Autowired
	private MainPageMapper mainPageMapper;
	
	public List<SpecialDate> getAllSpecialDate(){
		log.info("serivce string : "+ mainPageMapper.getAllSpecialDate().toString());
		return mainPageMapper.getAllSpecialDate();
	}
	
}
