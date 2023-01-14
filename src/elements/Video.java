package elements;

import abstracts.PlayableElement;
import interfaces.Brightness;

public class Video extends PlayableElement implements Brightness {
	
	private int brightness;
	
	public Video(String _title, int _runtime) {
		this.title = _title;
		this.runtime = _runtime;
		this.volume = 5;
		this.brightness = 5;
	}
	
	protected String displaySettings() {
		return "!".repeat(this.volume) + "*".repeat(this.brightness);
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
}
