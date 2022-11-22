package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Aluno implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private String matricula;
	
	@Column
	private String nome;
	
	@Column
	private String endereco;
	
	@Column(name="data_ingresso", nullable = false)
	private String dataIngresso;
	
	@Column(name="data_conclusao")
	private String dataConclusao;
	
	
	@OneToMany(mappedBy = "aluno")
	private List<AlunoDisciplina> notas = new ArrayList<>();
	


	
	public String getMatricula() {
		return matricula;
	}




	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getEndereco() {
		return endereco;
	}




	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}




	public String getDataIngresso() {
		return dataIngresso;
	}




	public void setDataIngresso(String dataIngresso) {
		this.dataIngresso = dataIngresso;
	}




	public String getDataConclusao() {
		return dataConclusao;
	}




	public void setDataConclusao(String dataConclusao) {
		this.dataConclusao = dataConclusao;
	}




	public List<AlunoDisciplina> getNotas() {
		return notas;
	}




	public void setNotas(List<AlunoDisciplina> notas) {
		this.notas = notas;
	}




	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", endereco=" + endereco + ", dataIngresso="
				+ dataIngresso + ", dataConclusao=" + dataConclusao + "]";
	}
	
	
   
}