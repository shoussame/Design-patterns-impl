package com.dice.utilities.strategie;

import java.util.Observable;

import com.dice.entities.Dice;
import com.dice.entities.HighScore;
import com.dice.entities.Joueur;
import com.dice.persist.IPersistKit;
import com.dice.utilities.memento.DiceCareTaker;

public class StrategieTwoDice extends Observable implements IStrategieDice {
	private StrategieTwoDice() {
	}

	private static StrategieTwoDice INSTANCE = new StrategieTwoDice();

	public static StrategieTwoDice getInstance() {
		if (INSTANCE == null) {

			INSTANCE = new StrategieTwoDice();

		}
		return INSTANCE;
	}
	@Override
	public void play(Joueur joueur, IPersistKit persist) {
		
		System.out.println("Welcome " + joueur.getNom());
		System.out.println("-------- Stratégie deux dés -----------");
		this.addObserver(joueur);
		Dice d1 = Dice.getInstance();
		Dice d2 = Dice.getInstance();	
		DiceCareTaker c1 = new DiceCareTaker();
		DiceCareTaker c2 = new DiceCareTaker();
		
		for(int i =0; i<10 ; i++) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("-------- Lancer numero "+ i +"-----------");
				
				d1.roll();				
				c1.SaveMemento(d1.CreateMemento());
				int nb1 = d1.getFaceValue();
				System.out.print("--Face Value Dice 1 :  "+ nb1 +"\n");
				
				d2.roll();				
				c2.SaveMemento(d1.CreateMemento());
				int nb2 = d2.getFaceValue();
				System.out.println("--Face Value Dice 2 :  "+ nb2 );
				System.out.println("Resultat :  "+ (nb1 + nb2) +"\n");
				if(nb1 + nb2 == 7) {
					this.setChanged();
					this.notifyObservers(10);
				}
				
			
			
		}
		System.out.println("-------- Votre score est :  "+ joueur.getScore() );
		
		HighScore hs = new HighScore(joueur.getNom(),joueur.getScore());
		persist.add(hs);
		
		
	}

}
