package ImageDiary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ImageDiary.dto.DiaryLogin;
import ImageDiary.mapper.DiaryLoginMapper;

@Service
public class DiaryLoginService {
	@Autowired
	private DiaryLoginMapper diaryLoginMapper;
	
	public DiaryLogin getLogin(String member_id, String member_pw) {
		return diaryLoginMapper.getLogin(member_id, member_pw);
	}
}
