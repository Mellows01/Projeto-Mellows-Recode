import java.util.Scanner;

public class LiCRUD {

	public static void main(String[] args) {
		LiDAO liDAO = new LiDAO();
		LI li = new LI();
		Scanner in = new Scanner(System.in);
		int op = 0;
		

		do {
			System.out.println("======= MENU LI =======");
			System.out.println("[1] - CADASTRO DE LIVROS");
			System.out.println("[2] - EXCLUIR LIVRO");
			System.out.println("[3] - ATUALIZAR LIVRO");
			System.out.println("[4] - MOSTRAR LIVRO");
			System.out.println("[5] - BUSCAR LIVRO PELO ID");
			System.out.println("[6] - SAIR");
			op = in.nextInt();

			switch (op) {
			case 1:
				System.out.println("===== CADASTRO DE LIVROS =====");
				System.out.println("Digite o nome do livro: ");
				li.setNome(in.next());
				System.out.println("Digite o genero do livro: ");
				li.setGenero(in.next());
				System.out.println("Digite o nível do livro: ");
				li.setNivel(in.next());
				liDAO.save(li);
				break;
			case 2:
				System.out.println("===== EXCLUIR LIVRO =====");
				System.out.println("Digite o ID do livro para deletar:");
				liDAO.removeById(in.nextInt());
				System.out.println("Livro excluido com sucesso!");
				break;
			case 3:
				System.out.println("===== ATUALIZAR =====");
				System.out.println("Digite o ID do livro para atualizar: ");
				li.setIdLi(in.nextInt());
				System.out.println("Digite o novo nome do livro: ");
				li.setNome(in.next());
				System.out.println("Digite o novo nivel do livro: ");
				li.setNivel(in.next());
				System.out.println("Digite o novo genero do livro: ");
				li.setGenero(in.next());
				liDAO.update(li);
				break;
			case 4: 
				System.out.println("===== RELAÇÃO DE LIVROS =====");
				for (LI l : liDAO.getLivros()) {
					System.out.println("ID: " + l.getIdLi());
					System.out.println("Nome: " + l.getNome());
					System.out.println("Gênero: " + l.getGenero());
					System.out.println("Nível: " + l.getNivel());
					System.out.println("===============================");
				}
				break;
			case 5: 
				LI l1 = new LI();
				System.out.println("===== BUSCAR CONTATO PELO ID =====");
				System.out.println("Digite o ID do livro: ");
				li.setIdLi(in.nextInt());
				l1 = liDAO.buscarID(li.getIdLi());
				System.out.println("ID: " + li.getIdLi());
				System.out.println("Nome: " + l1.getNome());
				System.out.println("Gênero: " + l1.getGenero());
				System.out.println("Nível: " + l1.getNivel());
				
				break;
			default : 
				System.out.println("===== OPÇÃO INVÁLIDA =====");
			}
		} while (op != 6);

	in.close();
	}

	
	
}
