package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ID class for entity: AlunoDisciplina
 *
 */ 
@Embeddable
public class AlunoDisciplinaKey  implements Serializable {   
   
	
	private static final long serialVersionUID = 1L;

	 @Column(name = "matricula")         
	private String matricula;
	 
	 @Column(name = "codigo")
	private String codigo;

	
	public AlunoDisciplinaKey() {
		
	}
	 
	 
	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof AlunoDisciplinaKey)) {
			return false;
		}
		AlunoDisciplinaKey other = (AlunoDisciplinaKey) o;
		return true
			&& (getMatricula() == null ? other.getMatricula() == null : getMatricula().equals(other.getMatricula()))
			&& (getCodigo() == null ? other.getCodigo() == null : getCodigo().equals(other.getCodigo()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getMatricula() == null ? 0 : getMatricula().hashCode());
		result = prime * result + (getCodigo() == null ? 0 : getCodigo().hashCode());
		return result;
	}    
}