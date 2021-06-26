package grupoEscolar;

import javax.swing.JOptionPane;

public class PreEscolar extends Estudante {
	private static final long serialVersionUID = 1L;
	
	public PreEscolar(String instituicaoEnsino, int matricula, String nome, String responsavel) {
		super(instituicaoEnsino, matricula, nome, responsavel);
		this.cuidados = JOptionPane.showInputDialog("Informe os cuidados necessários com o estudante (ex.: alergias, remédios, intolerância alimentar, ...):");
		this.tipo = "Pré-Escolar";
	}
	
	public String estudar() {
		return "Desenhos e pinturas";
	}
}