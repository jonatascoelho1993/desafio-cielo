package br.com.bootcampcieloada.enums;

public enum TipoPessoa {

	PESSOA_FISICA("PF"), PESSOA_JURIDICA("PJ");

	private String codigo;

	TipoPessoa(String codigo) {
		this.codigo = codigo;
	}

	public static TipoPessoa getEnum(String codigo) {
		TipoPessoa[] tipos = TipoPessoa.values();
		for (int i = 0; i < tipos.length; i++) {
			if (tipos[i].codigo == codigo) {
				return tipos[i];
			}
		}
		return null;
	}

}
