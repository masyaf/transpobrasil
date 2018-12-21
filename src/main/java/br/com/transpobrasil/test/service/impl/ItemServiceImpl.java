package br.com.transpobrasil.test.service.impl;

import java.util.List;

import javax.inject.Inject;

import br.com.transpobrasil.test.model.Item;
import br.com.transpobrasil.test.repository.IItemRepository;
import br.com.transpobrasil.test.service.IITemService;

public class ItemServiceImpl implements IITemService {

	private static final long serialVersionUID = 1L;

	@Inject
	private IItemRepository itemRepository;

	@Override
	public void save(Item entity) {
		itemRepository.save(entity);

	}

	@Override
	public void update(Item entity) {
		itemRepository.update(entity);

	}

	@Override
	public void delete(Item t) {
		itemRepository.delete(t);
	}

	@Override
	public Item byCode(Long code) {

		return itemRepository.byCode(code);
	}

	@Override
	public List<Item> byName(String name) {

		return itemRepository.byName(name);
	}

	@Override
	public List<Item> all() {
		return itemRepository.all();
	}

}
