package br.com.transpobrasil.test.service.impl;

import java.util.List;

import javax.inject.Inject;

import br.com.transpobrasil.test.model.Posting;
import br.com.transpobrasil.test.repository.IPostingRepository;
import br.com.transpobrasil.test.service.IPostingService;

public class PostingServiceImpl implements IPostingService {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPostingRepository postingRepository;
	
	@Override
	public void save(Posting entity) {
		postingRepository.save(entity);
		
	}

	@Override
	public void update(Posting entity) {
		postingRepository.update(entity);
		
	}

	@Override
	public void delete(Posting entity) {
		postingRepository.delete(entity);
		
	}

	@Override
	public Posting byCode(Long code) {
		return postingRepository.byCode(code);
	}

	@Override
	public List<Posting> byName(String name) {
		return postingRepository.byName(name);
	}

	@Override
	public List<Posting> all() {
		return postingRepository.all();
	}

}
