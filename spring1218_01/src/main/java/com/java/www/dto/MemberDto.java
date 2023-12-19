package com.java.www.dto;


import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String gender;
	private String hobbuy;
	private Timestamp mdate;

}
