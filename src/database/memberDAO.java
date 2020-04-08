package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class memberDAO {
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
	
	

}
