package grupoEscolar;

import javax.swing.JOptionPane;

public class EnsinoFundamental extends Estudante {
	private static final long serialVersionUID = 1L;
	
	public EnsinoFundamental(String instituicaoEnsino, int matricula, String nome, String responsavel) {
		super(instituicaoEnsino, matricula, nome, responsavel);
		this.atividades = JOptionPane.showInputDialog("Informe as atividades de contraturno (ex.: natação, judo, ginástica, ...):");
		this.tipo = "Ensino Fundamental";
	}

	public String estudar() {
		return "Trabalhos escolares";
	}
}