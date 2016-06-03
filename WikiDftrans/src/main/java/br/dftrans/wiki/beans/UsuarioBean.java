package br.dftrans.wiki.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.dftrans.wiki.dao.SetorDAO;
import br.dftrans.wiki.dao.UsuarioDAO;
import br.dftrans.wiki.domain.Setor;
import br.dftrans.wiki.domain.Usuario;
import br.dftrans.wiki.enuns.TipoAcesso;
import br.dftrans.wiki.exceptions.ExceptionDAO;
import br.dftrans.wiki.utils.FacesUtil;

@ManagedBean(name="MBUser")
@ViewScoped
public class UsuarioBean {
	private Usuario user;
	private List<Setor> setores;
	private int tipo = -1;






	public UsuarioBean() {
		setUser(new Usuario());
	}
	
	
	public String saveUser(){
		UsuarioDAO userDao = new UsuarioDAO();
		try {
			if(getTipo() == -1){
				FacesUtil.addMsggError("É obrigatório informar o tipo do usuário");
				return "superUser/cadastroUser.xhtml?faces-redirect=true";
			}
			getUser().setTipoAcesso(TipoAcesso.converterIntByEnun(tipo));
			getUser().setSenha(getUser().getSenha());
			userDao.save(getUser());
			FacesUtil.addMsgInfo("Usuario cadastrado com sucesso...");
		} catch (Exception e) {
			FacesUtil.addMsggError("Usuario já cadastrado");
		}finally{
			setUser(new Usuario());
		}
		return "superUser/cadastroUser.xhtml?faces-redirect=true";
		
		
	}
	@PostConstruct
	public void init(){
		SetorDAO dao = new SetorDAO();
		setSetores(dao.getAll());
	}
	
	




	
	
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
	
	public List<Setor> getSetores() {
		return setores;
	}



	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}
	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


}
