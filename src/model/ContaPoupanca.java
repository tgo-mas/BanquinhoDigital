package model;

public class ContaPoupanca extends Conta {

	private String senhaPoupanca;
	protected int chanceSenha = 3;
	
	public ContaPoupanca(Cliente cliente, int num, int agencia, String senha) {
		super(cliente, num, agencia);
		if(senhaPoupanca.length() == 4) {
			this.senhaPoupanca = senha;
		}else {
			throw new RuntimeException("A senha da conta poupança deve conter 4 dígitos.");
		}
	}
	
	public double sacar(double valor, String senha) {
		if(valor > 500) {
			throw new RuntimeException("O limite de saque para conta Poupança é de R$500,00");
		}else if(senha != this.senhaPoupanca) {
			this.chanceSenha--;
			throw new RuntimeException("Senha incorreta. Tentativas restantes: " + chanceSenha);
		}else {
			return this.sacar(valor);
		}
	}
}
