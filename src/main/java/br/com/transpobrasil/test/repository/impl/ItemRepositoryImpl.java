package br.com.transpobrasil.test.repository.impl;

import br.com.transpobrasil.test.model.Item;
import br.com.transpobrasil.test.repository.IItemRepository;

public class ItemRepositoryImpl extends AbstractGenericRepository<Item, Long> implements IItemRepository {

	public ItemRepositoryImpl() {
		super(Item.class);
	
	}

	private static final long serialVersionUID = 1L;

}
