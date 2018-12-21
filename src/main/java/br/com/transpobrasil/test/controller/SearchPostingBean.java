package br.com.transpobrasil.test.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;


import br.com.transpobrasil.test.model.Posting;
import br.com.transpobrasil.test.service.IPostingService;


@Named
@ViewScoped
public class SearchPostingBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Posting selectedPosting;
	private List<Posting> allPostings;
	@Inject
	private IPostingService postingService;
	
	public SearchPostingBean() {
		
	}
	@PostConstruct
	public void init() {
		allPostings = postingService.all();
	}
	public List<Posting> getAllPostings() {
		return allPostings;
	}
	public void setAllPostings(List<Posting> allPostings) {
		this.allPostings = allPostings;
	}
	public Posting getSelectedPosting() {
		return selectedPosting;
	}
	public void setSelectedPosting(Posting selectedPosting) {
		this.selectedPosting = selectedPosting;
	}
	
	
}
