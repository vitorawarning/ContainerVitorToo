package br.dftrans.wiki.beans;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.dftrans.wiki.domain.Informacao;

@ManagedBean(name="MB_Download")
@ViewScoped
public class FileDownloadBean implements Serializable{
	public static final String IMAGEM = "image/jpg";
	public static final String PDF = "application/pdf";
	private StreamedContent file;

	
	public StreamedContent dowload(Informacao inf) {
		ByteArrayInputStream is = new ByteArrayInputStream(inf.getArquivo().getArquivo());
		setFile(new DefaultStreamedContent(is,null,inf.getArquivo().getNome()+inf.getArquivo().getExtensao()));
		return getFile();
	}
	
	
	
	//getteres and setteres
	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}



}
