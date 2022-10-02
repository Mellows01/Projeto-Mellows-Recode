package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import connection.ConnectionMySQL;
import modelo.Login;
public class LoginDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(Login login) {
		String sql = "INSERT INTO login (tipoLogin) values(?)";
		
		
		try {
			// Cria uma conexao com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			pstm.setString(1, login.getTipoLogin());
		
			
			// Executar a sql para inser��o dos dados
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

	// Metodo para Ler
	public List<Login> getLogin() {
		String sql = "select * from login;";

		List<Login> lista = new ArrayList<Login>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Login login = new Login();

				login.setIdLogin(rset.getInt("idLogin"));

				login.setTipoLogin(rset.getString("tipoLogin"));

				lista.add(login);

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

		return lista;
	}
	// Metodo pra atualizar

	public void update(Login login) {
		String sql = "UPDATE login set tipoLogin = ? WHERE idLogin = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, login.getTipoLogin());
			pstm.setInt(2, login.getIdLogin());


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

	// Metodo para deletar
	public void deleteById(int id) {
		String sql = "DELETE FROM login WHERE idLogin = ?";

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

	public Login getLoginById(int id) {
		String sql = "SELECT * FROM login WHERE idLogin = ?;";

		Login login = new Login();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			login.setIdLogin(rset.getInt("idLogin"));

			login.setTipoLogin(rset.getString("tipoLogin"));

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

		return login;
	}

}


