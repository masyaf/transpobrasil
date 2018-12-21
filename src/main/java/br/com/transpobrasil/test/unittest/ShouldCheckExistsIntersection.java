package br.com.transpobrasil.test.unittest;

import org.junit.Assert;
import org.junit.Test;

import br.com.transpobrasil.test.service.impl.Interval;

public class ShouldCheckExistsIntersection {

	/**
	 * Deve verificar que há intervalo
	 */
	@Test
	public void shouldCheckExistsIntersection() {
		Boolean existsIntersection = false;
		Interval interval = new Interval(10, 25);
		Interval anotherInterval = new Interval(20, 30);
		Integer aux;

		if (interval.getNumberOne() > interval.getNumberTwo()) {
			aux = interval.getNumberOne();
			interval.setNumberOne(interval.getNumberTwo());
			interval.setNumberTwo(aux);
		}

		if (anotherInterval.getNumberOne() > anotherInterval.getNumberTwo()) {
			aux = anotherInterval.getNumberOne();
			anotherInterval.setNumberOne(interval.getNumberTwo());
			anotherInterval.setNumberTwo(aux);
		}

		if (anotherInterval.getNumberOne() >= interval.getNumberOne() &&
				anotherInterval.getNumberOne() <= interval.getNumberTwo() ||
				interval.getNumberOne() >= anotherInterval.getNumberOne() && 
				interval.getNumberOne() <= anotherInterval.getNumberTwo()) {
				existsIntersection = true;
			}
		
		Assert.assertEquals(true, existsIntersection);
	}
	/*
	 * Deve verificar que não há interseção
	 */
	
	@Test
	public void shouldCheckNonExistsIntersection() {
		Boolean existsIntersection = false;
		Interval interval = new Interval(55, 88);
		Interval anotherInterval = new Interval(12, 40);
		Integer aux;

		if (interval.getNumberOne() > interval.getNumberTwo()) {
			aux = interval.getNumberOne();
			interval.setNumberOne(interval.getNumberTwo());
			interval.setNumberTwo(aux);
		}

		if (anotherInterval.getNumberOne() > anotherInterval.getNumberTwo()) {
			aux = anotherInterval.getNumberOne();
			anotherInterval.setNumberOne(interval.getNumberTwo());
			anotherInterval.setNumberTwo(aux);
		}
		
		if (anotherInterval.getNumberOne() >= interval.getNumberOne() &&
			anotherInterval.getNumberOne() <= interval.getNumberTwo() ||
			interval.getNumberOne() >= anotherInterval.getNumberOne() && 
			interval.getNumberOne() <= anotherInterval.getNumberTwo()) {
			existsIntersection = true;
		}
		
		Assert.assertEquals(false, existsIntersection);
	}

}