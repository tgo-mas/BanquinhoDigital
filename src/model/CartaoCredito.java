package model;

public class CartaoCredito {

	private String senha;
	protected double limite;
	protected double fatura;
	protected double faturaAcumulada;
	
	public CartaoCredito(String senha, double limite) {
		if(senha.length() == 6) {
			this.senha = senha;
		}else {
			throw new RuntimeException("A senha do cartão de crédito deve ter 6 dígitos.");
		}
		if(limite > 400) {
			throw new RuntimeException("O limite máximo inicial é de R$400,00");
		}else {
			this.limite = limite;
		}
	}
	
	protected double getLimite() {
		return this.limite;
	}
	
	protected void alterarLimite(double novoLimite) {
		if(novoLimite <= limite) {
			limite = novoLimite;
		}else if(novoLimite > limite && faturaAcumulada <= limite) {
			limite = novoLimite;
		}else {
			throw new RuntimeException("As faturas acumuladas excedem o limite. Operação não realizada.");
		}
	}
	
	public void addCompra(String senha, double valor, int prestacoes) {
		if(senha == this.senha) {	
			if(this.getLimiteDisponivel() < valor) {
				throw new RuntimeException("Limite do cartão excedido.");
			}else {
				fatura += valor / prestacoes;
				faturaAcumulada += valor;
			}
		}else {
			throw new RuntimeException("Senha incorreta.");
		}
	}
	
	public double getLimiteDisponivel() {
		return limite - faturaAcumulada;
	}
	
	public double getFatura() {
		return this.fatura;
	}
	
	public double getFaturaAcumulada() {
		return this.faturaAcumulada;
	}
	
	public double pagarFatura(double valor) {
		if(valor > fatura) {
			faturaAcumulada -= fatura; 
			double troco = valor - fatura;
			fatura = 0;
			return troco;
		}else {
			fatura -= valor;
			faturaAcumulada -= valor;
			return 0;
		}
	}
}
