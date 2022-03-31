package model;

import java.util.List;

public class Cliente {
	
	private static final int CPF = 11, CNPJ = 14;
	private static enum TipoPessoa{FISICA, JURIDICA};
	
	protected final String docId;
	public String nome;
	protected List<Endereco> enderecos;
	protected int telefone;
	public TipoPessoa tipo;
	
	public Cliente(String docId, String nome, List<Endereco> enderecos, int telefone) {
		
		if(docId == null || docId.isEmpty()) {
			throw new RuntimeException("Documento vazio, operação não realizada.");
		}
		
		this.docId = docId;
		this.nome = nome;
		this.enderecos = enderecos;
		this.telefone = telefone;
		
		if(docId.length() == CPF) {
			this.tipo = TipoPessoa.FISICA;
		}else if(docId.length() == CNPJ) {
			this.tipo = TipoPessoa.JURIDICA;
		}else {
			throw new RuntimeException("Tamanho do documento inválido, operação não realizada.");
		}
	}
	
	public String getDocId() {
		return docId;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Endereco getEndereco(Endereco.TipoEndereco tipo) {
		for(int i = 0; i< enderecos.size(); i++) {
			if(enderecos.get(i).getTipo() == tipo) {
				return enderecos.get(i);
			}
		}
		throw new RuntimeException("Não há endereço deste tipo para esta conta.");
	}
	
	public void setEndereco(Endereco.TipoEndereco tipo, Endereco endereco) {
		for(int i = 0; i < enderecos.size(); i++) {
			if(enderecos.get(i).getTipo() == tipo) {
				enderecos.remove(i);
				enderecos.add(endereco);
				return;
			}
		}
	}
	
	public void setEndereco(Endereco endereco) {
		enderecos.clear();
		enderecos.add(endereco);
	}
	
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public int getTelefone() {
		return telefone;
	}
	
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
}
