package br.dftrans.wiki.domain;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tb_arquivo")
public class Arquivo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_arquivo")
	private Long id;
	
	//@NotEmpty(message="O campo nome é obrigatório")
	@Column(name = "nome_arquivo", length = 45 , nullable = true)
	private String nome;
	
	@Lob
	@Column(name = "arquivo", nullable = true, columnDefinition = "LONGBLOB")
	//@Column(name = "arquivo", nullable = true)
	private byte[] arquivo;
	
	@Column(name="extensao",nullable = true)
	private String extensao;
	
	
//	@ManyToOne
	//@JoinColumn(name="tb_informacao_id_informacao",referencedColumnName="id_informacao", nullable = false)
	//private Informacao informacao;
	//construtor vazio
	
/*	public Informacao getInformacao() {
		return informacao;
	}

	public void setInformacao(Informacao informacao) {
		this.informacao = informacao;
	}*/


	public Arquivo() {
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id = "+getId()+"\n");
		sb.append("Nome = "+getNome()+"\n");
		sb.append("Arquivo = "+Arrays.toString(getArquivo())+"\n");
		//sb.append("Informacao = "+getInformacao()+"\n");
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
		Arquivo other = (Arquivo) obj;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public byte[] getArquivo() {
		return arquivo;
	}
	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}
	public String getExtensao() {
		return extensao;
	}


	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}


	
	
}
