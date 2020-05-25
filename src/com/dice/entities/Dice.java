package com.dice.entities;

import com.dice.utilities.Randomize;
import com.dice.utilities.memento.DiceMemento;

public class Dice {
	private int faceValue;
	DiceMemento diceMemento; 
	private Dice() {
	}

	private static Dice INSTANCE = new Dice();

	public static Dice getInstance() {
		if (INSTANCE == null) {

			INSTANCE = new Dice();

		}
		return INSTANCE;
	}
	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
		} 
	
	public int getFaceValue() {
		return faceValue;
	}

	public DiceMemento CreateMemento() {
		diceMemento = new DiceMemento(faceValue);
		return diceMemento;
		} 
	public void undo(Dice dice) {
		faceValue = diceMemento.getFaceValue();
		} 
	
	public void roll() {
		this.setFaceValue(Randomize.getNumber());		
	}
}

