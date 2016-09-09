package br.com.triadworks.erp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.triadworks.erp.modelo.Funcionario;
import br.com.triadworks.erp.util.JPAUtil;

public class FuncionarioDao {

	public List<Funcionario> lista() {
		EntityManager manager = new JPAUtil().getEntityManager();
		try {
			return manager.createQuery("select u from Funcionario u", Funcionario.class)
					.getResultList();
		} finally {
			manager.close();
		}
	}

	public void adiciona(Funcionario funcionario) {
		EntityManager manager = new JPAUtil().getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(funcionario);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			manager.close();
		}
	}

	public void atualiza(Funcionario funcionario) {
		EntityManager manager = new JPAUtil().getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(funcionario);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			manager.close();
		}
	}

	public void remove(Funcionario funcionario) {
		EntityManager manager = new JPAUtil().getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.remove(manager.merge(funcionario));
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
			manager.close();
		}
	}

	public Funcionario busca(Integer id) {
		EntityManager manager = new JPAUtil().getEntityManager();
		try {
			return manager.find(Funcionario.class, id);
		} finally {
			manager.close();
		}
	}

	public List<Funcionario> listaPaginada(int inicio, int quantidade) {
		EntityManager manager = new JPAUtil().getEntityManager();
		try {
			return manager
					.createQuery("select u from Funcionario u", Funcionario.class)
					.setFirstResult(inicio)
					.setMaxResults(quantidade)
					.getResultList();
		} finally {
			manager.close();
		}
	}

	public int contaTodos() {
		EntityManager manager = new JPAUtil().getEntityManager();
		try {
			Long count = manager
					.createQuery("select count(u) from Funcionario u", Long.class)
					.getSingleResult();
			return count.intValue();
		} finally {
			manager.close();
		}
	}

}
