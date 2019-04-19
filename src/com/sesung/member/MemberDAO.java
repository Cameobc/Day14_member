package com.sesung.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sesung.util.DBConnector;

public class MemberDAO {
	
	public ArrayList<MemberDTO> searchMember(String id) throws Exception {
		Connection con = DBConnector.connection();
		String sql ="SELECT * FROM MEMBER WHERE ID LIKE ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+id+"%");
		ResultSet rs = st.executeQuery();
		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getString("ID"));
			dto.setPw(rs.getString("PW"));
			dto.setName(rs.getString("NAME"));
			dto.setAge(rs.getInt("AGE"));
			dto.setBirth(rs.getDate("BIRTH"));
			ar.add(dto);
		}
		DBConnector.disconnction(con, st, rs);
		return ar;
	}
	
	public int memberInsert(MemberDTO dto) throws Exception {
		Connection con = DBConnector.connection();
		String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, dto.getId());
		st.setString(2, dto.getPw());
		st.setString(3, dto.getName());
		st.setInt(4, dto.getAge());
		st.setString(5, dto.getBirth2());
		int result = st.executeUpdate();
		DBConnector.disconnection(con, st);
		return result;
	}
	
	public int memberDelete(String id) throws Exception {
		Connection con = DBConnector.connection();
		String sql = "DELETE MEMBER WHERE ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		int result = st.executeUpdate();
		DBConnector.disconnection(con, st);
		return result;
		
	}
	
	public MemberDTO memberOneSelect(String aa) throws Exception {
		Connection con = DBConnector.connection();
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, aa);
		ResultSet rs = st.executeQuery();
		MemberDTO dto =null;
		if(rs.next()) {
			dto = new MemberDTO();
			dto.setId(rs.getString("ID"));
			dto.setPw(rs.getString("PW"));
			dto.setName(rs.getString("NAME"));
			dto.setAge(rs.getInt("AGE"));
			dto.setBirth(rs.getDate("BIRTH"));
		}
		DBConnector.disconnction(con, st, rs);
		return dto;
	}
	
	public ArrayList<MemberDTO> memberListSelect() throws Exception {
		Connection con = DBConnector.connection();
		String sql = "SELECT * FROM MEMBER";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getString("ID"));
			dto.setPw(rs.getString("PW"));
			dto.setName(rs.getString("NAME"));
			dto.setAge(rs.getInt("AGE"));
			dto.setBirth(rs.getDate("BIRTH"));
			ar.add(dto);
		}
		DBConnector.disconnction(con, st, rs);
		return ar;
	}

}
