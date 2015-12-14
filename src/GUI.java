/**
 * Created by admpo_000 on 13.12.2015.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame implements ActionListener
{
//przyciski tutaj trzeba deklarowac itp


    JButton button_start;
    JButton button_stop;

    JPanel panel;
    JPanel button_panel;
    JPanel drawpanel;
    public GUI(){
        super("analizator");//popzrez super nie trzeba pisać swojego konktuktora - tu kontruujemy obiekt frame
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(300,300);

//^kontruktor samego okna

        panel = new JPanel();
        button_panel=new JPanel();
        drawpanel=new JPanel();

        panel.setBackground(Color.RED);
        drawpanel.setBackground(Color.cyan);
        drawpanel.setAlignmentX(4);




///////////////////////////////////////////////

/////////////////////////////////// inicjalizacja przycisków itp
        button_start= new JButton("START");

        button_start.addActionListener(this);
        button_panel.add(button_start);

        button_stop = new JButton("STOP");
        button_stop.addActionListener(this);
        button_panel.add(button_stop);
        button_panel.setLayout(new BoxLayout(button_panel,BoxLayout.Y_AXIS));

        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));

        panel.add(button_panel);
        panel.add(drawpanel);

        setContentPane(panel);



        setVisible(true);
    }



    public void actionPerformed(ActionEvent e) {//to jest funkcja do obsługi zdarzeń
        if (e.getSource()==button_start) {
            //DoFFTmath.start();
        }

    }
}
