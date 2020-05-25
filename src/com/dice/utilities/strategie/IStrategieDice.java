package com.dice.utilities.strategie;

import com.dice.entities.Joueur;
import com.dice.persist.IPersistKit;

public interface IStrategieDice {
	public void play(Joueur joueur, IPersistKit persist);
}
