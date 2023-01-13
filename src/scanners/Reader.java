package scanners;



import java.util.ArrayList;
import java.util.Scanner;
import elements.*;
import main.*;
import abstracts.*;

public class Reader {
	
	private static final String dangerText = "\u001B[31m";
	private static final String resetText = "\u001B[0m";
	
	//starter
	public static void mainMenu() {
		Scanner in = new Scanner(System.in);
		System.out.println("---------------------------------------");

		System.out.println(
				"Inserisci un nuovo Elemento Multimediale: \n" 
				+ "1. Inserisci Immagine \n" 
				+ "2. Inserisci Registrazione Audio \n"
				+ "3. Inserisci Video \n" 
				+ "0. Mostra/Riproduci Elementi \n");

		int selection = in.nextInt();

		switch (selection) {
		case 1:
			addImage();
			break;
		case 2:
			addAudioRecording();
			break;
		case 3:
			addVideo();
			break;
		case 0:
			displayOptions();
			break;
		default:
			System.out.println(dangerText + "È stata selezionata un'opzione non valida" + resetText);
			System.out.println("---------------------------------------");
			mainMenu();
			break;
		}

		in.close();
	} 


	private static void addImage() {
		
		Scanner imageReader = new Scanner(System.in);
		System.out.println("Inserisci un titolo per l'immagine: ");
		String title = imageReader.nextLine();
		
		Image img = new Image(title);
		
		if(title.length() == 0) {
			System.out.println(dangerText + "Inserisci un titolo valido" + resetText);
			addImage();
		}
		
		addToList(MediaPlayer.media, img);
		
		System.out.println("--> Immagine inserita con successo: " + img);
		System.out.println("---------------------------------------");
		mainMenu();
		imageReader.close();
	}


	private static void addAudioRecording() {
		
		Scanner audioRecordingReader = new Scanner(System.in);
		
		System.out.println("Inserisci un titolo per la registrazione audio: ");
		String audioTitle = audioRecordingReader.nextLine();
		
		if(audioTitle.length() == 0) {
			System.out.println(dangerText + "Inserisci un titolo valido" + resetText);
			addAudioRecording();
		}
		
		System.out.println("Inserisci la durata dell'audio: ");
		int duration = audioRecordingReader.nextInt();
		
		AudioRecording aud = new AudioRecording(audioTitle, duration);
		addToList(MediaPlayer.media, aud);
		
		System.out.println("--> Registrazione Audio inserita con successo: " + aud);
		System.out.println("---------------------------------------");
		mainMenu();
		
		audioRecordingReader.close();
	}


	private static void addVideo() {

		Scanner videoReader = new Scanner(System.in);

		System.out.println("Inserisci un titolo per il video: ");
		String vidTitle = videoReader.nextLine();
		
		if(vidTitle.length() == 0) {
			System.out.println(dangerText + "Inserisci un titolo valido" + resetText);
			addVideo();
		}

		System.out.println("Inserisci la durata del video: ");
		int duration = videoReader.nextInt();

		Video vid = new Video(vidTitle, duration);
		addToList(MediaPlayer.media, vid);

		System.out.println("--> Video inserito con successo: " + vid);
		System.out.println("---------------------------------------");
		mainMenu();

		videoReader.close();
	}


	private static void displayOptions() {
		
		ArrayList<MultimediaElement> medias = MediaPlayer.media;
		
		Scanner show = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.println("Quale elemento vuoi visualizzare/riprodurre?");
		
		int i = 1;
		for(MultimediaElement file : medias) {
			System.out.println(i + ". " + file.title);
			i++;
		}
		System.out.println("0. Torna indietro");
		
		int mediaNum = show.nextInt();
		
		switch(mediaNum) {
		case 1:
			MultimediaElement case1 = medias.get(0);
			
			if( case1 instanceof Video ) {
				menuVideo(case1);
			}else if(case1 instanceof AudioRecording){
				menuAudio(case1);
			}else {
				menuImage(case1);
			}
			break;
			
		case 2:
			MultimediaElement case2 = medias.get(1);

			if( case2 instanceof Video ) {
				menuVideo(case2);
			}else if(case2 instanceof AudioRecording){
				menuAudio(case2);
			}else {
				menuImage(case2);
			}
			break;
			
		case 3:
			MultimediaElement case3 = medias.get(2);

			if( case3 instanceof Video ) {
				menuVideo(case3);
			}else if(case3 instanceof AudioRecording){
				menuAudio(case3);
			}else {
				menuImage(case3);
			}
			break;
			
		case 4:
			MultimediaElement case4 = medias.get(3);

			if( case4 instanceof Video ) {
				menuVideo(case4);
			}else if(case4 instanceof AudioRecording){
				menuAudio(case4);
			}else {
				menuImage(case4);
			}
			break;
			
		case 5:
			MultimediaElement case5 = medias.get(4);

			if( case5 instanceof Video ) {
				menuVideo(case5);
			}else if(case5 instanceof AudioRecording){
				menuAudio(case5);
			}else {
				menuImage(case5);
			}
			break;
			
		case 0:
			mainMenu();
			break;
			
		default:
			System.out.println(dangerText + "Non è una scelta valida" + resetText);
			System.out.println("---------------------------------------");
			displayOptions();
			break;
		}
		
		show.close();
	}
	
