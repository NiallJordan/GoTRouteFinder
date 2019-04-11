package application;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundFactory {
	static Clip clip;

	public static synchronized void playSound() {
		new Thread(new Runnable() {
			public void run() {
				try {
					clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem
							.getAudioInputStream(SoundFactory.class.getResourceAsStream("GoTTheme.wav"));
					clip.open(inputStream);
					clip.start();
					clip.loop(0);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}).start();
	}

	public static void stopSound() {
		System.out.println("Stopping sound");
		clip.stop();
		System.out.println("Sound stopped");
	}
}
