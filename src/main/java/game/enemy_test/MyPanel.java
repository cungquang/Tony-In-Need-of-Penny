package main.java.game.enemy_test;

import javax.swing.JPanel;

public class MyPanel extends JPanel{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public final static int size = 25;

    public MyPanel(int x, int y){
		this.setBounds(x * size, y * size, size, size);
    }
    
    public MyPanel(Eneposition fk){
		this.setBounds(fk.getX() * size, fk.getY() * size, size, size);
	}
}
