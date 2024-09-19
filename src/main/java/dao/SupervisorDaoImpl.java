package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

import domain.Supervisor;

public class SupervisorDaoImpl implements SupervisorDao {

	private DataSource ds;

	public SupervisorDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public void insert(Supervisor supervisor) {
		// ４　DB登録機能　SQLをワークベンチ上で確認
		String sql = "insert into login_key(supervisor_id,supervisor_pass) values(?,?)";
		
		//パスワードをハッシュ化
		String supervisorPass = supervisor.getSupervisorPass();
		String hashed = BCrypt.hashpw(supervisorPass, BCrypt.gensalt());
		//５　ハッシュ化されているかの確認
		
		try (Connection con = ds.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, supervisor.getSupervisorId());
			stmt.setString(2, hashed);
			stmt.executeUpdate();
		
			// ６　ワークベンチでデータが保存されているか確認
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	public Supervisor findByLoginAndPass(String supervisorId, String supervisorPass) {
		String sql = "select * from login_key where supervisor_id = ?";
		try (Connection con = ds.getConnection()) {
			//SQLの準備
			PreparedStatement stmt = con.prepareStatement(sql);
			//SQLへパラメータセット
			stmt.setString(1, supervisorId);
			//SQLの実行
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {

				if (BCrypt.checkpw(supervisorPass, rs.getString("supervisor_pass"))) {

					return new Supervisor(rs.getInt("id"), supervisorId, null);
				}
				return null;

			}
			return null;
		} catch (Exception e) {

		}

		return null;

	}
}
