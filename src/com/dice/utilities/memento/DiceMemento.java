package com.dice.utilities.memento;

public class DiceMemento {
	private int faceValue;

	public DiceMemento(int faceValue) {
		super();
		this.faceValue = faceValue;
	}

	public int getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}
}