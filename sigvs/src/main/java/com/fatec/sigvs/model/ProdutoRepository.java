package com.fatec.sigvs.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface ProdutoRepository extends MongoRepository<Produto,Long> {
	@Query("{descricao:'?0'}")
	Produto findByDescricao (String descricao);
	public long count();
}
