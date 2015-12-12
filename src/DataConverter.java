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


public class DataConverter {

    private double outputvalues;


    public static void convertBytetoDouble(ByteArrayOutputStream bufor) {
      short val;
        ByteBuffer bb=ByteBuffer.allocate(2);
       bb.order(ByteOrder.BIG_ENDIAN);

        byte[] temp = bufor.toByteArray();


        for (int i = 0; i <temp.length; i=i+2) {

            bb.put(temp[i]);
            bb.put(temp[i+1]);
            val=bb.getShort(0);
            System.out.println(val);
            bb.clear();
        }


    }
}