package br.dftrans.wiki.dao;
import java.util.List;
import javax.persistence.EntityManager;
import br.dftrans.wiki.domain.Setor;
import br.dftrans.wiki.exceptions.ExceptionDAO;
import br.dftrans.wiki.utils.HibernateUtil;

public class SetorDAO implements DAO<Setor>{
	
	public void save (Setor setor){
		HibernateUtil sessao = new HibernateUtil();
		try {
			EntityManager manager = sessao.getManager();
			manager.getTransaction().begin();
			manager.persist(setor);
			manager.getTransaction().commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao salvar dados");
		}finally {
			sessao.close();
		}
	}

	@Override
	public List<Setor> getAll() {
		List<Setor> setores = null;
		HibernateUtil sessao = new HibernateUtil();
		try {
			EntityManager manager = sessao.getManager();
			setores = manager.createNamedQuery("Setor.listar",Setor.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao pegar todos do database");
		}finally {
			
			sessao.close();
		}
		return setores;
	}

	@Override
	public Setor findByChave(String chave) throws ExceptionDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Setor t) throws ExceptionDAO {
		HibernateUtil sessao = new HibernateUtil();
		EntityManager manager = sessao.getManager();
		boolean flag = false;
		try {
			manager.getTransaction().begin();
			manager.remove(manager.contains(t) ? t : manager.merge(t));
			manager.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao excluir setor...");
		}finally {
			sessao.close();
		}
		return flag;
	}

	@Override
	public boolean update(Setor t) throws ExceptionDAO {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Setor> findByCod(Long cod) throws ExceptionDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Setor> findByObj(Setor t) throws ExceptionDAO {
		// TODO Auto-generated method stub
		return null;
	}

	public Setor findBy(Long id) throws ExceptionDAO{
		HibernateUtil sessao = new HibernateUtil();
		try {
			EntityManager manager = sessao.getManager();
			return manager.createNamedQuery("Setor.getByCod",Setor.class).setParameter("id",id).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao localizar setor por codigo...");
		}finally {
			sessao.close();
		}
	}



}
