package br.dftrans.wiki.beans;

import br.dftrans.wiki.utils.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		HibernateUtil x = new HibernateUtil();
		x.close();
	}
}
