package game;


import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class activeObj extends KeyAdapter {
    //private int Character_x,Character_y;
    private int Character_dx, Character_dy;
    //private final int Speed = 6;

    public int getdX() {
        return Character_dx;
    }

    public int getdY() {
        return Character_dy;
    }

    public void setdX(int x) {
        Character_dx += x;
    }

    public void setdY(int y) {
        Character_dy += y;
    }
}


