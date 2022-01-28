package grupoEscolar;

import javax.swing.JOptionPane;

public class EnsinoSuperior extends Estudante {
	private static final long serialVersionUID = 1L;
	
	public EnsinoSuperior(String instituicaoEnsino, int matricula, String nome, String responsavel) {
		super(instituicaoEnsino, matricula, nome, responsavel);
		this.curso = JOptionPane.showInputDialog("Informe o curso de graduação:");
		this.tipo = "Ensino Superior";
	}

	public String estudar() {
		return "AE, ATP e ARP ou ASP";
	}
}