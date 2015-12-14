import java.util.ArrayList;

/**
 * Created by admpo_000 on 12.12.2015.
 */
public class finalFFT   {

    protected double [][] input;
    protected double[] output;

    protected void getfft(double [][] data){
        input=data.clone();
         }
    private ArrayList<Double> listouput = new ArrayList<>();


    public void abs(){
    output = new double[input[0].length];
    for(int i = 0;i<input[0].length;i++){

output[i]= Math.hypot(input[0][i],input[1][i]);

}


    }

    public ArrayList <Double>  normalise(){


        for (int i=0;i<output.length/2;i++){

            listouput.add(output[i]*2/output.length);//tu można wstawić zmienną w razie w

        }
return listouput;

    }//funkcja wypluwająca połowę widma, które jest znormalizowane




}
