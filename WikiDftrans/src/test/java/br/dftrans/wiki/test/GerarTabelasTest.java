package br.dftrans.wiki.test;

import org.junit.Test;

import br.dftrans.wiki.utils.HibernateUtil;

public class GerarTabelasTest {
	@Test
	public void gerar () {
		HibernateUtil dao = new HibernateUtil();
		dao.close();
	}
}
