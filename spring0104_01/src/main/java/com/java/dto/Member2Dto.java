package com.java.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member2Dto {
	
	private String id;
	private String pw;
	private String name;
	private String email;
	private String phone;
	private String gender;
	private String hobby;
	private Timestamp mdate;

}
