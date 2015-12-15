
import java.util.ArrayList;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by admpo_000 on 09.12.2015.
 */
public class Analizator {

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.prepareGraph();






        finalFFT automat=new finalFFT();
        int rozmiar_bufora=4096;
        automat.prepareAudioBuffer(rozmiar_bufora);

        ArrayList<Double> osX=new ArrayList<>();
        for(int i=1;i<=rozmiar_bufora/2;i++){
            osX.add(i*44100.0d/(rozmiar_bufora));

        }

        automat.startAudio();



        Timer timer = new Timer(true);
        TimerTask graphUpdater = new TimerTask() {

            @Override
            public void run() {
                ArrayList<Double> osY;

                osY = automat.policzFFT(automat.getData());
                graph.updateGraph(osX,osY);
            }
        };

        graph.setLogX();
        //graph.setLogY();
        graph.setYlimit();

        timer.schedule(graphUpdater, 1000, 100);

    }

    }








