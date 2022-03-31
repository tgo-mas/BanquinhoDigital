package model;

public class ContaCorrente extends Conta {

	private String senhaCorrente;
	protected int chanceSenha = 3;
	private CartaoCredito cartao;
	
	public ContaCorrente(Cliente cliente, int num, int agencia, String senha) {
		super(cliente, num, agencia);
		if(senha.length() == 8) {
			this.senhaCorrente = senha;
		}else{
			throw new RuntimeException("A senha da conta Corrente deve conter oito caracteres.");
		}
		this.extrato.add("Tipo de conta: Corrente\nNúmero da conta: " + this.num + "\nAgência: " + this.agencia);
	}
	
	public int getChances() {
		return this.chanceSenha;
	}
	
	public CartaoCredito getCartao() {
		return this.cartao;
	}
	
	public void mudarSenha(String senhaAntiga, String senhaNova) {
		if(senhaAntiga == this.senhaCorrente) {
			this.senhaCorrente = senhaNova;
		}else {
			chanceSenha--;
			if(chanceSenha == 0) {
				this.status = false;
				throw new RuntimeException("Tentativas de senha esgotadas. A conta foi bloqueada.");
			}
			throw new RuntimeException("Senha antiga incorreta.");
		}
	}
	
	public double sacar(double valor, String senha) {
		if(senha == this.senhaCorrente) {
			return this.sacar(valor);
		}else {
			chanceSenha--;
			throw new RuntimeException("Senha incorreta.");
		}
	}
	
	public void addCompraCartao(String senhaCartao, double valor, int prestacoes) {
		try {
			cartao.addCompra(senhaCartao, valor, prestacoes);
		}catch(RuntimeException e) {
			if(e.getMessage().equals("Senha incorreta.")) {
				this.chanceSenha--;
				throw new RuntimeException("Senha incorreta. Tentativas restantes: " + this.chanceSenha);
			}else {
				throw e;
			}
		}
	}
}
