package com.fatec.sigvs.servico;


import java.util.List;

import com.fatec.sigvs.model.Produto;
public interface IMantemProduto {
	List<Produto> consultaTodos();
	void delete (Long id);
	void updateItemQuantity(String itemName, float newQuantity);
}

