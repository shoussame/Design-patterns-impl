package com.dice.utilities.strategie;

import java.util.Observable;

import com.dice.entities.Dice;
import com.dice.entities.HighScore;
import com.dice.entities.Joueur;
import com.dice.persist.IPersistKit;
import com.dice.utilities.memento.DiceCareTaker;

public class StrategieOneDice extends Observable implements IStrategieDice {
	private StrategieOneDice() {
	}

	private static StrategieOneDice INSTANCE = new StrategieOneDice();

	public static StrategieOneDice getInstance() {
		if (INSTANCE == null) {

			INSTANCE = new StrategieOneDice();

		}
		return INSTANCE;
	}

	@Override
	public void play(Joueur joueur, IPersistKit persist) {

		System.out.println("Welcome " + joueur.getNom());
		System.out.println("-------- Stratégie un seul dé -----------");
		this.addObserver(joueur);
		Dice d1 = Dice.getInstance();
		DiceCareTaker c1 = new DiceCareTaker();

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("-------- Lancer numero " + i + "-----------");

			d1.roll();
			c1.SaveMemento(d1.CreateMemento());
			int nb1 = d1.getFaceValue();
			System.out.print("--Face Value du premier lancé  :  " + nb1 + "\n");
			d1.undo(d1);
			d1.roll();
			c1.SaveMemento(d1.CreateMemento());
			int nb2 = d1.getFaceValue();
			System.out.println("--Face Value du deuxieme lancé :  " + nb2);
			System.out.println("Resultat :  " + (nb1 + nb2) + "\n");

			if (nb1 + nb2 == 7) {
				this.setChanged();
				this.notifyObservers(10);
			}

		}
		System.out.println("-------- Votre score est :  " + joueur.getScore());

		HighScore hs = new HighScore(joueur.getNom(), joueur.getScore());
		persist.add(hs);

	}

}
