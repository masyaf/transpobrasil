package br.com.transpobrasil.test.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.transpobrasil.test.service.IInterval;
import br.com.transpobrasil.test.service.impl.Interval;
import br.com.transpobrasil.test.util.jsf.FacesUtil;

@Named
@RequestScoped
public class IntersectionTesterBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Interval interval;
	private Interval anotherInterval;
	@Inject
	private IInterval intervalService;

	public IntersectionTesterBean() {
		clear();
	}

	public void checksIntersection() {
		if (intervalService.checkExistsIntersection(interval, anotherInterval)) {
			FacesUtil.addInfoMessage("Existe interseção entre as faixas 1 e 2");
		} else {
			FacesUtil.addWarnMessage("Não há interseção entre as faixas 1 e 2");
		}
		clear();

	}

	private void clear() {
		interval = new Interval();
		anotherInterval = new Interval();
	}

	public Interval getInterval() {
		return interval;
	}

	public void setInterval(Interval interval) {
		this.interval = interval;
	}

	public Interval getAnotherInterval() {
		return anotherInterval;
	}

	public void setAnotherInterval(Interval anotherInterval) {
		this.anotherInterval = anotherInterval;
	}

}
