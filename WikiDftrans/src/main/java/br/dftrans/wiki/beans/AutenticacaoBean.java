package br.dftrans.wiki.beans;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.dftrans.wiki.dao.UsuarioDAO;
import br.dftrans.wiki.domain.Usuario;
import br.dftrans.wiki.exceptions.ExceptionDAO;
import br.dftrans.wiki.utils.FacesUtil;
import br.dftrans.wiki.utils.MD5;

@ManagedBean
@SessionScoped
public class AutenticacaoBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario user = null;
	private boolean logado = true;
	private boolean sair = false;

	//construtor onde instancio um usuario
	public AutenticacaoBean() {
		setUser(new Usuario());
	}

	public void validate() throws IOException{
		UsuarioDAO dao = new UsuarioDAO();
		//valido se a senha informada e o login do formulário persistem a um usuário no banco
		try {
			String senha = getUser().getSenha();
			Usuario tmp = dao.getLogin(getUser().getMatricula(),senha);

			if(tmp == null){
				FacesUtil.addMsggError("Usuario ou senha invalido...");
			}else{
				//setar se o botão de logar ou o de sair que vai aparecer - nunca os dois juntos
				setLogado(false);
				setSair(true);
				//seto o bean com o usuario que chegou do formulário , caso exista no banco
				setUser(tmp);
				//seto o usuário na sessão
				HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
				sessao.setAttribute("usuario", getUser());
				FacesUtil.addMsgInfo("Usuario = "+getUser().getNome()+" logado");
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
				
			}
		} catch (Exception e) {
			throw new ExceptionDAO("Erro na autenticação");
		}
	}

	public void out(){
		//Botão aparece e esconde
		setLogado(true);
		setSair(false);
		setUser(new Usuario());
		HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		sessao.setAttribute("usuario", null);
		FacesUtil.addMsgInfo("Usuário deslogado com sucesso!");
		try {
			
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml?faces-rediret=false");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//get e set
	public Usuario getUser() {

		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}
	public boolean isSair() {
		return sair;
	}

	public void setSair(boolean sair) {
		this.sair = sair;
	}

}
