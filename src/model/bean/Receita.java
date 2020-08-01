package model.bean;

public class Receita {
	private float valor;
	private int mes;
	private int ano;
	private String descricao;
	
	public Receita() {
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getMes() {
		return this.mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(String a) {
		a = a.replace(",", ".");
		this.valor = Float.parseFloat(a);
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

}
