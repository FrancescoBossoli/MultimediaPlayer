package scanners;



import java.util.ArrayList;
import java.util.Scanner;
import elements.*;
import main.*;
import abstracts.*;

public class Reader {
	
	private static final String RED_TXT = "\u001B[31m";
	private static final String RESET_TXT = "\u001B[0m";
	
	//starter
	public static void scannerStart() {
		Scanner in = new Scanner(System.in);
		System.out.println("------------------");

		System.out.println(
				"Make a new media file: \n" 
				+ "1. Create image \n" 
				+ "2. Create audio \n"
				+ "3. Create video \n" 
				+ "0. Show/play media \n"
				);

		int action = Integer.parseInt(in.nextLine());

		switch (action) {
		case 1:
			newImgScanner();
			break;
		case 2:
			newAudioScanner();
			break;
		case 3:
			newVideoScanner();
			break;
		case 0:
			actionsScanner();
			break;
		default:
			System.out.println(RED_TXT + "NOT A VALID NUMBER" + RESET_TXT);
			System.out.println("------------------");
			scannerStart();
			break;
		}

		in.close();
	} 

	//img creation
	private static void newImgScanner() {
		
		Scanner imgSc = new Scanner(System.in);
		System.out.println("Write the image title: ");
		String title = imgSc.nextLine();
		
		Image img = new Image(title);
		
		if(title.length() == 0) {
			System.out.println(RED_TXT + "Error: BE CREATIVE, WE NEED A TITLE" + RESET_TXT);
			newImgScanner();
		}
		
		addIfArrOk(MediaPlayer.media, img);
		
		System.out.println("--> Created img: " + img);
		System.out.println("------------------");
		scannerStart();
		imgSc.close();
	}
	
	//audio creation
	private static void newAudioScanner() {
		
		Scanner audioSc = new Scanner(System.in);
		
		System.out.println("Write the audio title: ");
		String audioTitle = audioSc.nextLine();
		
		if(audioTitle.length() == 0) {
			System.out.println(RED_TXT + "Error: BE CREATIVE, WE NEED A TITLE" + RESET_TXT);
			newAudioScanner();
		}
		
		System.out.println("Write the duration of the audio: ");
		int duration = Integer.parseInt(audioSc.nextLine());
		
		AudioRecording aud = new AudioRecording(audioTitle, duration);
		addIfArrOk(MediaPlayer.media, aud);
		
		System.out.println("--> Created audio: " + aud);
		System.out.println("------------------");
		scannerStart();
		
		audioSc.close();
	}
	
	//video creation
	private static void newVideoScanner() {

		Scanner videoSc = new Scanner(System.in);

		System.out.println("Write the video title: ");
		String vidTitle = videoSc.nextLine();
		
		if(vidTitle.length() == 0) {
			System.out.println(RED_TXT + "Error: BE CREATIVE, WE NEED A TITLE" + RESET_TXT);
			newVideoScanner();
		}

		System.out.println("Write the duration of the video: ");
		int duration = Integer.parseInt(videoSc.nextLine());

		Video vid = new Video(vidTitle, duration);
		addIfArrOk(MediaPlayer.media, vid);

		System.out.println("--> Created video: " + vid);
		System.out.println("------------------");
		scannerStart();

		videoSc.close();

	}

	//global actions
	private static void actionsScanner() {
		
		ArrayList<MultimediaElement> medias = MediaPlayer.media;
		
		Scanner show = new Scanner(System.in);
		System.out.println("------------------");
		System.out.println("Wich media you want to show?");
		
		int i = 1;
		for(MultimediaElement file : medias) {
			System.out.println(i + ". " + file.title);
			i++;
		}
		System.out.println("0. Back to start");
		
		int mediaNum = Integer.parseInt(show.nextLine());
		
		switch(mediaNum) {
		case 1:
			MultimediaElement case1 = medias.get(0);
			
			if( case1 instanceof Video ) {
				vidActions(case1);
			}else if(case1 instanceof AudioRecording){
				audActions(case1);
			}else {
				imgActions(case1);
			}
			break;
			
		case 2:
			MultimediaElement case2 = medias.get(1);

			if( case2 instanceof Video ) {
				vidActions(case2);
			}else if(case2 instanceof AudioRecording){
				audActions(case2);
			}else {
				imgActions(case2);
			}
			break;
			
		case 3:
			MultimediaElement case3 = medias.get(2);

			if( case3 instanceof Video ) {
				vidActions(case3);
			}else if(case3 instanceof AudioRecording){
				audActions(case3);
			}else {
				imgActions(case3);
			}
			break;
			
		case 4:
			MultimediaElement case4 = medias.get(3);

			if( case4 instanceof Video ) {
				vidActions(case4);
			}else if(case4 instanceof AudioRecording){
				audActions(case4);
			}else {
				imgActions(case4);
			}
			break;
			
		case 5:
			MultimediaElement case5 = medias.get(4);

			if( case5 instanceof Video ) {
				vidActions(case5);
			}else if(case5 instanceof AudioRecording){
				audActions(case5);
			}else {
				imgActions(case5);
			}
			break;
			
		case 0:
			scannerStart();
			break;
			
		default:
			System.out.println(RED_TXT + "NOT A VALID NUMBER" + RESET_TXT);
			System.out.println("------------------");
			actionsScanner();
			break;
		}
		
		show.close();
	}
	
