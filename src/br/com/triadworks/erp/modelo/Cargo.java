package br.com.triadworks.erp.modelo;

public enum Cargo {

	DBA("DBA"),
	DESENVOLVEDOR("Desenvolvedor"),
	ANALISTA_DE_SISTEMAS("Analista de Sistemas"),
	GERENTE_DE_PROJETOS("Gerente de Projetos");
	
	private String descricao;

	private Cargo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
