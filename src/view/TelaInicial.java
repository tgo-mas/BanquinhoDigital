package view;

import java.util.ArrayList;
import java.util.List;

import model.Banco;
import model.Cliente;
import model.ContaCorrente;
import model.Endereco;

public class TelaInicial{

	public static void main(String[] args) {
		
		Endereco end = new Endereco("Nilton Ginane", 45, "Centro", "Caicó", "RN");
		List<Endereco> enderecos = new ArrayList<Endereco>(List.of(end));
		
		Cliente jose = new Cliente("23565865256", "José", enderecos, 235612456);
		
		ContaCorrente acc1 = new ContaCorrente(jose, 1001, 1, "AS456132");
		
		Banco banco = new Banco();
		
		banco.cadastroCliente(jose);
		banco.aberturaConta(acc1);
		
		acc1.depositar(500);
		acc1.sacar(400);
		acc1.depositar(250);
		try {
			acc1.sacar(600);
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(acc1.getExtrato());
		
		
	}
	
}
