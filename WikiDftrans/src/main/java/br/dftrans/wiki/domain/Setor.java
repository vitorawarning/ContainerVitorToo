package br.dftrans.wiki.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tb_setor")
@NamedQueries({
	@NamedQuery(name="Setor.listar", query="select u from Setor u"),
	@NamedQuery(name="Setor.getByCod",query="select t from Setor t where t.id = :id")
})
public class Setor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_setor")
	private Long id;
	@NotEmpty(message="O campo unidade é obrigatório")
	
	@Column(name = "unidade", length = 45 , nullable = false)
	private String udidade;
	
	@NotEmpty (message="O campo setor é obrigatório")
	@Column(name = "setor", length = 45 , nullable = false)
	private String setor;
	
	//construtor vazio
	public Setor() {
	}
	
	
	//sobrescrita toString
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id = "+getId()+"\n");
		sb.append("Unidade = "+getUdidade()+"\n");
		sb.append("Setor = "+getSetor()+"\n");
		return sb.toString();
	}
	
	//sobrescrita hash code and equals
	





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Setor other = (Setor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}




	//getteres and setteres
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUdidade() {
		return udidade;
	}
	public void setUdidade(String udidade) {
		this.udidade = udidade;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
}
