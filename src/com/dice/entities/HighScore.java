package com.dice.entities;


public class HighScore implements Comparable<HighScore> {
	private int id;
	private String nom;
	private int score;
	private static int count = 10;
	public HighScore() {
		super();
	}
	
	public HighScore(String nom, int score) {
		super();
		this.id = HighScore.count;
		this.nom = nom;
		this.score = score;
		HighScore.count++;
	}
	
	
	public HighScore(int id, String nom, int score) {
		super();
		this.id = id;
		this.nom = nom;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public int compareTo(HighScore o) {
		return o.getScore() - this.score;		
	}
	

	
}
