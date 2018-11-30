package model;

public class Despesa {
	private float valor;
	private String data;
	private String descricao;
	private int parcela;
	
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
	public int getParcela() {
		return parcela;
	}
	public void setParcela(int parcela) {
		this.parcela = parcela;
	}
}
