package elements;

import abstracts.MultimediaElement;
import interfaces.Brightness;

public class Image extends MultimediaElement implements Brightness {

	private int brightness;
	
	public Image(String _title) {
		this.title = _title;
		this.brightness = 5;
	}
	
	public void brightnessUp() {
		if (this.brightness != 10) {
			this.brightness++;
		} else {
			System.out.println("La luminosità è già al massimo");
		}
		System.out.println("Luminosità Impostata: " + brightness*10 + "%");
	}
	
	public void brightnessDown() {
		if (this.brightness != 0) {
			this.brightness--;
		} else {
			System.out.println("La luminosità è già al minimo");
		}
		System.out.println("Luminosità Impostata: " + brightness*10 + "%");
	}
	
	public void show() {
			System.out.println(this.title + "*".repeat(this.brightness));				
	}
}
