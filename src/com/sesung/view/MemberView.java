package com.sesung.view;

import java.util.ArrayList;

import com.sesung.member.MemberDTO;

public class MemberView {
	
	public void view(String str) {
		System.out.println(str);
	}
	
	public void view(MemberDTO dto) {
		System.out.println("ID : " + dto.getId());
		System.out.println("PW : " + dto.getPw());
		System.out.println("NAME : " + dto.getName());
		System.out.println("AGE : "+ dto.getAge());
		System.out.println("BIRTHDAY : "+ dto.getBirth());
		System.out.println("=============");
	}
	
	public void view(ArrayList<MemberDTO> ar) {
		for(MemberDTO dto : ar) {
			this.view(dto);
		}
	}

}
