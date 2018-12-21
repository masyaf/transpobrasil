package br.com.transpobrasil.test.service.impl;

public class Interval{

	private Integer numberOne;
	private Integer numberTwo;

	public Interval() {
	}

	public Integer getNumberOne() {
		return numberOne;
	}

	public Interval(Integer numberOne, Integer numberTwo) {
		this.numberOne = numberOne;
		this.numberTwo = numberTwo;
	}

	public void setNumberOne(Integer numberOne) {
		this.numberOne = numberOne;
	}

	public Integer getNumberTwo() {
		return numberTwo;
	}

	public void setNumberTwo(Integer numberTwo) {
		this.numberTwo = numberTwo;
	}

}
