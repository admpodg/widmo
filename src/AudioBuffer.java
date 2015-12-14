/**
 * Created by admpo_000 on 09.12.2015.
 */
import javax.sound.sampled.*;
import java.io.ByteArrayOutputStream;

/**
 * klasa obiektu buforującego fragment danych audio, na którym ma zostać wykonane przekształcenie Fouriera;
 * dziedziczy z klasy bibliotecznej "TargetDataLine"
 */
public class AudioBuffer {

    private TargetDataLine mic; // linia udostępniająca strumień danych z mikrofonu
    private byte[] temp;   // tablica będąca tymczasowym cząstkowym buforem
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();  // strumień bedący właściwym buforem danych, na którym są prowadzone dalsze obliczenia


    public int numbytes;

    public void prepareAudioBuffer(int bufferSize) {
        AudioFormat format = new AudioFormat(44100.0f,16,1,true,true);
        temp = new byte [2*bufferSize];
        // Obtain and open the line.
        try {

            mic = AudioSystem.getTargetDataLine(format);
            mic.open(format,bufferSize);



        } catch (LineUnavailableException ex) {
            // Handle the error ...
        }

        DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
        if (!AudioSystem.isLineSupported(info)) {
            // Handle the error ...
            System.out.println("nie jest suportowany");
        }


    }


    public ByteArrayOutputStream getData() {
        buffer.reset();
        if (mic.isOpen()) {
            numbytes = mic.read(temp, 0, temp.length);
            buffer.write(temp, 0, numbytes);
        }
        return buffer;

    }

    public void startAudio(){
        mic.start();

    }

    public void stopAudio(){

         mic.stop();
        // mic.close();

    }




}

