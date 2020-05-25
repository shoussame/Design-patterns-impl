package com.dice.entities;

import java.util.Observable;
import java.util.Observer;


public class Joueur implements Observer{
	private String nom;
	private int score;
	public Joueur() {
		super();
	}
	public Joueur( String nom, int score) {
		super();
		this.nom = nom;
		this.score = score;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		int n = (int) arg;
		this.score += n;		
	}
	
}
