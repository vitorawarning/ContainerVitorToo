package br.dftrans.wiki.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.dftrans.wiki.domain.Informacao;
import br.dftrans.wiki.exceptions.ExceptionDAO;
import br.dftrans.wiki.utils.HibernateUtil;

public class InformacaoDAO implements DAO<Informacao>{

	@Override
	public void save(Informacao t) {
		HibernateUtil sessao = new HibernateUtil();
		try {
			EntityManager manager = sessao.getManager();
			manager.getTransaction().begin();
			manager.persist(t);
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao salvar informacao...");
		}finally {
			sessao.close();
		}
	}

	@Override
	public List<Informacao> getAll() throws ExceptionDAO {
		HibernateUtil sessao = new HibernateUtil();
		List<Informacao> ret = null;
		try {
			EntityManager manager = sessao.getManager();
			ret = manager.createNamedQuery("Informacao.getAll", Informacao.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao coletar informacoes...");
		}finally {
			sessao.close();
		}
		return ret;
	}

	@Override
	public Informacao findByChave(String chave) throws ExceptionDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Informacao t) throws ExceptionDAO {
		return false;
	}

	@Override
	public boolean update(Informacao t) throws ExceptionDAO {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Informacao> findBySetor(Long cod) throws ExceptionDAO {
		HibernateUtil sessao = new HibernateUtil();
		List<Informacao> informacoes = null;
		try {
			EntityManager manager = sessao.getManager();
			informacoes = manager.createNamedQuery("Usuario.getList",Informacao.class).setParameter("setor",cod).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao localizar lista pelo codigo (informacao)...");
		}finally{
			sessao.close();
		}
		return informacoes;
	}

	@Override
	public List<Informacao> findByObj(Informacao t) throws ExceptionDAO {
		
		return null;
	}

	@Override
	public List<Informacao> findByCod(Long cod) throws ExceptionDAO {
		return null;
	}

	public Informacao findByOneCod(Long cod) throws ExceptionDAO{
		HibernateUtil sessao = new HibernateUtil();
		try {
			EntityManager manager = sessao.getManager();
			return manager.createNamedQuery("Informacao.getDetalhe",Informacao.class).setParameter("id", cod).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao procurar informacao...");
		}finally{
			sessao.close();
		}
		
	}
	
}
