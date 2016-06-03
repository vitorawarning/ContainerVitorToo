package br.dftrans.wiki.exceptions;

public class ExceptionDAO extends RuntimeException{
	private String msg;

	public ExceptionDAO(String msg) {
		super(msg);
		setMsg(msg);
	}
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
