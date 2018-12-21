package br.com.transpobrasil.test.service.impl;

import br.com.transpobrasil.test.service.IInterval;

public class IntervalServiceImpl implements IInterval {

	private static final long serialVersionUID = 1L;
	private Integer aux;

	@Override
	public Boolean checkExistsIntersection(Interval interval, Interval anotherInterval) {
		numberOneGreaterThanNumberTwo(interval);
		numberOneGreaterThanNumberTwo(anotherInterval);
		return check(interval, anotherInterval);
	}

	private void numberOneGreaterThanNumberTwo(Interval someInterval) {
		if (someInterval.getNumberOne() > someInterval.getNumberTwo()) {
			aux = someInterval.getNumberOne();
			someInterval.setNumberOne(someInterval.getNumberTwo());
			someInterval.setNumberTwo(aux);
		}
	}

	private Boolean check(Interval interval, Interval anotherInterval) {
		if (anotherInterval.getNumberOne() >= interval.getNumberOne()
				&& anotherInterval.getNumberOne() <= interval.getNumberTwo()
				|| interval.getNumberOne() >= anotherInterval.getNumberOne()
						&& interval.getNumberOne() <= anotherInterval.getNumberTwo()) {
			return true;
		} else {
			return false;
		}
	}

}
