package miniproject;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

class JFrmaeGraphics extends JPanel{

   
     Font f1, f2, f3;
      Color clr1, clr2, clr3,clr4;
     public JFrmaeGraphics() 
 {   
    clr1 = new Color(50, 50, 220);  
    clr2 = new Color(50, 50, 220);
    clr3 = new Color(50, 50, 220);
    clr4 = new Color(200,50,100);
                                      
    f1 = new Font("SansSerif", Font.BOLD, 30);
    f2 = new Font("SansSerif", Font.BOLD, 30);
    f3 = new Font("SansSerif", Font.BOLD, 20); }
    
     @Override
	public void paint(Graphics g){
             g.setColor(clr1);     
                 g.setFont(f1); 
		g.drawString("Image Contrast Enhancement", 290, 60);
                 g.setColor(clr2);     
                 g.setFont(f2); 
                g.drawString("Using", 450, 100);
                 g.setColor(clr2);     
    g.setFont(f2); 
                g.drawString("Histogram Equalization", 335,140);
                 g.setColor(clr4);     
    g.setFont(f3); 
     g.drawString("-------------------------------------------------------------------------------------------------------------------------------------------", 10,180);
                 g.drawString("Source file path :  ", 60,280);
                  g.drawString("Destination file path :", 60,380);
	}
        
}