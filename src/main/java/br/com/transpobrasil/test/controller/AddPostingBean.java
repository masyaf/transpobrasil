package br.com.transpobrasil.test.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.com.transpobrasil.test.model.Item;
import br.com.transpobrasil.test.model.Posting;
import br.com.transpobrasil.test.service.IITemService;
import br.com.transpobrasil.test.service.IPostingService;
import br.com.transpobrasil.test.util.jsf.FacesUtil;

@Named
@ViewScoped
public class AddPostingBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Posting posting;
	private Item selectedItem;
	private List<Item> allItems;
	private List<Posting> allPostings;

	@Inject
	private IPostingService postingService;
	@Inject
	private IITemService iiTemService;

	public AddPostingBean() {
		posting = new Posting();
		allItems = new ArrayList<>();
	}

	public void initializerItems() {
		allItems = iiTemService.all();
	}

	public void save() {
		postingService.save(posting);
		FacesUtil.addInfoMessage("Lançamento adicionado com sucesso!");
		clear();
	}

	public void addItem() {
		if (getPosting().getItems().contains(selectedItem)) {
			FacesUtil.addWarnMessage("Item já foi vinculado");
		} else {
			getPosting().addItem(selectedItem);
			selectedItem = new Item();
			totalValue();
		}

	}

	public void removeItem() {
		posting.removeItem(selectedItem);
		selectedItem = new Item();
		totalValue();

	}

	private void totalValue() {
		BigDecimal sum = posting.getItems().stream().map(item -> item.getValue()).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		posting.setAmount(sum);
	}

	private void clear() {
		posting = new Posting();
	}

	public boolean isEditing() {
		if (posting != null) {
			return posting.getCode() != null ? true : false;
		}
		return false;
	}

	public Posting getPosting() {
		if (posting == null) {
			posting = new Posting();
		}
		return posting;
	}

	public void setPosting(Posting posting) {
		this.posting = posting;
	}

	public Item getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(Item selectedItem) {
		this.selectedItem = selectedItem;
	}

	public List<Item> getAllItems() {
		return allItems;
	}

	public void setAllItems(List<Item> allItems) {
		this.allItems = allItems;
	}

	public List<Posting> getAllPostings() {
		return allPostings;
	}

	public void setAllPostings(List<Posting> allPostings) {
		this.allPostings = allPostings;
	}

}
