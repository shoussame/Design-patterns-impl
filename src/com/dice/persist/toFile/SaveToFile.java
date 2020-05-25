package com.dice.persist.toFile;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.dice.entities.HighScore;
import com.dice.persist.IPersistKit;

public class SaveToFile implements IPersistKit {
	List<HighScore> myList;
	
	public void add(HighScore hs) {
		this.myList.add(hs);
		try {
			this.sortie(this.myList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private List<HighScore> lectureFile(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();
		List<HighScore> hss = new ArrayList<HighScore>();
		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			stream.forEach(s -> {
				contentBuilder.append(s).append("\n");
				String[] l = s.split(" ,");
				hss.add(new HighScore((String) l[0], Integer.parseInt(l[1])));
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hss;
	}


	public void sortie(List<HighScore> liste) throws IOException {
		Path path = Paths.get("d:/temp/samplefile9.txt");
		liste.forEach(entry -> {
			String fileContent = entry.getNom() + " ," + entry.getScore() + "\n";
			 try {
				Files.write(path, fileContent.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}

	@Override
	public List<HighScore> lister() {
		return this.lectureFile("d:/temp/samplefile9.txt");
	}

	public SaveToFile() {
		super();
		this.myList = this.lister();
		
	}

}
