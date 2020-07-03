
package miniproject;

import com.mathworks.engine.MatlabEngine;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.*;

public class FrontEnd extends JFrame{
JFrame frame= new JFrame("Image Contrast Enhancement");
   
    JButton button,button1,button2 ;
    JLabel label,label1,label2;
    
    FrontEnd(){
   
    button = new JButton("Browse");
    button.setBounds(700,260,100,40);
    button1 = new JButton("Browse");
    button1.setBounds(700,360,100,40);
    label = new JLabel();
    label.setBounds(10,10,670,30);
    label1 = new JLabel();
    label1.setBounds(10,10,670,30);
    button2 = new JButton("Enhance Image");
    button2.setBounds(480,470,200,40);
    label2 = new JLabel();
    label2.setBounds(10,10,720,50);
   
    JTextField t1,t2;  
    t1=new JTextField(" ");  
    t1.setBounds(280,250, 400,50); 
    t2=new JTextField(" ");  
    t2.setBounds(280,350, 400,50);
    frame.add(t1);frame.add(t2);// f.add(t3);
    frame.getContentPane().add(new JFrmaeGraphics());
               
    frame.setSize(1000, 700);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
                
    frame.add(button);
    frame. add(label);
    frame. add(button1);
    frame.add(label1);
    frame. add(button2);
    frame.add(label2);
   
    
    
    button.addActionListener((ActionEvent e) -> {
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            t1.setText(path);
        }
        
        else if(result == JFileChooser.CANCEL_OPTION){
            System.out.println("No File Selected");
        }
    });
    
    button1.addActionListener((ActionEvent e) -> {
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            t2.setText(path);
        }
        
        else if(result == JFileChooser.CANCEL_OPTION){
            System.out.println("No File Selected");
        }
    });
    
    MatlabEngine eng;
    try {
        eng = MatlabEngine.startMatlab();
        eng.eval("cd src\\miniproject");
    
    button2.addActionListener((ActionEvent e) -> {
        String Source = t1.getText();
        String Destination = t2.getText();
        char[] S = Source.toCharArray();
        char[] D = Destination.toCharArray();
        try {
            eng.feval(0,"imagecontrastenhancement",S,D);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            //Logger.getLogger(FrontEnd.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    } catch (Exception ex) {
            System.out.println(ex.getMessage()); 
        }
    }
    
   
    
    public static void main(String[] args){
    FrontEnd front = new FrontEnd();
     
    }
   }
