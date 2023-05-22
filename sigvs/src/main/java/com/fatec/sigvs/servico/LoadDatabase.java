package com.fatec.sigvs.servico;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fatec.sigvs.model.Produto;
import com.fatec.sigvs.model.ProdutoRepository;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	@Autowired
	IMantemProduto mantemProduto;

	@Bean
	CommandLineRunner initDatabase(ProdutoRepository repository) {

		return args -> {
			repository.save(new Produto(1L, "Tomada Eletrica", 20, 200));
			repository.save(new Produto(2L,"Resistencia Lorenzetti",44.50,150));
			repository.save(new Produto(3L,"Disjuntores Bipolar",44.90,350));
			repository.findAll().forEach(item -> System.out.println(item));
			System.out.println("Quantidade de produtos no estoque => " + repository.count());
			repository.deleteById(1L);
			System.out.println("Quantidade de produtos no estoque => " + repository.count());
			repository.findAll().forEach(item -> System.out.println(item));
			Produto p = repository.findByDescricao("Resistencia Lorenzetti");
			
			mantemProduto.updateItemQuantity("Resistencia Lorenzetti", 50f);
			repository.findAll().forEach(item -> System.out.println(item));
			log.info (">>>>> tabelas carregadas");
		};
	}
}
