package br.dftrans.wiki.beans;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.dftrans.wiki.dao.InformacaoDAO;
import br.dftrans.wiki.domain.Informacao;
import br.dftrans.wiki.utils.FacesUtil;

@ManagedBean(name="MB_View")
@ViewScoped
public class DialogView implements Serializable{
	private List<Informacao> informacoes ;
	private boolean isDowload = true;


	@PostConstruct
	public void init() {
		
		InformacaoDAO infDao = new InformacaoDAO();
		
		String valor;
		HttpSession sessao = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		valor = (String) sessao.getAttribute("id");
		
		List <Informacao> informacao = new ArrayList<>();
		informacao.add(infDao.findByOneCod(Long.parseLong(valor)));	
		String inf = informacao.get(0).getConteudo().replaceAll("\n","<br/>");
		informacao.get(0).setConteudo(inf);
		setInformacoes(informacao);
		
		
	}

	/*@PostConstruct
	public void init(){
	//	String valor = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idInformacao");
		
		InformacaoDAO infDao = new InformacaoDAO();
		setInformacoes(infDao.getAll());
		//System.out.println("===============================");
		//System.out.println("valor"+valor);
		//System.out.println("===============================");
	}*/
	
	
	//getteres and setteres
	public List<Informacao> getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(List<Informacao> informacoes) {
		this.informacoes = informacoes;
	}
	public boolean isDowload() {
		return isDowload;
	}

	public void setDowload(boolean isDowload) {
		this.isDowload = isDowload;
	}
}
