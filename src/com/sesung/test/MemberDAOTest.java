package com.sesung.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;

import com.sesung.member.MemberDAO;
import com.sesung.member.MemberDTO;

public class MemberDAOTest {

	@Test
	public void insertTest() throws Exception {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();
//		MemberDTO dto = new MemberDTO();
//		dto.setName("iu");
//		dto.setId("ap2");
//		dto.setPw("uu");
//		dto.setAge(23);
//		dto.setBirth2("2010-11-24");
//		int result =dao.memberInsert(dto);
//		assertEquals(1, result);
		ar = dao.searchMember("a");
		assertNotNull(ar);
	}

}
