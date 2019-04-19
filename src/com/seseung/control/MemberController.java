package com.seseung.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.sesung.input.MemberInput;
import com.sesung.member.MemberDAO;
import com.sesung.member.MemberDTO;
import com.sesung.view.MemberView;

public class MemberController {

	public void start() throws Exception {
		Scanner sc = new Scanner(System.in);
		MemberDAO dao = new MemberDAO();
		MemberInput mi = new MemberInput();
		MemberView mv = new MemberView();
		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();
		MemberDTO dto = new MemberDTO();
		boolean check = true;
		while(check) {
			System.out.println("1.회원가입");
			System.out.println("2.회원탈퇴");
			System.out.println("3.ID 검색");
			System.out.println("4.전체조회");
			System.out.println("5.종     료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
			    dto = mi.memberInput();
			    ar.add(dto);
			    int result = dao.memberInsert(dto);
			    String str = "추가실패";
			    if(result>0) {
			    	mv.view("추가성공");
			    }else {
			    	mv.view(str);
			    }
				break;
			case 2:
				String aa = mi.inputId("삭제");
				result = dao.memberDelete(aa);
				str = "없는 아이디";
				if(result>0) {
					mv.view("삭제 성공");
				}else {
					mv.view(str);
				}

				break;
			case 3:
				aa = mi.inputId("조회");
				dto = dao.memberOneSelect(aa);
				str = "없는 아이디";
				if(dto!=null) {
					mv.view(dto);
				}else {
					mv.view(str);
				}
				break;
			case 4: 
				ar = dao.memberListSelect();
				mv.view(ar);

				break;
			case 5:
				System.out.println("프로그램 종료");
				check=!check;
				break;
			default:
				System.out.println("번호를 확인해주세요.");
				break;
			}
		}


	}

}