	//actions fot Image media
	private static void imgActions(MultimediaElement m) {
		Scanner imgAct = new Scanner(System.in);
		
		System.out.println("----------------");
		
		System.out.println("-> " + m.title + " <-");
		
		System.out.println(
				"1. Enhance brightness \n" + 
				"2. Lower Brightness \n" + 
				"3. Play \n" +
				"0. Back to list"
		);
		
		int action = Integer.parseInt(imgAct.nextLine());
		switch(action) {
		
		case 1: //brightnes +
			((Image)m).brightnessUp();
			actionsScanner();
			break;
		
		case 2: //brightness -
			((Image)m).brightnessDown();
			actionsScanner();
			break;
		
		case 3: //show img
			((Image)m).show();
			actionsScanner();
			break;
		case 0:
			actionsScanner();
			break;
		default:
			System.out.println(RED_TXT + "INPUT NOT ACCEPTED" + RESET_TXT);
			actionsScanner();
			break;
		}
		
		imgAct.close();
	}

	//actions fot Audio media
	private static void audActions(MultimediaElement m) {
		Scanner audAct = new Scanner(System.in);

		System.out.println("----------------");
		
		System.out.println("-> " + m.title + " <-");

		System.out.println(
				"1. Enhance volume \n" + 
				"2. Lower volume \n" + 
				"3. Play \n" +
				"0. Back to list"
		);
		
		int action = Integer.parseInt(audAct.nextLine());
		switch(action) {
		
		case 1: //volume +
			((AudioRecording)m).volumeUp();
			actionsScanner();
			break;
		
		case 2: //volume -
			((AudioRecording)m).volumeDown();
			actionsScanner();
			break;
		
		case 3: //show audio
			((AudioRecording)m).play();
			actionsScanner();
			break;
		case 0:
			actionsScanner();
			break;
		default:
			System.out.println(RED_TXT + "INPUT NOT ACCEPTED" + RESET_TXT);
			actionsScanner();
			break;
		}
		
		
		audAct.close();
	}

	//actions fot Video media
	private static void vidActions(MultimediaElement m) {
		
		Scanner vidAct = new Scanner(System.in);

		System.out.println("----------------");
		
		System.out.println("-> " + m.title + " <-");
		
		System.out.println(
				"1. Enhance brightness \n" + 
				"2. Lower Brightness \n" + 
				"3. Enhance volume \n" + 
				"4. Lower volume \n" +
				"5. Play \n" +
				"0. Back to list"
		);
		
		int action = Integer.parseInt(vidAct.nextLine());

		switch (action) {

		case 1: //brightnes +
			((Video)m).brightnessUp();
			actionsScanner();
			break;
			
		case 2: //brightness -
			((Video)m).brightnessDown();
			actionsScanner();
			break;
			
		case 3: // volume +
			((Video) m).volumeUp();
			actionsScanner();
			break;

		case 4: // volume -
			((Video) m).volumeDown();
			actionsScanner();
			break;

		case 5: // show audio
			((Video) m).play();
			actionsScanner();
			break;
		case 0:
			actionsScanner();
			break;
		default:
			System.out.println(RED_TXT + "INPUT NOT ACCEPTED" + RESET_TXT);
			actionsScanner();
			break;
		}

		vidAct.close();
	}
	
	/*
	 * addIfArrOk(ArrayList<Media> arr, Media m)
	 * checks the size of the array, if its 5 then takes out
	 * the first element, shift everuthing to the left and then
	 * add the new elemetn to the end
	 */
	private static void addIfArrOk(ArrayList<MultimediaElement> arr, MultimediaElement m) {
		
		if(arr.size() < 5) {
			arr.add(m);
		}else {
			arr.remove(0);
			arr.add(m);
		}
	}
}