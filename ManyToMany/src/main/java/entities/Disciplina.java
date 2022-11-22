package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private String codigo;

	@Column
	private String nome;

	@OneToMany(mappedBy = "disciplina")
	private List<AlunoDisciplina> notas = new ArrayList<>();

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<AlunoDisciplina> getNotas() {
		return notas;
	}

	public void setNotas(List<AlunoDisciplina> notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "Disciplina [codigo=" + codigo + ", nome=" + nome + "]";
	}

}