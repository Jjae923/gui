package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import oracle.jdbc.proxy.annotation.Pre;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class MemberDAO {
	// 드라이버 클래스 로드
	static { // static 해놓으면 DB에 미리 끌어올려짐
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 커넥션 연결
	public Connection getConnection() {
		String url="jdbc:oracle:thin:@localhost:1521:orcl"; // 데이터베이스 서버 주소 및 연결문자열
		String user="javadb";
		String password="12345";

		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	// 데이터베이스 요청 작업
	public Vector<MemberVO> getList(){
		Vector<MemberVO> vecList=new Vector<MemberVO>();
		
		String sql = "select * from memberTBL";
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()) {
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setAge(rs.getInt(3));
				vo.setGender(rs.getString(4));
				vecList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vecList;
	}
	
	public int insert(MemberVO vo) {
		String sql = "insert into memberTBL values(member_seq.nextval,?,?,?)";
		int result=0;
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			
			result = pstmt.executeUpdate(); // 쿼리 실행시켜주고 결과 (int로) 받아오기
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// no에 해당하는 레코드 가져오기
	public MemberVO getRow(int no) {
		String sql = "select * from memberTBL where no=?";
		MemberVO vo = null;
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo=new MemberVO();
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt(3));
				vo.setGender(rs.getString("gender"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	// no 값을 이용해서 회원 삭제하기
	// delete from memberTBL where no=?
	public int remove(int no) {
		int result=0;
		String sql="delete from memberTBL where no=?";
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
  