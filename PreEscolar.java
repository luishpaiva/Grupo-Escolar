package grupoEscolar;

import javax.swing.JOptionPane;

public class PreEscolar extends Estudante {
	private static final long serialVersionUID = 1L;
	
	public PreEscolar(String instituicaoEnsino, int matricula, String nome, String responsavel) {
		super(instituicaoEnsino, matricula, nome, responsavel);
		this.cuidados = JOptionPane.showInputDialog("Informe os cuidados necess�rios com o estudante (ex.: alergias, rem�dios, intoler�ncia alimentar, ...):");
		this.tipo = "Pr�-Escolar";
	}
	
	public String estudar() {
		return "Desenhos e pinturas";
	}
}