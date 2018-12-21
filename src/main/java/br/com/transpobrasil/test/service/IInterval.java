package br.com.transpobrasil.test.service;

import java.io.Serializable;

import br.com.transpobrasil.test.service.impl.Interval;

public interface IInterval extends Serializable{

	Boolean checkExistsIntersection(Interval interval, Interval anotherInterval);
}
