package br.dftrans.wiki.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.dftrans.wiki.dao.SetorDAO;
import br.dftrans.wiki.dao.UsuarioDAO;
import br.dftrans.wiki.domain.Setor;
import br.dftrans.wiki.domain.Usuario;
import br.dftrans.wiki.utils.MD5;

public class UsuarioDAOTest {
	@Test
	@Ignore
	public void testGetOne(){
		UsuarioDAO dao = new UsuarioDAO();
		Usuario x = dao.findByChave("2");
		System.out.println("HUEHUE BR "+x.getNome());
	}
	
	@Test
	@Ignore
	public void testRemove(){
		UsuarioDAO dao = new UsuarioDAO();
		Usuario x = dao.findByChave("2");
		System.out.println(x.getMatricula());
		System.out.println(x.getNome());
		System.out.println(x.getSenha());
		
		dao.delete(x);
	}
	
	@Test
	@Ignore
	public void testSave(){
		UsuarioDAO dao = new UsuarioDAO();
		Usuario x = new Usuario();
		SetorDAO setordao = new SetorDAO();
		List<Setor> setores = setordao.getAll();
		x.setNome("Vitor");
		x.setMatricula("1");
		x.setSenha(MD5.md5("1"));
		x.setSetor(setores.get(0));
		
		System.out.println("======================");
		System.out.println(x);
		dao.save(x);
	}
	
	@Test
	@Ignore
	public void testGetAll(){
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> x = dao.getAll();
		for (Usuario usuario : x) {
			System.out.println(usuario.getNome());
		}
	}
	
	@Test
	@Ignore
	public void testUpdate(){
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario x = new Usuario();
		
		SetorDAO setordao = new SetorDAO();
		
		
		x = dao.findByChave("1");
		
		x.setMatricula("1");
		x.setNome("vitor");
		x.setSenha(MD5.md5("1"));
		dao.update(x);
	}
	
	@Test
	@Ignore
	public void  getLogin(){
		UsuarioDAO dao = new UsuarioDAO();
		Usuario x = dao.getLogin("5","1");
		System.out.println(x.getNome());
	}
	@Test

	public void save(){
		SetorDAO setordao = new SetorDAO();
		List<Setor> setores = setordao.getAll();
		UsuarioDAO dao = new UsuarioDAO();
		Usuario x = new Usuario();
		Usuario y = new Usuario();
	//	x = dao.findByChave("1");
		y.setSetor(setores.get(0));
		y.setMatricula("1");
		y.setNome("Clovis");
		String s = MD5.md5("1");
		
		System.out.println(s);
		
		y.setSenha(MD5.md5(s));
		y.setSetor(setores.get(0));
	
		dao.save(y);
		
	}
	
}
