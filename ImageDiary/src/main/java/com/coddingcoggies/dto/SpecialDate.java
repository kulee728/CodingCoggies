package com.coddingcoggies.dto;

import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SpecialDate {
	private int specialDate_id;
	private int specialDate_type; // type (1:디데이, 2:지정기념일)
	private String specialDate_color; //색에 대한 value 저장.
	private String specialDate_name;
	private int member_no;
}
