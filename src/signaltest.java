/**
 * Created by admpo_000 on 12.12.2015.
 */
public class signaltest {

   static double[] sinus;

    public static double[] getSinus(int length, int amplitude){
        sinus=new double[length];
        for(int i=0;i<length;i++) {
            sinus[i] =amplitude* Math.sin(2 * Math.PI * i/44100*10000);
        }
    return sinus;
    }
}
