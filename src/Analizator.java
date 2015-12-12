import java.io.ByteArrayOutputStream;

/**
 * Created by admpo_000 on 09.12.2015.
 */
public class Analizator {

    public static void main(String[] args){


        AudioBuffer buforek = new AudioBuffer();

        buforek.prepareAudioBuffer(441000);

        ByteArrayOutputStream jakiesdane = buforek.getData();
        DataConverter.convertBytetoDouble(jakiesdane);

       }

}
