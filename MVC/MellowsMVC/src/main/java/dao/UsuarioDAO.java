package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Login;
import model.Usuario;

public class UsuarioDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Usuario usuario) {
		String sql = "INSERT INTO Usuario (senha, dataNascimento, nome, email, idLogin) values (?, ?, ?, ?, ?)";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, usuario.getSenha());
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(2, new Date(formatter.parse(usuario.getDataNascimento()).getTime()));
			pstm.setString(3, usuario.getNome());
			pstm.setString(4, usuario.getEmail());
			pstm.setInt(5, usuario.getLogin().getId());
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

	public List<Usuario> getUsuario() {
		String sql = "select * from usuario_login";

		List<Usuario> listaUsers = new ArrayList<>();
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();
			while (rset.next()) {
				Usuario usuario = new Usuario();
				Login login = new Login();
				usuario.setSenha(rset.getString("senha"));
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				usuario.setDataNascimento(dateFormat.format(rset.getDate("dataNascimento")));
				usuario.setNome(rset.getString("nome"));
				usuario.setEmail(rset.getString("email"));
				login.setId(rset.getInt("idLogin"));
				login.setTipo(rset.getString("tipoLogin"));
				usuario.setLogin(login);
				usuario.setIdUsuario(rset.getInt("idUsuario"));
				listaUsers.add(usuario);
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
		return listaUsers;
	}

	public void update(Usuario usuario) {
		String sql = "UPDATE Usuario SET senha = ?, nome = ?, dataNascimento = ?, email = ?, idLogin = ? WHERE idUsuario = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, usuario.getSenha());
			pstm.setString(2, usuario.getNome());
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(3, new Date(formatter.parse(usuario.getDataNascimento()).getTime()));
			pstm.setString(4, usuario.getEmail());
			pstm.setInt(5, usuario.getLogin().getId());
			pstm.setInt(6, usuario.getIdUsuario());

			pstm.executeUpdate();

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

	public void deleteById(int idUsuario) {
		String sql = "DELETE FROM usuario WHERE idUsuario = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, idUsuario);
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

	public Usuario getUsuarioById(int idUsuario) {
		String sql = "select * from usuario WHERE idUsuario = ?;";
		Login login = new Login();

		Usuario usuario = new Usuario();
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, idUsuario);
			rset = pstm.executeQuery();
			rset.next();
			
			usuario.setSenha(rset.getString("senha"));
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			usuario.setDataNascimento(dateFormat.format(rset.getDate("dataNascimento")));
			usuario.setNome(rset.getString("nome"));
			usuario.setEmail(rset.getString("email"));
			usuario.setIdUsuario(rset.getInt("idUsuario"));
			login.setId(rset.getInt("idLogin"));
			usuario.setLogin(login);

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
		return usuario;
	}

}
