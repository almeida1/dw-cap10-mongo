package com.fatec.sigvs.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Produto {
	@Id
	private Long id;      
	private String descricao;
	private double custo;
	private int quantidade; //quantidade no estoque
	public Produto(Long id, String descricao, double custo, int quantidade) {
		this.id = id;
		this.descricao = descricao;
		this.custo = custo;
		this.quantidade = quantidade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getCusto() {
		return custo;
	}
	public void setCusto(double custo) {
		this.custo = custo;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", custo=" + custo + ", quantidade=" + quantidade +"]";
	}
}
