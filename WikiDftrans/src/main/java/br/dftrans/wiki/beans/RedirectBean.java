package br.dftrans.wiki.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="MB_Redirect")
public class RedirectBean {
	
	public String indexHome(){
		return "/pages/index.xhtml?faces-redirect=true";
	}
	
	public String cadastroHome(){
		return "/pages/superUser/cadastroUser.xhtml?faces-redirect=true";
	}
	
	public String informacaoHome(){
		return "/pages/gear/cadastroInformacao.xhtml?faces-redirect=true";
	}
}
