package co.edu.member;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO extends co.edu.DAO {

	// 전체조회.() 따로 파라메타 없음.
	public List<MemberVO> memberList() { // 객체 생성자 인스턴스
		getConnect();
		List<MemberVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement("select * from member order by memb_no");
			rs = psmt.executeQuery(); // 조회: excuteQuery, 추가,수정,삭제: excuteUpdate
			while (rs.next()) {
				MemberVO mem = new MemberVO();
				mem.setMembNo(rs.getInt("memb_no"));
				mem.setMembName(rs.getString("memb_name")); // memb_name: 칼럼이름
				mem.setMembPhone(rs.getString("memb_phone"));
				mem.setMembAddr(rs.getString("memb_addr"));
				mem.setMemBirth(rs.getString("memb_birth"));
				mem.setMembImage(rs.getString("memb_image"));

				list.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 입력.(MemberVO)
	public MemberVO insertMember(MemberVO vo) {
		getConnect();
		String sql = "insert into member" //
				+ "(memb_no, memb_name, memb_phone, memb_addr, memb_birth, memb_image)" //
				+ "values(?,?,?,?,?,?)";
		String seqSql = "select memb_seq.nextval from dual"; // 이번에 만들어진 시퀀스 알려주기 위해서
		try {
			// 시퀀스.
			int nextSeq = 0;
			psmt = conn.prepareStatement(seqSql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				nextSeq = rs.getInt(1); // 첫번째 가져온 칼럼을 int 타입으로 가져옴. :회원번호.
			}

			// 입력하기위한 처리.
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, nextSeq);
			psmt.setString(2, vo.getMembName());
			psmt.setString(3, vo.getMembPhone());
			psmt.setString(4, vo.getMembAddr());
			psmt.setString(5, vo.getMembBirth());
			psmt.setString(6, vo.getMembImage());

			vo.setMembNo(nextSeq);

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return vo;
	}

	// 수정.(MemverVO)
	public boolean updateMember(MemberVO vo) {
		getConnect();
		String sql = "update member " //
				+ "   set      memb_name = ?, " //
				+ "            memb_addr = ?, " //
				+ "            memb_phone = ?, " //
				+ "            memb_birth = ?, " //
				+ "            memb_image = ? " //
				+ "    where memb_no = ?"; // 조건문
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMembName());
			psmt.setString(2, vo.getMembAddr());
			psmt.setString(3, vo.getMembPhone());
			psmt.setString(4, vo.getMembBirth());
			psmt.setString(5, vo.getMembImage());
			psmt.setInt(6, vo.getMembNo());

			int r = psmt.executeUpdate(); // 수정된 건수를 반환.
			if (r > 0) {
				return true; // 정상적으로 변경.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	// 삭제.(memb_no)
	public boolean deleteMember(int membNo) {
		getConnect();
		String sql = "delete from member where memb_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, membNo);

			int r = psmt.executeUpdate(); // 수정된 건수를 반환.
			if (r > 0) {
				return true; // 정상적으로 변경.
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	// 조건 조회.(memb_no)
	public MemberVO searchMember(int membNo) {
		getConnect();
		MemberVO mem = null;
		try {
			psmt = conn.prepareStatement("select * from member where memb_no = ?");
			psmt.setInt(1, membNo);
			rs = psmt.executeQuery(); // 조회: excuteQuery, 추가,수정,삭제: excuteUpdate
			if (rs.next()) {
				mem = new MemberVO();
				mem.setMembNo(rs.getInt("memb_no"));
				mem.setMembName(rs.getString("memb_name")); // memb_name: 칼럼이름
				mem.setMembPhone(rs.getString("memb_phone"));
				mem.setMembAddr(rs.getString("memb_addr"));
				mem.setMemBirth(rs.getString("memb_birth"));
				mem.setMembImage(rs.getString("memb_image"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return mem;
	}
}
