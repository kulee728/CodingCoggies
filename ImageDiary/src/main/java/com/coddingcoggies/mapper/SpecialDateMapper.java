package com.coddingcoggies.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.coddingcoggies.dto.SpecialDate;
@Mapper
public interface SpecialDateMapper {

	List<SpecialDate> getAllSpecialDate();
}
