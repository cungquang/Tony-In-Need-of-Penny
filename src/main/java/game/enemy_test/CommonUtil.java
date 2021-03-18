package main.java.game.enemy_test;

import java.awt.*;
import javax.swing.*;


public class CommonUtil {
    public static Dimension getScreenSize(){
		return Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	/**
	 * 以windows风格展示
	 */
	public static void windowsStyle(){
		String windows="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		 try {
			UIManager.setLookAndFeel(windows);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
    
}
