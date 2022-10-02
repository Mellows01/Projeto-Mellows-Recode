package crud;

import java.util.Scanner;
import modelo.Login;
import dao.LoginDAO;
import dao.UsuarioDAO;
import modelo.Usuario;

public class UsuarioCRUD {

	public static void main(String[] args) {

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		LoginDAO logdao = new LoginDAO();
		
		Scanner in = new Scanner(System.in);
		int oP = 0;
		int posicao = 0;

		int idUsuario = 1;
		int idLogin = 1;
		String tipoLogin = "";
		String email = "";
		String senha = "";
		String dataNascimento = "";
		String nome = "";

		do {
			System.out.println("=== CRUD Usuários ===");
			System.out.println("1 - Cadastrar novo usuário");
			System.out.println("2 - Consultar usuários cadastrados");
			System.out.println("3 - Atualizar dados de usário");
			System.out.println("4 - Deletar usuário");
			System.out.println("5 - Buscar por ID");
			System.out.println("0 - Sair");
			oP = in.nextInt();

			switch (oP) {
			case 1:
				System.out.println("Digite o nome do usuário: ");
				nome = in.next();
				in.nextLine();
				System.out.println("Informe a data de nascimento: ");
				dataNascimento = in.nextLine();
				System.out.println("Digite a senha: ");
				senha = in.nextLine();
				System.out.println("Digite o email: ");
				email = in.nextLine();
				System.out.println("Informe o tipo de login: ");
				tipoLogin = in.next();

				Login login1 = new Login(idLogin, tipoLogin);
				Usuario user1 = new Usuario(idUsuario, nome, dataNascimento, senha, email, login1);
				usuarioDAO.save(user1);
				
				System.out.println("\n Cadastro realizado com sucesso! \n");
				break;

			case 2:
				for (Usuario u : usuarioDAO.getUsuario()) {
					System.out.println("ID: " + u.getIdUsuario() + " Nome: " + u.getNome() + "Login: "
							+ u.getLogin() + " Email cadastrado: " + u.getEmail() + " : "
							+ u.getDataNascimento() + " Senha de acesso: " + u.getSenha());
				}
				System.out.println("Consulta finalizada!");
				break;

			case 3:
				System.out.println("Digite o nome do cliente: ");
				nome = in.next();
				in.nextLine();
				System.out.println("Informe a data de nascimento: ");
				dataNascimento = in.nextLine();
				System.out.println("Digite a senha: ");
				senha = in.nextLine();
				System.out.println("Digite o email do cliente: ");
				email = in.nextLine();
				System.out.println("Informe o tipo de login: ");
				tipoLogin = in.next();
				
				Login login2 = new Login(idLogin, tipoLogin);
				Usuario user2 = new Usuario(idUsuario, nome, dataNascimento, senha, email, login2);
				usuarioDAO.update(user2);
				System.out.println("Informações atualizadas!");
				break;

			case 4:
				System.out.println("Digite o ID do usuário: ");
				posicao = in.nextInt();
				usuarioDAO.deleteById(posicao);
				break;

			case 5:
				System.out.println("Digite o ID do usuário: ");
				posicao = in.nextInt();
				
				Usuario user3 = usuarioDAO.getUsuarioById(posicao);

				System.out.println("ID: " + user3.getIdUsuario() + " Nome: " + user3.getNome() + "Login: "
						+ user3.getLogin() + " Email cadastrado: " + user3.getEmail() + " : "
						+ user3.getDataNascimento() + " Senha de acesso: " + user3.getSenha());
				break;

			default:
				System.out.println(oP != 0 ? "Opção inválida, digite novamente." : "");
				break;
			}
		} while (oP != 0);

		System.out.println("Finalizado.");
		in.close();
	}

}
