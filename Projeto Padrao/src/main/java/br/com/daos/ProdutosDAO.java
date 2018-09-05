package br.com.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import br.com.model.Produtos;


@Repository
@Transactional
public class ProdutosDAO {
	
	
	@PersistenceContext EntityManager manager;
	
	public void save(Produtos produtos){
		manager.persist(produtos);
	}
	
	
	
	
}
