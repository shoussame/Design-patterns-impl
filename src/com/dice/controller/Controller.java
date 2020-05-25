package com.dice.controller;

import java.util.Collections;
import java.util.List;

import com.dice.entities.HighScore;
import com.dice.entities.Joueur;
import com.dice.persist.IPersistKit;
import com.dice.persist.dao.DaoHighScore;
import com.dice.persist.toFile.SaveToFile;
import com.dice.utilities.IO.Scaner;
import com.dice.utilities.strategie.IStrategieDice;
import com.dice.utilities.strategie.StrategieOneDice;
import com.dice.utilities.strategie.StrategieTwoDice;

public class Controller {
	private IStrategieDice is;
	private IPersistKit persist;
	Scaner scaner;
	public void start() {
		System.out.println("If u want to save to a file type 1, to save to JDBC type 2 : ");
		int choixx = Integer.parseInt(Scaner.getScaner().next());
		if(choixx == 1) persist = new SaveToFile();
		if(choixx == 2) persist = new DaoHighScore();		
		System.out.println("Please enter your name.");
		String nomJoueur = Scaner.getScaner().next();
		System.out.println("If you want to play with One dice press 1 for two dice press 2 :");
		Joueur joueur = new Joueur(nomJoueur,0);
		int choix = Integer.parseInt(Scaner.getScaner().next());
		if(choix == 1) {
			is = StrategieOneDice.getInstance();
			is.play(joueur,persist);
			
			System.out.println("Pour voir les scores appuiez sur 1 :");
			int o = Integer.parseInt(Scaner.getScaner().next());
			
			if(o == 1) {
				List<HighScore> l =	persist.lister();
				Collections.sort(l);
				l.forEach(s -> System.out.println(s.getNom()+" , "+s.getScore())); 
			}
		} else if (choix == 2) {
			is = StrategieTwoDice.getInstance();
			is.play(joueur,persist);
			
			System.out.println("Pour voir les scores appuiez sur 1 :");
			int o = Integer.parseInt(Scaner.getScaner().next());
			
			if(o == 1) {
				List<HighScore> l =	persist.lister();
				Collections.sort(l);
				l.forEach(s -> System.out.println(s.getNom()+" , "+s.getScore())); 
			}
		}
	}
	public Controller() {
		super();
		scaner = new Scaner();
	}
	
	
}
