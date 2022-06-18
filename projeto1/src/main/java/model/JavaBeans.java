package model;

public class JavaBeans {
	private int id;
	private int codigo;
	private String nome;
	private String categoria;
	private Float valor;
	private int quantidade;

	public JavaBeans() {
		super();
	}

	public JavaBeans(int id, int codigo, String nome, String categoria, Float valor, int quantidade) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.categoria = categoria;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setStrId(String id) {
		this.id = Integer.parseInt(id);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public void setStrCodigo(String codigo) {
		this.codigo = Integer.parseInt(codigo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}
	
	public void setStrValor(String valor) {
		this.valor = Float.parseFloat(valor);
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setStrQuantidade(String quantidade) {
		this.quantidade = Integer.parseInt(quantidade);
	}
	
	
}