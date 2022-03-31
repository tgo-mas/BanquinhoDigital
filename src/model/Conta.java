package model;

import java.util.ArrayList;
import java.util.List;

public class Conta {

	public Cliente cliente;
	public int num;
	public int agencia;
	private double saldo;
	protected List<String> extrato;
	public boolean status;
	
	public Conta(Cliente cliente, int num, int agencia) {
		this.cliente = cliente;
		this.num = num;
		this.agencia = agencia;
		this.saldo = 0.0;
		this.status = false; //a conta inicia-se sendo bloqueada. a ativação é feita no primeiro depósito.
		this.extrato = new ArrayList<String>();
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public int getNum() {
		return num;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public double depositar(double valor) {
		this.status = true;
		this.saldo += valor;
		this.extrato.add("Depósito: R$" + valor);
		return this.saldo;
	}
	
	public double sacar(double valor) {
		if(saldo >= valor) {
			this.saldo -= valor;
			this.extrato.add("Saque: R$" + valor);
			return saldo;
		}else {
			throw new RuntimeException("Saldo insuficiente.");
		}
	}
	
	public String getExtrato() {
		String extratoFinal = "";
		for(int i = 0; i < extrato.size(); i++) {
			extratoFinal += extrato.get(i) + "\n";
		}
		extratoFinal += "Saldo atual: R$" + saldo;
		return extratoFinal;
	}
	
}
