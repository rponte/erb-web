package br.com.triadworks.erp.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.triadworks.erp.modelo.Usuario;
import br.com.triadworks.erp.util.JPAUtil;

public class UsuarioDao {

	public Usuario buscaPor(String login, String senha) {
		EntityManager manager = new JPAUtil().getEntityManager();
		try {
			return manager
					.createQuery(
							"select u from Usuario u "
									+ "where u.login = :login "
									+ "  and u.senha = :senha", Usuario.class)
					.setParameter("login", login)
					.setParameter("senha", senha)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			manager.close();
		}
	}

}
