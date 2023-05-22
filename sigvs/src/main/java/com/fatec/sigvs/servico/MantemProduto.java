package com.fatec.sigvs.servico;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.fatec.sigvs.model.Produto;
import com.fatec.sigvs.model.ProdutoRepository;
import com.mongodb.client.result.UpdateResult;

@Service
public class MantemProduto implements IMantemProduto{
	//mongoTemplate API para acesso ao motor de persistencia
	//mongoRepository mais flexivel e permite operacoes mais complexas
	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	ProdutoRepository repository;
	@Override
	public void updateItemQuantity(String descricao, float novaQuantidade) {
		Query query = new Query(Criteria.where("descricao").is(descricao));
		Update update = new Update();
		update.set("quantidade", novaQuantidade);
		//updatefirst atualiza o primeiro documento que atende a condição da query
		UpdateResult result = mongoTemplate.updateFirst(query, update, Produto.class);
		
		if(result == null)
			System.out.println("Nenhum documento atualizado");
		else
			System.out.println(result.getModifiedCount() + " documento(s) atualizados..");
	}
	@Override
	public List<Produto> consultaTodos() {
		return repository.findAll();
	}
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
