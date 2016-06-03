package br.dftrans.wiki.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.dftrans.wiki.enuns.TipoAcesso;
import br.dftrans.wiki.utils.MD5;


@Entity
@Table(name = "tb_usuario")
@NamedQueries({
	@NamedQuery(name="Usuario.getOne",query="select t from Usuario t where t.matricula = :matricula"),
	@NamedQuery(name="Usuario.getAll",query="select t from Usuario t"),
	@NamedQuery(name="Usuario.login",query="select t from Usuario t where t.senha = :senha AND t.matricula= :matricula")
})
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_usuario")
	private Long id;
	
	@NotEmpty(message="O campo matrícula é obrigatório")
	@Column(name="matricula", length = 100 , nullable = false, unique = true)
	private String matricula;
	
	@NotEmpty(message="O campo nome é obrigatório")
	@Column(name="nome", length = 100 , nullable = false)
	private String nome;
	
	@NotEmpty(message="O campo senha é obrigatório") 
	@Column(name="senha", length = 100 , nullable = false)
	private String senha;
	
	@NotNull(message="É obrigatório informar um setor") 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tb_setor_id_setor", referencedColumnName = "id_setor" , nullable = false)
	private Setor setor;
	
	//0 = administrador
	//1 = usuario
	@NotNull(message="É obrigatório informar um tipo de acesso")
	@Enumerated(EnumType.ORDINAL)
	@Column(name="tipo_acesso", nullable=false)
	private TipoAcesso tipoAcesso;
	
	//Construtor vazio
	


	public Usuario() {
	}





	public Long getId() {
		return id;
	}
	
	
	
	
	
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id = "+getId()+"\n");
		sb.append("Matricula = "+getMatricula()+"\n");
		sb.append("Nome = "+getNome()+"\n");
		sb.append("Senha = "+getSenha()+"\n");
		sb.append("Setor = "+getSetor()+"\n");
		return sb.toString();
	}
	
	//sobrescrita hash code and equals
	







	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Usuario other = (Usuario) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	
	
	//getteres and setteres


	public void setId(Long id) {
		this.id = id;
	}


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


	public String getSenha() {
		return MD5.md5(senha);
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Setor getSetor() {
		return setor;
	}


	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public TipoAcesso getTipoAcesso() {
		return tipoAcesso;
	}


	public void setTipoAcesso(TipoAcesso tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}

	

	
	
}
