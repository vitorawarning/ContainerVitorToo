package br.dftrans.wiki.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.dftrans.wiki.dao.InformacaoDAO;
import br.dftrans.wiki.domain.Informacao;

public class InformacaoDAOTest {
	@Test
	@Ignore
	public void testeGetByCod(){
		InformacaoDAO dao = new InformacaoDAO();
		List<Informacao> x = dao.findByCod(1L);
		for (Informacao informacao : x) {
			System.out.println("HUEHUEBR = "+informacao.getTitulo());
		}
	}
	
	@Test
	public void testAll(){
		InformacaoDAO dao = new InformacaoDAO();
		System.out.println(dao.getAll());
	}
}
