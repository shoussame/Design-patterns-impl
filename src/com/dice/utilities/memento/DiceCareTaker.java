package com.dice.utilities.memento;

public class DiceCareTaker {
	private DiceMemento dice;

	public void SaveMemento(DiceMemento dice) {
		this.dice = dice;
	}

	public DiceMemento RetrieveMemento() {
		return dice;
	}
}
