package abstracts;

import interfaces.Volume;

public abstract class PlayableElement extends MultimediaElement implements Volume {

	protected int volume;
	protected int runtime;
	
	public void volumeUp() {
		if (this.volume != 10) {
			this.volume++;
		} else {
			System.out.println("Il volume è già al massimo");
		}
		System.out.println("Volume Impostato: " + volume*10 + "%");
	}
	
	public void volumeDown() {
		if (this.volume != 0) {
			this.volume--;
		} else {
			System.out.println("Il volume è già al minimo");
		}
		System.out.println("Volume Impostato: " + volume*10 + "%");
	}
	
	public void play() {
		for (int i = 0; i < this.runtime; i++) {
			System.out.println(this.title + this.displaySettings());
		}		
	}
	
	protected String displaySettings() {
		return "!".repeat(this.volume);
	}
}