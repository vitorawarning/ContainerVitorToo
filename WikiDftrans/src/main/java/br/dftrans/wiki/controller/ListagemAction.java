package br.dftrans.wiki.controller;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import br.dftrans.wiki.dao.ArquivoDAO;
import br.dftrans.wiki.dao.InformacaoDAO;
import br.dftrans.wiki.domain.Informacao;
import br.dftrans.wiki.utils.FacesUtil;


@ManagedBean(name = "MB_Listagem")
@SessionScoped
public class ListagemAction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ListDataModel<Informacao> informacoes;
	private ListDataModel<Informacao> detalhe;
	private boolean download;
	public void listagemInformacoes() throws IOException{
		Long id = Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idMenu"));
		InformacaoDAO dao = new InformacaoDAO();
		setInformacoes(new ListDataModel<Informacao>(dao.findBySetor(id)));
		
	}
	
	@PostConstruct
	public void init(){
		//setDetalhe(null);
		//setDownload(false);

		
	}
	
	public void getDetalhamento(){
		
		String valor = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idInformacao");
		HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		sessao.setAttribute("id", valor);
		
	
		InformacaoDAO x = new InformacaoDAO();

		Informacao inf = x.findByOneCod(Long.parseLong(valor));
		if(inf.getArquivo() == null){
			setDownload(false);
		}else{
			setDownload(true);
		}
		
		//InformacaoDAO infdao = new InformacaoDAO();
		//List <Informacao> informacao = new ArrayList<>();
		//informacao.add(infdao.findByOneCod(Long.parseLong(valor)));	
		//setDetalhe(new ListDataModel<Informacao>(informacao));
		
		
		
		Map<String, Object> opcoes = new HashMap<>();
	//	Map<String,List<String>> param = new HashMap<>();
		
		
		
		opcoes.put("modal",true);
		opcoes.put("header","Detalhamento");
		opcoes.put("draggable", false);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight","100%");
		opcoes.put("contentWidth", "100%");
	    opcoes.put("width", 1500);
	    opcoes.put("height", 800);
		
		//System.out.println("===============================================");
		//System.out.println(informacao);
		//System.out.println("===============================================");
		
		
		//param.put("param", Arrays.asList(""+getDetalhe()));
		RequestContext.getCurrentInstance().openDialog("detalheInf", opcoes,null);

		
	}
	//GETTERES AND SETTERES
	public ListDataModel<Informacao> getInformacoes() {
		return informacoes;
	}
	public void setInformacoes(ListDataModel<Informacao> informacoes) {
		this.informacoes = informacoes;
	}
	

	public ListDataModel<Informacao> getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(ListDataModel<Informacao> detalhe) {
		this.detalhe = detalhe;
	}

	public boolean isDownload() {
		return download;
	}



	public void setDownload(boolean download) {
		this.download = download;
	}

}
