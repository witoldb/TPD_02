/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpd_02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author pleban16
 */
public class Main {
    
    
    JFrame frame;
    JTextField jtext1[][];
    JLabel labell[];
    JPanel panel;
    JTextPane jTextAreaLogi;
    String logi=""; 
    JButton oblicz;
    
    Main(int x, int z){
        frame = new JFrame("Podejmowanie decyzji");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(((x+1)*50)+100,((z+2)*30)+100);
        
        panel = new JPanel();
        panel.setLayout(null);
        JLabel jlabel2 = new JLabel("Gracz 2");
        
        jlabel2.setBounds((((x+2)*50)/2), 0, 100, 30);
        panel.add(jlabel2);
        labell = new JLabel[z];
        jtext1 = new JTextField[x][z];
        for(int i=0;i<x;i++){
            for(int j=0;j<z;j++){
                jtext1[i][j]=new JTextField(""+i);
                jtext1[i][j].setBounds((i+2)*50, (j+1)*30, 50, 30);
                panel.add(jtext1[i][j]);
            }
        }
        JLabel jlabel1 = new JLabel("Gracz 1");
        jlabel1.setBounds(10, 0, 100, 30);
        panel.add(jlabel1);
        for(int i=0;i<z;i++){
            labell[i]= new JLabel("Opcja: "+(i+1));
            labell[i].setBounds(10,(i+1)*30, 100, 30);
            panel.add(labell[i]);
        }
        jTextAreaLogi = new JTextPane();
        jTextAreaLogi.setBounds(10,(z+1)*30+10,((x+2)*50),(((z+2)*30)+50)-((z+1)*30+10));
        jTextAreaLogi.setAutoscrolls(true);
        panel.add(jTextAreaLogi);
        oblicz = new JButton("Oblicz");
     
        oblicz.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            UstawLogi("Działa:"+jtext1[0][0].getText());
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

    
}
