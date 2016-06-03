package br.dftrans.wiki.enuns;

public enum TipoAcesso {
	ADMINISTRADOR(1),USUARIO(2);
	private int tipo;

	private TipoAcesso(int tipo) {
		setTipo(tipo);
	}

	public static TipoAcesso converterIntByEnun(int valor){
		for (TipoAcesso tmp : values()) {
			if(tmp.getTipo() == valor){
				return tmp;
			}
		}
		return null;
	}

	//getteres and setteres]
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
