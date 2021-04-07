package game.enemy_test;

import java.lang.reflect.Constructor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class punishment extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public punishment(){
        JFrame pFrame = new JFrame();
        JPanel pJPanel = new JPanel();
        JLabel pJLabel = new JLabel("Game over");
        pJPanel.add(pJLabel);
        pFrame.add(pJPanel);
        pFrame.setBounds(200, 200, 200, 200);
        pFrame.setVisible(true);
        
    }
    
}