	//actions for Image media
	private static void menuImage(MultimediaElement m) {
		Scanner imagePreference = new Scanner(System.in);
		
		System.out.println("---------------------------------------");
		
		System.out.println("-> " + m.title + " <-");
		
		System.out.println(
				"1. Aumenta la luminosità \n" + 
				"2. Diminuisci la luminosità \n" + 
				"3. Mostra \n" +
				"0. Torna alla lista");
		
		int selection = imagePreference.nextInt();
		switch(selection) {
		
		case 1: // Luminosità +
			((Image)m).brightnessUp();
			displayOptions();
			break;
		
		case 2: // Luminosità -
			((Image)m).brightnessDown();
			displayOptions();
			break;
		
		case 3: // Mostra
			((Image)m).show();
			displayOptions();
			break;
			
		case 0:
			displayOptions();
			break;
			
		default:
			System.out.println(dangerText + "Non è una scelta valida" + resetText);
			displayOptions();
			break;
		}
		
		imagePreference.close();
	}

	
	private static void menuAudio(MultimediaElement m) {
		Scanner audioPreference = new Scanner(System.in);

		System.out.println("---------------------------------------");
		
		System.out.println("-> " + m.title + " <-");

		System.out.println(
				"1. Aumenta il volume \n" + 
				"2. Riduci il volume \n" + 
				"3. Riproduci \n" +
				"0. Torna alla lista");
		
		int selection = audioPreference.nextInt();
		switch(selection) {
		
		case 1: // Volume +
			((AudioRecording)m).volumeUp();
			displayOptions();
			break;
		
		case 2: // Volume -
			((AudioRecording)m).volumeDown();
			displayOptions();
			break;
		
		case 3: // Play
			((AudioRecording)m).play();
			displayOptions();
			break;
			
		case 0:
			displayOptions();
			break;
			
		default:
			System.out.println(dangerText + "Non è una scelta valida" + resetText);
			displayOptions();
			break;
		}
		
		
		audioPreference.close();
	}


	private static void menuVideo(MultimediaElement m) {
		
		Scanner videoPreference = new Scanner(System.in);

		System.out.println("---------------------------------------");
		
		System.out.println("-> " + m.title + " <-");
		
		System.out.println(
				"1. Aumenta la luminosità \n" + 
				"2. Riduci la luminosità \n" + 
				"3. Aumenta il volume \n" + 
				"4. Riduci il volume \n" +
				"5. Riproduci \n" +
				"0. Torna alla lista");
		
		int selection = Integer.parseInt(videoPreference.nextLine());

		switch (selection) {

		case 1: // Luminosità +
			((Video)m).brightnessUp();
			displayOptions();
			break;
			
		case 2: // Luminosità -
			((Video)m).brightnessDown();
			displayOptions();
			break;
			
		case 3: // Volume +
			((Video) m).volumeUp();
			displayOptions();
			break;

		case 4: // Volume -
			((Video) m).volumeDown();
			displayOptions();
			break;

		case 5: // Play
			((Video) m).play();
			displayOptions();
			break;
			
		case 0:
			displayOptions();
			break;
			
		default:
			System.out.println(dangerText + "Non è una scelta valida" + resetText);
			displayOptions();
			break;
		}

		videoPreference.close();
	}
	
	// Check su lunghezza lista e sostituzione eventuale elemento più vecchio
	private static void addToList(ArrayList<MultimediaElement> array, MultimediaElement m) {
		
		if(array.size() < 5) {
			array.add(m);
		}else {
			array.remove(0);
			array.add(m);
		}
	}
}