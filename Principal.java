package grupoEscolar;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Principal {
	private ArrayList<Estudante> estudantes;

	/*=== CONSTRUTOR ===*/
	public Principal() {
		this.estudantes = new ArrayList<Estudante>();
	}
	
	/*=== MAIN ===*/
	public static void main(String[] args) {
		Principal estudante = new Principal();
		estudante.menuPrincipal();
	}
	
	/*=== MENU ===*/
	public void menuPrincipal() {
		String menu;
		String entrada;
		int opcao1 = 0, opcao2 = 0;

		do {
			menu =  "Controle de Estudantes\n\n" +
					"Selecione uma das opções:\n\n" + 
					opcoesPrincipais();
			entrada = JOptionPane.showInputDialog(menu + "\n\n");
			opcao1 = this.retornarInteiro(entrada);

			switch (opcao1) {
			case 1:
				menu = 	"Cadastro de Estudantes\n\n" +
						"Opções disponíveis:\n\n" +
						opcoesEstudantes();
				entrada = JOptionPane.showInputDialog(menu + "\n\n");
				opcao2 = this.retornarInteiro(entrada);

				switch (opcao2){
				case 1: estudantes.add((Estudante)lerPreEscolar());
					break;
				case 2: estudantes.add((Estudante)lerEnsinoFundamental());
					break;
				case 3: estudantes.add((Estudante)lerEnsinoMedio());
					break;
				case 4: estudantes.add((Estudante)lerEnsinoSuperior());
					break;
				default: 
					JOptionPane.showMessageDialog(null, "Erro! Não foi escolhida uma opção válida de tipo de estudante.");
				}

				break;
			case 2:
				if (estudantes.size() == 0) {
					JOptionPane.showMessageDialog(null, "Primeiramente, cadastre estudantes para poder exibi-los.");
					break;
				}
				String dadosEstudante = "";
				for (int i = 0; i < estudantes.size(); i++)	{
					dadosEstudante += estudantes.get(i).toString() + "----------------------------------------------------------------------\n";
				}
				JOptionPane.showMessageDialog(null, dadosEstudante);
				break;
			case 3:
				if (estudantes.size() == 0) {
					JOptionPane.showMessageDialog(null, "Não foram encontrados estudantes cadastrados. Limpeza não efetuada.");
					break;
				}
				estudantes.clear();
				JOptionPane.showMessageDialog(null, "Todos cadastros foram removidos com sucesso!");
				break;
			case 4:
				if (estudantes.size() == 0) {
					JOptionPane.showMessageDialog(null, "Primeiramente, cadastre estudantes para poder salvá-los.");
					break;
				}
				salvarEstudantes(estudantes);
				JOptionPane.showMessageDialog(null, "Estudante salvo com sucesso!");
				break;
			case 5:
				estudantes = recuperarEstudantes();
				if (estudantes.size() == 0) {
					JOptionPane.showMessageDialog(null, "Sem dados para apresentar.");
					break;
				}
				JOptionPane.showMessageDialog(null, "Dados recuperados com sucesso!");
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Fim do programa GRUPO ESCOLAR.");
				break;
			}
		} while (opcao1 != 9);
	}
	
	/*=== RESTANTE DOS MÉTODOS ===*/
	// Menu com as opções principais
	public String opcoesPrincipais() {
		return 	"1. Cadastrar Estudantes\n" +
				"2. Exibir Estudantes\n" +
				"3. Limpar Estudantes\n" +
				"4. Gravar Estudantes\n" +
				"5. Recuperar Estudantes\n" +
				"9. Sair";
	}
	
	// Menu com as opções dos tipos de estudantes
	public String opcoesEstudantes() {
		return 	"1. Pré-Escolar\n" +
				"2. Ensino Fundamental\n" +
				"3. Ensino Médio\n" +
				"4. Ensino Superior";
	}
	
	// Validar a opção do usuário e retornar caso seja inteiro
	public int retornarInteiro(String entrada) {
		if (entrada == null || "".equals(entrada)) {
			JOptionPane.showMessageDialog(null, "Por gentileza, escolha uma opção antes.\n\nPara sair do programa, digite a opção 9.\n\n");
			return 0;
		} else {
			while (!this.validarInteiro(entrada)) {
				entrada = JOptionPane.showInputDialog(null, "Erro! Não foi possível validar o número.\n\nSelecione uma das opções\n\n" + opcoesPrincipais() + "\n\n");
			}
			return Integer.parseInt(entrada);
		}
	}
	
	// Validar se é inteiro
	private boolean validarInteiro(String entrada) {
		try {
			Integer.parseInt(entrada);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	// Leitura de dados para construir os objetos
	public String[] lerValores(String[] dadosIn) {
		String[] dadosOut = new String[dadosIn.length];
		for (int i = 0; i < dadosIn.length; i++) {
			dadosOut[i] = JOptionPane.showInputDialog("Entre com " + dadosIn[i]+ ":");
		}
		return dadosOut;
	}
	
	// Construção do objeto PreEscolar
	public PreEscolar lerPreEscolar() {
		String[] valoresPE = new String[4];
		String[] nomesPE = {"a instituição de ensino", "o número da matrícula", "o nome do estudante", "o nome do responsável"};
		valoresPE = lerValores(nomesPE);
		int matricula = this.retornarInteiro(valoresPE[1]);
		PreEscolar preEscolar = new PreEscolar(valoresPE[0], matricula, valoresPE[2], valoresPE[3]);
		return preEscolar;
	}
	
	// Construção do objeto EnsinoFundamental
	public EnsinoFundamental lerEnsinoFundamental() {
		String[] valoresEF = new String[4];
		String[] nomesEF = {"a instituição de ensino", "o número da matrícula", "o nome do estudante", "o nome do responsável"};
		valoresEF = lerValores(nomesEF);
		int matricula = this.retornarInteiro(valoresEF[1]);
		EnsinoFundamental ensinoFundamental = new EnsinoFundamental(valoresEF[0], matricula, valoresEF[2], valoresEF[3]);
		return ensinoFundamental;
	}
	
	// Construção do objeto EnsinoMedio
	public EnsinoMedio lerEnsinoMedio() {
		String[] valoresEM = new String[4];
		String[] nomesEM = {"a instituição de ensino", "o número da matrícula", "o nome do estudante", "o nome do responsável"};
		valoresEM = lerValores(nomesEM);
		int matricula = this.retornarInteiro(valoresEM[1]);
		EnsinoMedio ensinoMedio = new EnsinoMedio(valoresEM[0], matricula, valoresEM[2], valoresEM[3]);
		return ensinoMedio;
	}
	
	// Construção do objeto EnsinoSuperior
	public EnsinoSuperior lerEnsinoSuperior() {
		String[] valoresES = new String[4];
		String[] nomesES = {"a instituição de ensino", "o número da matrícula", "o nome do estudante", "o nome do responsável"};
		valoresES = lerValores(nomesES);
		int matricula = this.retornarInteiro(valoresES[1]);
		EnsinoSuperior ensinoSuperior = new EnsinoSuperior(valoresES[0], matricula, valoresES[2], valoresES[3]);
		return ensinoSuperior;
	}
	
	// Gravação dos dados
	public void salvarEstudantes(ArrayList<Estudante> estudantes) {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream (new FileOutputStream("grupoEscolar.dados"));
			for (int i = 0; i < estudantes.size(); i++) {
				outputStream.writeObject(estudantes.get(i));
			}
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Não foi possível criar o arquivo!\n\nVerifique se você possui permissão de escrita ou se a pasta está correta.");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	// Recuperação dos dados
	@SuppressWarnings("finally")
	public ArrayList<Estudante> recuperarEstudantes() {
		ArrayList<Estudante> estudantesTemp = new ArrayList<Estudante>();
		ObjectInputStream inputStream = null;
		try {	
			inputStream = new ObjectInputStream
					(new FileInputStream("GrupoEscolar.dados"));
			Object obj = null;
			while ((obj = inputStream.readObject()) != null) {
				if (obj instanceof Estudante) {
					estudantesTemp.add((Estudante) obj);
				}   
			}          
		} catch (EOFException ex) {
			System.out.println("Atingido o final do arquivo.");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Não foi encontrado arquivo salvo com estudantes!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
			return estudantesTemp;
		}
	}
}