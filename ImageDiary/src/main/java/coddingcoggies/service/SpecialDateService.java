package coddingcoggies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coddingcoggies.dto.SpecialDate;
import coddingcoggies.mapper.SpecialDateMapper;

@Service
public class SpecialDateService {
	@Autowired
	private SpecialDateMapper specialDateMapper;

	public void insertSpecialDate(SpecialDate specialDate) {
		
		specialDateMapper.insertSpecialDate(specialDate);
	}

}
