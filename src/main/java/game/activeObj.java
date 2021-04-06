package game;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *	Abstract class:
        -private int Character_dx, Character_dy     :indicate the position on Map level
 *	method:
 *      -getdX()    :return the Character's X-coordinate
 *      -getdY()    :return the Character's Y-coordinate
 *      -setdX()    :Change the Character's X-coordinate
 *      -setdY()    :Change the Character's Y-coordinate
 *
 */


class activeObj extends KeyAdapter {
    private int Character_dx, Character_dy;

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


