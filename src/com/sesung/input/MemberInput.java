package com.sesung.input;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.sesung.member.MemberDTO;

public class MemberInput {
	
	public MemberDTO memberInput() {
		Scanner sc = new Scanner(System.in);
		MemberDTO dto = new MemberDTO();
		System.out.println("ID");
		dto.setId(sc.next());
		System.out.println("PW");
		dto.setPw(sc.next());
		System.out.println("NAME");
		dto.setName(sc.next());
		System.out.println("AGE");
		dto.setAge(sc.nextInt());
		System.out.println("BIRTHDAY");
		String day = sc.next();
		Date date = Date.valueOf(day);
		dto.setBirth(date);
		return dto;
	}
	
	public String inputId(String str) {
		Scanner sc = new Scanner(System.in);
		System.out.println(str+"아이디 입력");
		String aa = sc.next();
		return aa;
	}

}
