import org.knowm.xchart.Chart;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.StyleManager;
import org.knowm.xchart.XChartPanel;

import javax.management.timer.TimerNotification;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa obiektu graficznego wyświetlającego wykres widma sygnału;
 */
public class Graph implements ActionListener{

    private String chart_name = "Widmo Sygnału";
    private String x_label = "Częstotliwość [Hz]";
    private String y_label = "Amplituda [dB]";
    private String series_name = "A(f)";
    private String frame_name = "Analizator Widma";

    private JButton przycisk_start = new JButton("Start");
    private JButton przycisk_stop = new JButton("Stop");


    private JPanel panel_przyciskow = new JPanel();
    private JPanel panel = new JPanel();

    private JFrame frame = new JFrame(frame_name);
    private Chart chart = QuickChart.getChart(chart_name, x_label, y_label, series_name, new double[1], new double[1]);


    private XChartPanel ChartPanel = new XChartPanel(chart);

    public void prepareGraph(){
        chart.getStyleManager().setChartType(StyleManager.ChartType.Area);
        chart.getStyleManager().setLegendVisible(false);

        przycisk_start.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //dodawanie przycisków
        panel_przyciskow.add(przycisk_start);
        panel_przyciskow.add(przycisk_stop);

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));



        panel.add(ChartPanel);
        frame.add(Box.createRigidArea(new Dimension(1,5)));
        panel.add(panel_przyciskow);
        //frame.add(ChartPanel);///

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public void updateGraph(List<Double> new_X, List<Double> new_Y){
        ChartPanel.updateSeries(series_name, new_X, new_Y, null);
    }
    public void setLogX(){
        chart.getStyleManager().setXAxisLogarithmic(true);
    }
    public void setLogY(){
        chart.getStyleManager().setYAxisLogarithmic(true);
    }
    public void setYlimit(){
    chart.getStyleManager().setYAxisMax(50000);
        chart.getStyleManager().setYAxisMin(0.001);
    }

    public void actionPerformed(ActionEvent e) {//tu będą poszczególne przypadki
        Object event = e.getSource();

        if (event==przycisk_start){

                }
        }

    }

