import javafx.scene.control.ComboBox;
import org.knowm.xchart.Chart;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.StyleManager;
import org.knowm.xchart.XChartPanel;

import javax.management.timer.TimerNotification;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.io.ByteArrayOutputStream;
import java.sql.Time;
import java.util.*;
import java.util.List;

/**
 * Klasa obiektu graficznego wyświetlającego wykres widma sygnału;
 */
public class Graph extends AudioBuffer implements ActionListener {

    private String chart_name = "Widmo Sygnału";
    private String x_label = "Częstotliwość [Hz]";
    private String y_label = "Amplituda [dB]";
    private String series_name = "A(f)";
    private String frame_name = "Analizator Widma";
    //////////////////////////
    //***przyciski
    private JButton przycisk_start = new JButton("Start");
    private JButton przycisk_stop = new JButton("Stop");
    //combobox do lsity
    private JComboBox lista_buforow;
    private String[] bufory = {"128", "256", "512", "1024", "2048", "4096", "8192", "16384"};


    ////panele
    private JPanel panel_przyciskow = new JPanel();
    private JPanel panel = new JPanel();

    private JFrame frame = new JFrame(frame_name);
    private Chart chart = QuickChart.getChart(chart_name, x_label, y_label, series_name, new double[1], new double[1]);

    private XChartPanel ChartPanel = new XChartPanel(chart);


    public void prepareGraph() {
        chart.getStyleManager().setChartType(StyleManager.ChartType.Area);
        chart.getStyleManager().setLegendVisible(false);

        przycisk_start.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lista_buforow = new JComboBox(bufory);
        lista_buforow.setName("Rozmiar FTT");
        //dodawanie przycisków
        panel_przyciskow.add(przycisk_start);
        panel_przyciskow.add(przycisk_stop);
        panel_przyciskow.add(new JLabel("Rozmiar FFT"));
        panel_przyciskow.add(lista_buforow);

        //wiązanie akcji z przyciskami
        przycisk_start.addActionListener(this);
        przycisk_stop.addActionListener(this);
        lista_buforow.addActionListener(this);


        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel_przyciskow.setAlignmentY(Component.BOTTOM_ALIGNMENT);


        panel.add(ChartPanel);
        frame.add(Box.createRigidArea(new Dimension(1, 5)));
        panel.add(panel_przyciskow);

        panel_przyciskow.setMaximumSize(new Dimension(800,200));


        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }

    public void updateGraph(List<Double> new_X, List<Double> new_Y) {
        ChartPanel.updateSeries(series_name, new_X, new_Y, null);
    }

    public void setLogX() {
        chart.getStyleManager().setXAxisLogarithmic(true);
    }

    public void setLogY() {
        chart.getStyleManager().setYAxisLogarithmic(true);
    }

    public void setYlimit() {
        chart.getStyleManager().setYAxisMax(32000);
        chart.getStyleManager().setYAxisMin(0.001);
    }

    public void actionPerformed(ActionEvent e) {//tu będą poszczególne przypadki
        Object event = e.getSource();

     //   if (event == przycisk_start) {

           /* finalFFT automat = new finalFFT();
            int rozmiar_bufora = 4096;
            automat.prepareAudioBuffer(rozmiar_bufora);

            ArrayList<Double> osX = new ArrayList<>();
            for (int i = 1; i <= rozmiar_bufora / 2; i++) {
                osX.add(i * 44100.0d / (rozmiar_bufora));

            }

            automat.startAudio();


            Timer timer = new Timer(0, this);
            TimerTask graphUpdater = new TimerTask() {

                @Override
                public void run() {
                    ArrayList<Double> osY;

                    osY = automat.policzFFT(automat.getData());//tutaj przedtem się zawierał cały kod progarmu

                    System.out.println(osX.size());
                    System.out.println(osY.size());
                    ChartPanel.updateSeries(series_name, osX, osY, null);
                }
            };

            // graph.setLogX();
            //graph.setLogY();
            //graph.setYlimit();

             graphUpdater.scheduledExecutionTime();
             */
       // }

    }
}

