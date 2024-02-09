import javax.sound.sampled.*;
import java.util.Objects;

public class AudioPlayer {

    public static void playAudio(String fileName, int cutLatency) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(AudioPlayer.class.getResourceAsStream(fileName));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / cutLatency);
            clip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}