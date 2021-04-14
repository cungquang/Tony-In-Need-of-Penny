package game;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *	Abstract class:
        -private int characterDx, characterDy     :indicate the position on Map level
 *	method:
 *      -getdX()    :return the Character's X-coordinate
 *      -getdY()    :return the Character's Y-coordinate
 *      -setdX()    :Change the Character's X-coordinate
 *      -setdY()    :Change the Character's Y-coordinate
 *
 */


class activeObj extends KeyAdapter {
    private int characterDx, characterDy;

    public int getdX() {
        return characterDx;
    }

    public int getdY() {
        return characterDy;
    }

    public void resetX(int x)
    {
        characterDx = x;
    }

    public void resetY(int y)
    {
        characterDy = y;
    }    

    public void setdX(int x) {
        characterDx += x;
    }

    public void setdY(int y) {
        characterDy += y;
    }
}


