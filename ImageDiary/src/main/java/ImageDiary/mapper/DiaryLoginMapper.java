package ImageDiary.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ImageDiary.dto.DiaryLogin;

@Mapper
public interface DiaryLoginMapper {
	DiaryLogin getLogin(@Param("member_id") String member_id,
						  @Param("member_pw") String member_pw);
}