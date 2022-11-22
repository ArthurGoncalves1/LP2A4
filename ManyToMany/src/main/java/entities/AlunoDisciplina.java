package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: AlunoDisciplina
 *
 */
@Entity
@Table(name="aluno_has_disciplina")
public class AlunoDisciplina implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private AlunoDisciplinaKey id = new AlunoDisciplinaKey();
	
	@ManyToOne
	@MapsId("matricula")	
	@JoinColumn(name="matricula")
	private Aluno aluno;  
	
	@ManyToOne
	@MapsId("codigo")
	@JoinColumn(name="codigo")
	private Disciplina disciplina;
	
	private int nota;
	
	
	public AlunoDisciplina() {
		super();
	}

	public AlunoDisciplinaKey getId() {
		return id;
	}

	public void setId(AlunoDisciplinaKey id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return "AlunoDisciplina [id=" + id + ", aluno=" + aluno + ", disciplina=" + disciplina + ", nota=" + nota + "]";
	}     
	
	
}