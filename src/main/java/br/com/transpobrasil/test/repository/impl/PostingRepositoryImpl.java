package br.com.transpobrasil.test.repository.impl;

import br.com.transpobrasil.test.model.Posting;
import br.com.transpobrasil.test.repository.IPostingRepository;

public class PostingRepositoryImpl extends AbstractGenericRepository<Posting, Long> implements IPostingRepository {

	public PostingRepositoryImpl() {
		super(Posting.class);
	}

	private static final long serialVersionUID = 1L;

}
