package com.dice.persist.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dice.entities.HighScore;
import com.dice.persist.IPersistKit;
import com.dice.utilities.persistDao.DBInteraction;

public class DaoHighScore implements IPersistKit, IDaoHighScore{
	
	public void AddHighScore(int id, String nom, int score) {
		DBInteraction.connect();
		String sql = "insert into HighScore values ('"+id+"','"+nom+"','"+score+"')";
		DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		
	}
	public List<HighScore> ListerUsers() {
		List<HighScore> liste = new ArrayList<HighScore>();
		DBInteraction.connect();
		String sql = "select * from HighScore";
		ResultSet rs = DBInteraction.select(sql);
		try {
			while(rs.next()) {
				HighScore hs = new HighScore(rs.getInt(1),rs.getString(2),rs.getInt(3));
				liste.add(hs);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBInteraction.disconnect();
		return liste;
	}
	@Override
	public void add(HighScore hs) {
		DaoHighScore dhs = new DaoHighScore();
		dhs.AddHighScore(hs.getId(), hs.getNom(), hs.getScore());
	}
	@Override
	public List<HighScore> lister() {
		DaoHighScore dhs = new DaoHighScore();
		return dhs.ListerUsers();
	}
}
