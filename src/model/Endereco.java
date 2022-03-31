package model;

public class Endereco {
	
	protected static enum TipoEndereco{FATURA, ENTREGA, MORADIA, ALL};
	
	private String rua;
	private int num;
	private String bairro;
	private String cidade;
	private String estado;
	private int cep;
	private TipoEndereco tipo;
	
	public Endereco(String rua, int num, String bairro, String cidade, String estado, int cep, String tipo) {
		this.rua = rua;
		this.num = num;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		
		switch(tipo) {
		case "fatura":
			this.tipo = TipoEndereco.FATURA;
			break;
		case "entrega":
			this.tipo = TipoEndereco.ENTREGA;
			break;
		case "moradia":
			this.tipo = TipoEndereco.MORADIA;
			break;
		default:
			throw new RuntimeException("Tipo de endereço inválido.");
		}
	}
	
	public Endereco(String rua, int num, String bairro, String cidade, String estado) {
		this.rua = rua;
		this.num = num;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.tipo = TipoEndereco.ALL;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public TipoEndereco getTipo() {
		return tipo;
	}

	public void setTipo(TipoEndereco tipo) {
		this.tipo = tipo;
	}
	
	public String getFullAddress() {
		return new String(rua + ", " + num + ", " + bairro + ". " + cidade + " - " + estado);
	}
	
}
