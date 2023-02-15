package team.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import info.model.InfoDto;
import oracle.db.DbConnect;

public class TeamDao {
	DbConnect db = new DbConnect();
	// insert
	public void insertTeam(TeamDto dto) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = "insert into info values(seq_1.nextval, ?, ?,?, sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);

			// 바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getLic());
			pstmt.setString(3, dto.getHp());

			// update
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	//select
	
}
