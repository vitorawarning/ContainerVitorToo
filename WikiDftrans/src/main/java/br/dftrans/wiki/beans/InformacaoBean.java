package br.dftrans.wiki.beans;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;

import br.dftrans.wiki.dao.ArquivoDAO;
import br.dftrans.wiki.dao.InformacaoDAO;
import br.dftrans.wiki.domain.Arquivo;
import br.dftrans.wiki.domain.Informacao;
import br.dftrans.wiki.domain.Usuario;
import br.dftrans.wiki.utils.FacesUtil;

@ManagedBean(name="MB_Informacao")
@SessionScoped
public class InformacaoBean {
	private Date data;
	private Informacao informacao;
	private Arquivo arq;
	private String caminho;


@PostConstruct
	public void init(){
		setCaminho("/resources/images/unchecked-icon.png");
		System.out.println(getCaminho());
}

	public InformacaoBean() {
		setInformacao(new Informacao());
		setArq(new Arquivo());
		setData(new Date());
		
	}

	
	
	public void save(){

		
		setCaminho("/resources/images/unchecked-icon.png");
		HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Usuario user = (Usuario) sessao.getAttribute("usuario");
		getInformacao().setUsuario(user);
		getInformacao().setSetor(user.getSetor());
		DateFormat date = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		
		getInformacao().setData(date.format(getData()));
	


		if(getArq().getArquivo() != null){
			ArquivoDAO arqdao = new ArquivoDAO();
			arqdao.save(getArq());
			getInformacao().setArquivo(getArq());
			setArq(new Arquivo());
		}
		InformacaoDAO infdao = new InformacaoDAO();
		infdao.save(getInformacao());
		
		FacesUtil.addMsgInfo("Dados salvos com sucesso");
		setInformacao(new Informacao());
	}

	
	public void upload(FileUploadEvent event){
		setCaminho("/resources/images/checked-icon.png");
		
		try {
			String[] extensao =  event.getFile().getFileName().split("\\.");
			InputStream canal = event.getFile().getInputstream();
			getArq().setExtensao("."+extensao[extensao.length-1]);
			getArq().setArquivo(IOUtils.toByteArray(canal));
			FacesUtil.addMsgInfo("Arquivo = "+event.getFile().getFileName()+" Adicionado com sucesso");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	
	public Informacao getInformacao() {
		return informacao;
	}




	public void setInformacao(Informacao informacao) {
		this.informacao = informacao;
	}

	public Arquivo getArq() {
		return arq;
	}


	public void setArq(Arquivo arq) {
		this.arq = arq;
	}


	public String getCaminho() {
		return caminho;
	}



	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

}
