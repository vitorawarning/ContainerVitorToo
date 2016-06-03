package br.dftrans.wiki.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.sun.xml.internal.stream.Entity;

import br.dftrans.wiki.domain.Arquivo;
import br.dftrans.wiki.exceptions.ExceptionDAO;
import br.dftrans.wiki.utils.HibernateUtil;

public class ArquivoDAO implements DAO<Arquivo>{

	@Override
	public void save(Arquivo t) {
		HibernateUtil sessao = new HibernateUtil();
		try {
			EntityManager manager = sessao.getManager();
			manager.getTransaction().begin();
			manager.persist(t);
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao salvar arquivo...");
		}finally {
			sessao.close();
		}
	}

	@Override
	public List<Arquivo> getAll() throws ExceptionDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Arquivo findByChave(String chave) throws ExceptionDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Arquivo t) throws ExceptionDAO {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Arquivo t) throws ExceptionDAO {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Arquivo> findByCod(Long cod) throws ExceptionDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Arquivo> findByObj(Arquivo t) throws ExceptionDAO {
		// TODO Auto-generated method stub
		return null;
	}


	

}
