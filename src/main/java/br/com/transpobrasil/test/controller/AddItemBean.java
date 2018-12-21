package br.com.transpobrasil.test.controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.com.transpobrasil.test.model.Item;
import br.com.transpobrasil.test.service.IITemService;
import br.com.transpobrasil.test.util.jsf.FacesUtil;

/**
* @author rmpestano
*/
@Named
@ViewScoped
public class AddItemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Item item;
	private Item selectedItem;
	private List<Item> items;
	@Inject
	private  IITemService itemService;
	
	public AddItemBean(){
		items = new ArrayList<>();
		item = new Item();
	}
	
	public void save() {
		itemService.save(item);
		FacesUtil.addInfoMessage("Item cadastrado com sucesso!");
		clear();
		initializerItems();
	}


	private void clear() {
		item = new Item();
	}
	
	public void initializerItems() {
		items = itemService.all();
	}
	public void remove() {
		itemService.delete(selectedItem);
		items.remove(selectedItem);
		selectedItem = new Item();
	}
  

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(Item selectedItem) {
		this.selectedItem = selectedItem;
	}
	

}
