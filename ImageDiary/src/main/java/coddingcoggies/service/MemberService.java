package coddingcoggies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coddingcoggies.dto.Member;
import coddingcoggies.mapper.MemberMapper;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	public void insertMember(Member member) {
		memberMapper.insertMember(member);
	}
	
	
}
