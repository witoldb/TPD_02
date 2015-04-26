/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd_02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author pleban16
 */
public class Main {
    
    
    JFrame frame;
    JTextField[][] dane;
    JLabel[] opcja;
    JPanel panel;
    JTextPane jTextAreaLogi;
    String logi=""; 
    JButton oblicz;
    int[][] wartosci;
    int x=2;int z=2;
    int min[];
    int minTemp[];
    int max[];
    int maxTemp[];
    
    Main(int x, int z){
        this.x=x;
        this.z=z;
        frame = new JFrame("Podejmowanie decyzji");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(((x+1)*50)+100,((z+2)*30)+150);
        min = new int[z];
        minTemp = new int[x];
        max = new int[x];
        maxTemp = new int[z];
        panel = new JPanel();
        panel.setLayout(null);
        JLabel jlabel2 = new JLabel("Gracz 2");
        
        jlabel2.setBounds((((x+2)*50)/2), 0, 100, 30);
        panel.add(jlabel2);
        opcja = new JLabel[z];
        dane = new JTextField[x][z];
        wartosci= new int[x][z];
        for(int i=0;i<x;i++){
            for(int j=0;j<z;j++){
                dane[i][j]=new JTextField(""+i);
                dane[i][j].setBounds((i+2)*50, (j+1)*30, 50, 30);
                panel.add(dane[i][j]);
            }
        }
        JLabel jlabel1 = new JLabel("Gracz 1");
        jlabel1.setBounds(10, 0, 100, 30);
        panel.add(jlabel1);
        for(int i=0;i<z;i++){
            opcja[i]= new JLabel("Opcja: "+(i+1));
            opcja[i].setBounds(10,(i+1)*30, 100, 30);
            panel.add(opcja[i]);
        }
        jTextAreaLogi = new JTextPane();
        jTextAreaLogi.setBounds(10,(z+1)*30+10,((x+2)*50),(((z+2)*30)+50)-((z+1)*30+10));
        jTextAreaLogi.setAutoscrolls(true);
        panel.add(jTextAreaLogi);
        oblicz = new JButton("Oblicz");
     
        oblicz.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            UstawLogi("Działa:"+dane[0][0].getText());
            pobierzDane();
            zmienWartosci();
            }
        });
        oblicz.setBounds(10,((z+1)*30+10)+((((z+2)*30)+50)-((z+1)*30+10)),100,30);
        panel.add(oblicz);
        frame.add(panel);
        frame.setVisible(true);
    }
    void UstawLogi(String log){
       // logi=logi+log+"\n";
        jTextAreaLogi.setText(log);
    }
    void pobierzDane(){
       for(int i=0;i<x;i++){
            for(int j=0;j<z;j++){
                wartosci[i][j]=Integer.parseInt(dane[i][j].getText());
            }
       }
    }
    void zmienWartosci(){
       //min
       for(int i=0;i<z;i++){
            for(int j=0;j<x;j++){
                minTemp[j]=wartosci[j][i];
                //System.out.print(wartosci[j][i]);
            }
            Arrays.sort(minTemp);
            min[i]=minTemp[0];
            System.out.println("MIN:"+min[i]);
       }
       //max
       for(int i=0;i<x;i++){
            for(int j=0;j<z;j++){
                maxTemp[j]=wartosci[i][j];
                //System.out.print(wartosci[j][i]);
            }
            Arrays.sort(maxTemp);
            max[i]=maxTemp[z-1];
            System.out.println("MAX:"+max[i]);
       }
    }
 
}
