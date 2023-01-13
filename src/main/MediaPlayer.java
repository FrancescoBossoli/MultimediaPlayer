package main;

import java.util.ArrayList;
import java.util.Scanner;
import elements.*;
import abstracts.*;


public class MediaPlayer {	
	
	private static ArrayList<MultimediaElement> list = new ArrayList<MultimediaElement>();
	String input = "";
	
	public static void main(String[] args) {
		mediaMenu();
	}
	
	

	public static void mediaMenu() {
		Scanner reader = new Scanner(System.in);
		System.out.println( "********************************\r\n"
						+ "*                              *\r\n"
						+ "*     Lettore Multimediale     *\r\n"
						+ "*                              *\r\n"
						+ "********************************");
		System.out.printf("*    Elementi in lista: %d/5    *%n", MediaPlayer.list.size());
		System.out.println("*                              *\r\n"
						+ "*  Comandi disponibili:        *\r\n"
						+ "*  1:Aggiungi Immagine         *\r\n"
						+ "*  2:Aggiungi Audio            *\r\n"
						+ "*  3:Aggiungi Video            *\r\n"
						+ "*  0:Mostra/Riproduci Elemento *\r\n"
						+ "*                              *\r\n"
						+ "********************************");
		int command = reader.nextInt();
		switch (command) {
		case 1:			
			addImage();
			break;

		
		}
		reader.close();
		
	}
	
	private static void addImage() {
		
		Scanner readImg = new Scanner(System.in);
		System.out.println("Inserisci il titolo dell'immagine");
		String title = readImg.nextLine();		
		Image img = new Image(title);
		
		if (title.length() == 0) {
			System.out.println("Inserire un titolo valido");
			addImage();
		} else {
		MediaPlayer.list.add(img);
		readImg.close();
		MediaPlayer.mediaMenu();
		}
		
	}
	
	
}
