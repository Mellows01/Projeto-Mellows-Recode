package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Livro;
import model.Usuario;

public class LivroDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Livro livro) {
		String sql = "INSERT INTO Livro (nomeLivro, autor, genero, idUsuario) values(?,?,?,?)";

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, livro.getNomeLivro());
			pstm.setString(2, livro.getAutor());
			pstm.setString(3, livro.getGenero());
			pstm.setInt(4, livro.getUsuario().getIdUsuario());

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

	public List<Livro> getLivro() {
		String sql = "select * from livro_usuario;";

		List<Livro> livros = new ArrayList<Livro>();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Livro livro = new Livro();
				Usuario usuario = new Usuario();

				livro.setIdLivro(rset.getInt("idLivro"));
				livro.setNomeLivro(rset.getString("nomeLivro"));
				livro.setAutor(rset.getString("autor"));
				livro.setGenero(rset.getString("genero"));
				usuario.setIdUsuario(rset.getInt("idUsuario"));
				usuario.setSenha(rset.getString("senha"));
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				usuario.setDataNascimento(dateFormat.format(rset.getDate("dataNascimento")));
				usuario.setNome(rset.getString("nome"));
				usuario.setEmail(rset.getString("email"));
				livro.setUsuario(usuario);
				livros.add(livro);

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

		return livros;
	}

	public void update(Livro livro) {
		String sql = "UPDATE Livro set nomeLivro = ?, autor = ?, genero = ?, idUsuario = ? WHERE idLivro = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, livro.getNomeLivro());
			pstm.setString(2, livro.getAutor());
			pstm.setString(3, livro.getGenero());
			pstm.setInt(4, livro.getUsuario().getIdUsuario()); 
			pstm.setInt(5, livro.getIdLivro());

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

	public void deleteById(int id) {
		String sql = "DELETE FROM Livro WHERE idLivro = ?";

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

	public Livro getLivroById(int id) {
		String sql = "SELECT * FROM Livro WHERE idLivro = ?;";

		Livro livro = new Livro();
	

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			livro.setIdLivro(rset.getInt("idLivro"));
			livro.setNomeLivro(rset.getString("nomeLivro"));
			livro.setAutor(rset.getString("autor"));
			livro.setGenero(rset.getString("genero"));
		
			

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

		return livro;
	}

}
