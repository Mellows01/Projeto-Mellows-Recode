package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionMySQL;
import modelo.Usuario;

public class UsuarioDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Usuario usuario) {
		String sql = "INSERT INTO Usuario (nome, dataNascimento, senha, email, idLogin) values (?, ?, ?, ?, ?)";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getNome());
			SimpleDateFormat formatter = new SimpleDateFormat("d/MM/yyyy");
			pstm.setDate(2, new Date(formatter.parse(usuario.getDataNascimento()).getTime()));
			pstm.setString(3, usuario.getSenha());
			pstm.setString(4, usuario.getEmail());
			pstm.setInt(5, usuario.getLogin().getIdLogin());

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
		String sql = "select * from Usuario";

		List<Usuario> listaUsers = new ArrayList<>();
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();
			while (rset.next()) {
				Usuario usuario = new Usuario();

				usuario.setNome(rset.getString("nome"));
				SimpleDateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy");
				usuario.setDataNascimento(dateFormat.format(rset.getDate("dataNascimento")));
				usuario.setSenha(rset.getString("senha"));
				usuario.setEmail(rset.getString("email"));
				usuario.setLogin(rset.getInt("idLogin"));
			
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
		String sql = "UPDATE Usuario SET nome = ?, dataNascimento = ?, senha = ?, email = ?, idLogin = ? WHERE idUsuario = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, usuario.getNome());
			SimpleDateFormat formatter = new SimpleDateFormat("d/MM/yyyy");
			pstm.setDate(2, new Date(formatter.parse(usuario.getDataNascimento()).getTime()));
			pstm.setString(3, usuario.getSenha());
			pstm.setString(4, usuario.getEmail());
			pstm.setString(5, usuario.getLogin().getIdLogin());
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
		String sql = "DELETE FROM Usuario WHERE idUsuario = ?;";

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
		String sql = "select * from Usuario WHERE idUsuario = ?;";

		Usuario usuario = new Usuario();
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, idUsuario);
			rset = pstm.executeQuery();
			rset.next();

			usuario.setNome(rset.getString("nome"));
			SimpleDateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy");
			usuario.setDataNascimento(dateFormat.format(rset.getDate("dataNascimento")));
			usuario.setSenha(rset.getString("senha"));
			usuario.setEmail(rset.getString("email"));
			usuario.setLogin(rset.getInt("idLogin"));

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
