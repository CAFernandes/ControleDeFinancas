package model;

public class Renda {
	private float valor;
	private String descricao;
	private String data;
	
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		if(valor <= 0) {
			System.err.println("Valor inválido");
		}else {
			this.valor = valor;	
		}
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
