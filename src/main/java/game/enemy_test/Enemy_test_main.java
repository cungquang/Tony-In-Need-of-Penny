package game.enemy_test;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
 

import javax.swing.JFrame;
import javax.swing.*;

import game.Map;
import game.enemy_test.AutiFindWay;
import game.enemy_test.Eneposition;
import game.enemy_test.MyPanel;

public class Enemy_test_main extends JFrame{
    private static final long serialVersionUID = 1L;
	private static int beginX = 0;//jframe的x坐标
	private static int beginY = 0;//jframe的y坐标
	private static int frameWidth = 815;//jframe的宽
	private static int frameHeight = 635;//jframe的高
	private static int width = 800;//内部panel的宽
	private static int height = 600;//内部panel的高
	public static int widthLength = 20;//方块单位的y方向最大值
	public static int heightLength = 20;//方块单位的x方向最大值
	public static BackGroundPanel bgp = new BackGroundPanel();//容器panel，所有的方块都放入这个panel中，然后将这个panel添加到jframe中
	


	public static MyPanel cat = new MyPanel(1,1);
	public static MyPanel fish = new MyPanel(18,19);
    private final long sleepTime = 100;



	public static List<Eneposition> zhangaiList = new ArrayList<>();
	public static List<Eneposition> CoinList = new ArrayList<>();
	public static List<Eneposition> StaList = new ArrayList<>();
	public static List<Eneposition> closedList = new ArrayList<>();
	public static List<Eneposition> openList = new ArrayList<>();
    
    public Enemy_test_main(){
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		cat.setBackground(Color.green);
		fish.setBackground(Color.red);
		
		bgp.setBounds(0, 0, width, height);
		bgp.add(cat);
		bgp.add(fish);
		bgp.setBackground(Color.white);
		
		this.add(bgp);
		this.repaint();
		this.setVisible(true);
		for(Eneposition coin: CoinList){
			MyPanel coins = new MyPanel(coin);
			Graphics g = getGraphics();
			if(g != null){
				int ik = coins.getX();
				int j = coins.getY();
				
				g.setColor(Color.lightGray);
				g.fillRect(j*25, ik*25, 25, 25);
				g.setColor(Color.YELLOW);
				g.fillOval((j*25)+5, (ik*25)+5, 15, 15);
			}
			coins.setBackground(Color.GRAY);
			bgp.add(coins);
		}
		for(Eneposition sta: StaList){
			MyPanel coins = new MyPanel(sta);
			Graphics g = getGraphics();
			if(g != null){
				int ik = coins.getX();
				int j = coins.getY();
				
				g.setColor(Color.lightGray);
				g.fillRect(j*25, ik*25, 25, 25);
				g.setColor(Color.YELLOW);
				g.fillOval((j*25)+5, (ik*25)+5, 15, 15);
			}
			coins.setBackground(Color.ORANGE);
			bgp.add(coins);
		}


		this.add(bgp);
		this.repaint();
		this.setVisible(true);
		for(Eneposition fk : zhangaiList){
			JPanel panel = new JPanel(new CardLayout()){
				/**
				 *
				 */
				private static final long serialVersionUID = 1L;

				public void paint(Graphics g) {
					super.paint(g);
					int j = fk.x;
					int i = fk.y;
					g.setColor(Color.lightGray);
                    g.fillRect(j*25, i*25, 25, 25);
                    g.setColor(Color.YELLOW);
                    g.fillOval((j*25)+5, (i*25)+5, 15, 15);
				}
			};
			panel.setBounds(fk.x*25, fk.y*25, 25, 25);
			panel.setBackground(Color.BLACK);
			bgp.add(panel);
		}
		JPanel Apanel = new JPanel(new CardLayout());Apanel.setBounds(2*25, 2*25, 25, 25);
		Apanel.setBackground(Color.BLUE);
		bgp.add(Apanel);
		this.add(bgp);
		this.repaint();
		this.setVisible(true);
    }
    

	
	public static void main(String[] args) throws InterruptedException {
		getZhangAiList();
		Enemy_test_main bp  = new Enemy_test_main();
		AutiFindWay afw = new AutiFindWay();
		List<Eneposition> wayList = afw.getWayLine(cat, fish);
		bp.movePanel(wayList);
	}
	
	/**
	 * 
	 * @param wayList	
	 * @throws InterruptedException
	 */
	public void movePanel(List<Eneposition> wayList) throws InterruptedException{

		if(wayList == null || wayList.size() == 0){
			System.out.println("-----------------------------There is no solution");
			return;
		}
		
		for(int i = wayList.size() - 2; i >= 0; i--){
			Eneposition fk = wayList.get(i);
			//向上
			while(cat.getY() > fk.getY() * MyPanel.size){
				//cat.setBounds(cat.getX(), cat.getY() - MyPanel.size, MyPanel.size, MyPanel.size);
				cat.setLocation(cat.getX(), cat.getY() - MyPanel.size);
				Thread.sleep(sleepTime);
			}
			
			//向下
			while(cat.getY() < fk.getY() * MyPanel.size){
				//cat.setBounds(cat.getX(), cat.getY() + MyPanel.size, MyPanel.size, MyPanel.size);
				cat.setLocation(cat.getX(), cat.getY() + MyPanel.size);
				Thread.sleep(sleepTime);
			}
			
			//向左
			while(cat.getX() > fk.getX() * MyPanel.size){
				//cat.setBounds(cat.getX() - MyPanel.size, cat.getY(), MyPanel.size, MyPanel.size);
				cat.setLocation(cat.getX() - MyPanel.size, cat.getY());
				Thread.sleep(sleepTime);
			}
			
			//向右
			while(cat.getX() < fk.getX() * MyPanel.size){
				//cat.setBounds(cat.getX() + MyPanel.size, cat.getY(), MyPanel.size, MyPanel.size);
				cat.setLocation(cat.getX() + MyPanel.size, cat.getY());
				Thread.sleep(sleepTime);
			}
			

			this.repaint();
			
		}
		System.out.println("寻路结束！");
		punishment p = new punishment();
	}
	
	public static void getZhangAiList(){
		Map map = new Map();
		for(int i = 0 ; i<20;i++){
			for(int j = 0; j < 21 ;j++){
				if(map.getLocation(i,j) == 1){
					int x = i;
					int y = j;
					Eneposition wall = new Eneposition(x,y);
					zhangaiList.add(wall);
				}
				else if(map.getLocation(i,j) == 2){
					int x = i;
					int y = j;
					Eneposition coin = new Eneposition(x,y);
					CoinList.add(coin);
					System.out.print(i+"+"+j);
				}
				else if(map.getLocation(i, j)==3){
					int x = i;
					int y = j;
					Eneposition sta = new Eneposition(x,y);
					StaList.add(sta);
				}
			}
		}
	}

}
