package elements;

import abstracts.PlayableElement;

public class AudioRecording extends PlayableElement{

	public AudioRecording(String _title, int _runtime) {
		this.title = _title;
		this.runtime = _runtime;
		this.volume = 5;
	}
}
