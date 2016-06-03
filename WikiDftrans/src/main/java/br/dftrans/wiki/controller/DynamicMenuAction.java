package br.dftrans.wiki.controller;


import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import br.dftrans.wiki.dao.SetorDAO;
import br.dftrans.wiki.domain.Setor;


@ViewScoped
@ManagedBean(name="MB_Menu")
public class DynamicMenuAction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MenuModel menuModel;

	public DynamicMenuAction() {
		setMenuModel(new DefaultMenuModel());
		SetorDAO dao = new SetorDAO();
		List<Setor> setores = dao.getAll();
		//primeiro submenu
		DefaultSubMenu subMenu = new DefaultSubMenu("Setor");
		for (Setor setor : setores) {
			DefaultMenuItem item = new DefaultMenuItem(setor.getSetor());
			item.setParam("idMenu", setor.getId());
			item.setCommand("#{MB_Listagem.listagemInformacoes}");
			item.setUpdate("frmInformacaoListagem");
			subMenu.addElement(item);
		}
		getMenuModel().addElement(subMenu);
	}

	//getteres and setteres
	public MenuModel getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}
}
