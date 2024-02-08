import javax.sound.sampled.*;
import java.util.Objects;

public class AudioPlayer {

    public static void playAudio(String fileName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(AudioPlayer.class.getResourceAsStream(fileName));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 10);
            clip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
