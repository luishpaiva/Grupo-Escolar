package grupoEscolar;

import javax.swing.JOptionPane;

public class EnsinoMedio extends Estudante {
	private static final long serialVersionUID = 1L;
	
	public EnsinoMedio(String instituicaoEnsino, int matricula, String nome, String responsavel) {
		super(instituicaoEnsino, matricula, nome, responsavel);
		this.oficinas = JOptionPane.showInputDialog("Informe as oficinas profissionalizantes (ex.: computa��o, administra��o, contabilidade, ...):");
		this.tipo = "Ensino M�dio";
	}
	
	public String estudar() {
		return "Provas e exames";
	}
}