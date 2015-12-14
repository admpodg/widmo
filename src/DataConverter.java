/**
 * Created by admpo_000 on 09.12.2015.
 */
/**
 *
 * klasa konwertująca dane audio w postaci bajtów na liczbowe wartości próbek
 */
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;


public class DataConverter  {

    public static double[] convertBytetoDouble(ByteArrayOutputStream bufor) {

       ByteBuffer bb=ByteBuffer.allocate(2);
       bb.order(ByteOrder.BIG_ENDIAN);

        byte[] temp = bufor.toByteArray();
        double [] converted = new double [temp.length/2];
        byte bajt = 0;
        for (int i = 0; i <temp.length; i=i+2) {


            bb.put(temp[i]);
            bb.put(temp[i+1]);
            short val = bb.getShort(0);
            converted[i/2]=(double)val;
            bb.clear();

        }

return  converted;

    }
}