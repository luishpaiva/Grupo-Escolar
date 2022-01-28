package grupoEscolar;

import java.io.Serializable;

public abstract class Estudante implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int matricula;
	private String instituicaoEnsino, nome, responsavel;
	protected String tipo, cuidados, atividades, oficinas, curso;
	
	public Estudante(String instituicaoEnsino, int matricula, String nome, String responsavel) {
		this.instituicaoEnsino = instituicaoEnsino;
		this.matricula = matricula;
		this.nome = nome;
		this.responsavel = responsavel;
	}

	public String toString() {
		String dadosEstudante = "";
		dadosEstudante += "Instituição de Ensino: \t" + this.instituicaoEnsino + "\n";
		dadosEstudante += "Matrícula: \t"+ this.matricula + "\n";
		dadosEstudante += "Nome: \t" + this.nome + "\n";
		dadosEstudante += "Responsável: \t" + this.responsavel + "\n";
		dadosEstudante += "Tipo de Estudante: \t" + this.tipo + "\n";
		dadosEstudante += "Tipo de Estudo: \t" + this.estudar() + "\n";
		if (this.tipo == "Pré-Escolar") {
			dadosEstudante += "Cuidados: \t" + this.cuidados + "\n";
		} else if (this.tipo == "Ensino Fundamental") {
			dadosEstudante += "Atividades do Contraturno: \t" + this.atividades + "\n";
		} else if (this.tipo == "Ensino Médio") {
			dadosEstudante += "Oficinas Profissionalizantes: \t" + this.oficinas + "\n";
		} else {
			dadosEstudante += "Curso de Graduação: \t" + this.curso + "\n";
		}
		return dadosEstudante;
	}

	public abstract String estudar();
}