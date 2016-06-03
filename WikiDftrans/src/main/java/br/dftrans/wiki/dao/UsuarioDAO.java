package br.dftrans.wiki.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import br.dftrans.wiki.domain.Setor;
import br.dftrans.wiki.domain.Usuario;
import br.dftrans.wiki.exceptions.ExceptionDAO;
import br.dftrans.wiki.utils.HibernateUtil;

public class UsuarioDAO implements DAO<Usuario>{

	@Override
	public void save (Usuario usuario){
		HibernateUtil sessao = new HibernateUtil();
		EntityManager manager = sessao.getManager();
		try {
			manager.getTransaction().begin();
			manager.persist(usuario);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao salvar dados");
		}finally {
			sessao.close();
		}
	}

	@Override
	public List<Usuario> getAll(){
		HibernateUtil sessao = new HibernateUtil();
		List<Usuario> usuarios = null;
		EntityManager manager = sessao.getManager();
		try {
			usuarios = manager.createNamedQuery("Usuario.getAll",Usuario.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao coletar todos do banco...");
		}finally {
			sessao.close();
		}
		return usuarios;
	}

	@Override
	public Usuario findByChave(String chave){
		HibernateUtil sessao = new HibernateUtil();
		EntityManager manager = sessao.getManager();
		try {
			return manager.createNamedQuery("Usuario.getOne",Usuario.class).setParameter("matricula",chave).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao selecionar um usuario...");
		}finally {
			sessao.close();
		}
	}

	@Override
	public boolean delete(Usuario t) {
		HibernateUtil sessao = new HibernateUtil();
		EntityManager manager = sessao.getManager();
		boolean flag = false;
		try {
			manager.getTransaction().begin();
			manager.remove(manager.contains(t) ? t : manager.merge(t));
			manager.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			throw new ExceptionDAO("Erro ao excluir um usuario...");
		}finally {
			sessao.close();
		}
		return flag;
	}

	@Override
	public boolean update(Usuario t){
		HibernateUtil sessao = new HibernateUtil();
		EntityManager manager = sessao.getManager();
		boolean flag = false;
		try {
			manager.getTransaction().begin();
			manager.merge(t);
			manager.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao alterar Usuario");
		}finally {
			sessao.close();
		}
		return flag;
		
	}

	@Override
	public List<Usuario> findByCod(Long cod) throws ExceptionDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findByObj(Usuario t) throws ExceptionDAO {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Usuario getLogin (String matricula, String senha){
		HibernateUtil sessao = new HibernateUtil();
		Usuario user = null;
		try {
			EntityManager manager = sessao.getManager();
			user = manager.createNamedQuery("Usuario.login",Usuario.class).setParameter("matricula", matricula).setParameter("senha",senha).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro na autenticação do usuário...");
		}finally {
			sessao.close();
			return user;
		}
		
		
	}


}
