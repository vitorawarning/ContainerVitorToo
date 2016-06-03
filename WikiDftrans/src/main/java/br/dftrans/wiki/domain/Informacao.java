package br.dftrans.wiki.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tb_informacao")
@NamedQueries({
@NamedQuery(name="Usuario.getList",query="select t from Informacao t where t.setor.id = :setor"),
@NamedQuery(name="Informacao.getDetalhe",query="select i from Informacao i where i.id = :id"),
@NamedQuery(name="Informacao.getAll", query="select i from Informacao i")
})
//@NamedQueries({@NamedQuery(name="Usuario.getAll",query="select t from Informacao t where t.setor.id = :setor")})
public class Informacao implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_informacao")
	private Long id;
	
	@NotEmpty(message="O campo titulo é obrigatório")
	@Column(name = "titulo" , length = 100 , nullable = false)
	private String titulo;
	
	@NotEmpty(message="O campo descrição é obrigatório")
	@Column(name = "conteudo", length = 2000, nullable = false)
	private String conteudo;
	
	@Column(name = "data_criacao",nullable = false)
//	@Temporal(value =TemporalType.TIMESTAMP)
	private String data;
	
	@ManyToOne
	@JoinColumn(name="tb_usuario_id_usuario", referencedColumnName="id_usuario",nullable = false)
	private Usuario usuario;
	
	
	@ManyToOne
	@JoinColumn(name="tb_setor_id_setor", referencedColumnName="id_setor")
	private Setor setor;

	@OneToOne
	@JoinColumn(name="tb_arquivo_id_arquivo",referencedColumnName="id_arquivo", nullable = true)
	private Arquivo arquivo;
	/*@ManyToOne
	@JoinColumn(name="tb_arquivo_id_arquivo",referencedColumnName="id_arquivo", nullable = false)
	private Arquivo arquivo;
*/






	//construtor vazio
	public Informacao() {
	}
	
	
	
	
	
	//sobrescrita hash code and equals
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id = "+getId()+"\n");
		sb.append("Titulo = "+getTitulo()+"\n");
		sb.append("Conteudo = "+getConteudo()+"\n");
		sb.append("data = "+getData()+"\n");
		sb.append("Usuario = "+getUsuario()+"\n");
		sb.append("Setor = "+getSetor()+"\n");
		sb.append("Arquivo = "+getArquivo()+"\n");
		return sb.toString();
	}





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
		Informacao other = (Informacao) obj;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getData() {
		return data;
	}


	public void setData(String converter) {
		this.data = converter;
	}
	public Setor getSetor() {
		return setor;
	}


	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	public Arquivo getArquivo() {
		return arquivo;
	}





	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}


	/*public Arquivo getArquivo() {
		return arquivo;
	}


	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}

*/


	
	
}
