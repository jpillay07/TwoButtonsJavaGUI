import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoButtons {

    JFrame frame;
    JLabel label;

    int xPos;
    int yPos;

    public static void main(String[] args){
        TwoButtons twoButtons = new TwoButtons();
        twoButtons.go();
    }

    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelListener());

        JButton colorButton = new JButton("Change Color");
        colorButton.addActionListener(new ColorListener());

        label = new JLabel("I am a label");

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.setSize(300,300);
        frame.setVisible(true);


    }

    class LabelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText("awe");

        }

    }
    
    class ColorListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(xPos != 100){
                xPos += 10;
                yPos += 10;
            }
            frame.repaint();
            

        }
        
    }

    class MyDrawPanel extends JPanel{
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
    
            int red = (int) (Math.random() * 256);
            int green = (int) (Math.random() * 256);
            int blue = (int) (Math.random() * 256);
            Color startColor = new Color(red, green, blue);
    
    
            red = (int) (Math.random() * 256);
            green = (int) (Math.random() * 256);
            blue = (int) (Math.random() * 256);
            Color endColor = new Color(red, green, blue);
    
            GradientPaint gradient = new GradientPaint(70,70,startColor, 150,150, endColor);
            g2d.setPaint(gradient);
            g2d.fillOval(xPos,yPos,100,100);
    
        }
    }
    
}