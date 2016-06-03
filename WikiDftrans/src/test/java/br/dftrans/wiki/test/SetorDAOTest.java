package br.dftrans.wiki.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.dftrans.wiki.dao.SetorDAO;
import br.dftrans.wiki.domain.Setor;

public class SetorDAOTest {
	@Test
	public void salvar(){
		SetorDAO dao = new SetorDAO();
		Setor x = new Setor();
		x.setSetor("DTI");
		x.setUdidade("DTI");
		dao.save(x);
	}
	@Test
	@Ignore
	public void listar(){
		SetorDAO dao = new SetorDAO();
		List<Setor> setores = dao.getAll();
		for (Setor setor : setores) {
			System.out.println(setor.getSetor());
		}
	}
	@Test
	@Ignore
	public void getOne (){
		SetorDAO dao = new SetorDAO();
		Setor x = dao.findBy(3L);
		System.out.println(x.getSetor());
	}
}
