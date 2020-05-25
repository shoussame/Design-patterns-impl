package com.dice.persist.dao;

import java.util.List;

import com.dice.entities.HighScore;

public interface IDaoHighScore {
	public void AddHighScore(int id, String nom, int score);
	public List<HighScore> ListerUsers();
	
}
