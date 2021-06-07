package fr.umlv.shopping;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import fr.umlv.shopping.VideoGame.Console;

public class SaverLoader {
	static final String SEPARATOR = "#";
	static final String BOOK_TYPE = "B";
	static final String VIDEO_GAME_TYPE = "G";
	static final String PREPAID_TYPE = "P";
	
	public static void main(String[] args) throws IOException {
	    var sdb = new Book("S. de Beauvoir", "Mémoires d'une jeune fille rangée", 990);
	    System.out.println(sdb.toTextFormat());
	    // B#990#Mémoires d'une jeune fille rangée#S. de Beauvoir
	    var zelda = new VideoGame("The legend of Zelda", VideoGame.Console.WII, 4950);
	    System.out.println(zelda.toTextFormat());
	    // G#4950#The legend of Zelda#WII
	    var pp100 = new PrePaid(10000, 10);
	    System.out.println(pp100.toTextFormat());
	    // P#10000#10
	    
	    var list = List.of(sdb, zelda, pp100);

	    Path saveFilePath = Paths.get("/home/6ifo1/rrieutor/saveFile.txt") ; // nom du fichier de sauvegarde: "saveFile.txt"  
	    try(var writer = Files.newBufferedWriter(saveFilePath, 
	                                         StandardCharsets.UTF_8, 
	                                         StandardOpenOption.CREATE)) {
	      SaverLoader.saveInTextFormat(list, writer);
	      writer.close();
	    }
	    catch(IOException e) {
	    	throw e;
	    }
	    
	  }

	public static void saveInTextFormat(List<? extends Item> list, BufferedWriter writer) throws IOException{
		try {
			list.forEach(S -> {
				try {
					writer.write(S.toTextFormat() + ('\n'));	
				}
				catch(IOException e) {
					throw new UncheckedIOException(e);
				}
			});
		}
		catch(UncheckedIOException u) {
			throw u.getCause();
		}
	}
	
	public static List chargeInTextFormat(BufferedReader read) throws IOException {
		List<Item> liste = new ArrayList<>();
		String line;
		while((line = read.readLine())!= null) {
			String[] item = line.split(SaverLoader.SEPARATOR);
			switch(item[0]) {
			case SaverLoader.BOOK_TYPE : liste.add(new Book(item[3], item[2], Integer.parseInt(item[1])));
			case SaverLoader.PREPAID_TYPE : liste.add(new PrePaid(Integer.parseInt(item[1]), Integer.parseInt(item[1])));
			case SaverLoader.VIDEO_GAME_TYPE : liste.add(new VideoGame(item[2], Console.valueOf(item[3]), Integer.parseInt(item[1])));
			default:throw new IllegalArgumentException("type inconnu");
			}
			
		}
		return liste;
	}	
}
