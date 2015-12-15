import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * Created by admpo_000 on 12.12.2015.
 */
public class finalFFT   extends  AudioBuffer{

    private double [][] input;
    private double[] output;
    private ArrayList<Double> listouput = new ArrayList<>();
    double[] zera;
    private double[] skonwertowane;



    public ArrayList<Double> policzFFT(ByteArrayOutputStream data){

        if(!listouput.isEmpty()) listouput.clear();

         skonwertowane = DataConverter.convertBytetoDouble(data);

        zera = new double[skonwertowane.length];

        for (int i = 0; i < zera.length; i++) {
            zera[i] = 0.0d;
        }

        input=fft.transform(skonwertowane, zera);

//wartosc bezwględna
        output = new double[input[0].length];
        for(int i = 0;i<input[0].length;i++) {

            output[i] = Math.hypot(input[0][i], input[1][i]);
        }
        //normalizacja
        for (int i=0;i<output.length/2;i++){

            listouput.add(output[i]*2/output.length);//tu można wstawić zmienną w razie w

        }
        return listouput;

    }

}
