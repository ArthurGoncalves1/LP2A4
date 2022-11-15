package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable {
 
  private static final long serialVersionUID = 1L;
 
	@Id
	@Column 
	private int codigo;
	
	@Column
	private String modelo;
	
	@ManyToOne
	@JoinColumn(name = "codigo_proprietario")
	private Proprietario proprietario;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	@Override
	public String toString() {
		return "Veiculo [codigo=" + codigo + ", modelo=" + modelo + ", proprietario=" + proprietario + "]";
	}

	
	
	

}