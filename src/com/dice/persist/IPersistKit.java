package com.dice.persist;

import java.util.List;

import com.dice.entities.HighScore;

public interface IPersistKit {
	public void add(HighScore hs);
	public List<HighScore> lister();
}
