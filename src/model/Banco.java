package model;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private List<Conta> contas;
	private List<Cliente> clientes;
	
	public Banco(List<Conta> contas, List<Cliente> clientes) {
		this.contas = contas;
		this.clientes = clientes;
	}
	
	public Banco() {
		this.contas = new ArrayList<Conta>();
		this.clientes = new ArrayList<Cliente>();
		
	}
	
	public List<Conta> getContas(){
		return this.contas;
	}
	
	public List<Cliente> getClientes(){
		return this.clientes;
	}
	
	public void aberturaConta(Conta conta) {
		for(int i = 0; i < contas.size(); i++) {
			if(contas.get(i).num == conta.num && contas.get(i).agencia == conta.agencia) {
				throw new RuntimeException("Já existe uma conta com este número nesta agência.");
			}
		}
		this.contas.add(conta);
	}
	
	
	public void cadastroCliente(Cliente cliente) {
		for(int i = 0; i < clientes.size(); i++) {
			if(this.clientes.get(i).docId == cliente.docId) {
				throw new RuntimeException("Cliente já cadastrado.");
			}
		}
		this.clientes.add(cliente);
	}
	
	public void transferir(double valor, Conta origem, Conta destino) {
		if(origem.getSaldo() >= valor) {
			origem.sacar(valor);
			destino.depositar(valor);
			origem.extrato.add("Transferência: R$" + valor + "\n   para: " + destino.agencia + " " + destino.num);
		}else {
			throw new RuntimeException("Saldo insuficiente.");
		}
	}
}
