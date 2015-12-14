import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * Created by admpo_000 on 13.12.2015.
 */
public class AutomatObliczeniowy  extends AudioBuffer{

    ArrayList<Double> meh = new ArrayList<>();
    double[] zera;

    public ArrayList<Double> policzFFT(ByteArrayOutputStream data){

        double[] skonwertowane = DataConverter.convertBytetoDouble(data);

//

            zera = new double[skonwertowane.length];

            for (int i = 0; i < zera.length; i++) {
                zera[i] = 0.0d;

        }//o reinicjalizacji trzeba pamiętać, to się powinno wyzerować
        finalFFT buforfft=new finalFFT();
        buforfft.getfft(fft.transform(skonwertowane, zera));
        buforfft.abs();//

        return meh = buforfft.normalise();

    }
}
