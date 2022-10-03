package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.LI;

public class LiDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rset = null;

	public void save(LI li) {
		String sql = "INSERT INTO Li (nivel, nome, genero)" + "VALUES (?,?,?)";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, li.getNivel());
			pstm.setString(2, li.getNome());
			pstm.setString(3, li.getGenero());
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void removeById(int id) {
		String sql = "DELETE FROM Li WHERE idLi = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(LI li) {
		String sql = "UPDATE Li SET nivel = ?, nome = ?, genero = ?" + "WHERE idLi = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, li.getNivel());
			pstm.setString(2, li.getNome());
			pstm.setString(3, li.getGenero());
			pstm.setInt(4, li.getIdLi());
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<LI> getLivros() {
		String sql = "SELECT * FROM Li";
		List<LI> liArray = new ArrayList<LI>();

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				LI li = new LI();

				li.setIdLi(rset.getInt("idLi"));
				li.setNivel(rset.getString("nivel"));
				li.setNome(rset.getString("nome"));
				li.setGenero(rset.getString("genero"));
				liArray.add(li);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return liArray;
	}

	public LI buscarID(int id) {
		String sql = "SELECT * FROM Li WHERE idLi = ?";
		LI li = new LI();

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();
			li.setNivel(rset.getString("nivel"));
			li.setNome(rset.getString("nome"));
			li.setGenero(rset.getString("genero"));
			li.setIdLi(Integer.parseInt(rset.getString("idLi")));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return li;
	}
}