
import java.awt.Graphics;
import javax.swing.JPanel;
 
/**
 * 背景panel，用于划线
 * @author Administrator
 *
 */
public class BackGroundPanel extends JPanel{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 8195337324862727029L;
	
	public BackGroundPanel(){
		this.setLayout(null);
	}
	
	public void paintComponent(Graphics graphics){
		super.paintComponent(graphics);
		graphics.drawLine(50, 0, 50, 700);
		graphics.drawLine(100, 0, 100, 700);
		graphics.drawLine(150, 0, 150, 700);
		graphics.drawLine(200, 0, 200, 700);
		graphics.drawLine(250, 0, 250, 700);
		graphics.drawLine(300, 0, 300, 700);
		graphics.drawLine(350, 0, 350, 700);
		graphics.drawLine(400, 0, 400, 700);
		graphics.drawLine(450, 0, 450, 700);
		graphics.drawLine(500, 0, 500, 700);
		graphics.drawLine(550, 0, 550, 700);
		graphics.drawLine(600, 0, 600, 700);
		graphics.drawLine(650, 0, 650, 700);
		graphics.drawLine(700, 0, 700, 700);
		graphics.drawLine(750, 0, 750, 700);
		graphics.drawLine(800, 0, 800, 700);
		
		graphics.drawLine(0, 50, 850, 50);
		graphics.drawLine(0, 100, 850, 100);
		graphics.drawLine(0, 150, 850, 150);
		graphics.drawLine(0, 200, 850, 200);
		graphics.drawLine(0, 250, 850, 250);
		graphics.drawLine(0, 300, 850, 300);
		graphics.drawLine(0, 350, 850, 350);
		graphics.drawLine(0, 400, 850, 400);
		graphics.drawLine(0, 450, 850, 450);
		graphics.drawLine(0, 500, 850, 500);
		graphics.drawLine(0, 550, 850, 550);
		graphics.drawLine(0, 600, 850, 600);
		graphics.drawLine(0, 650, 850, 650);
	}
 
}
 
 
 
package com.leq.singlepart.autofindway.bean;
 
 
/**
 * 将地图按照size尺寸分割成网格，用来自动寻路
 * @author Administrator
 *
 */
public class FangKuaiPosition {
	public FangKuaiPosition(){}
	
	/**
	 * 根据方块坐标生成方块（这里的坐标指的是网格坐标,不是像素坐标）
	 * @param x	x方向的方块单位（即x方向像素/size）
	 * @param y	y方向的方块单位（即y方向像素/size）
	 */
	public FangKuaiPosition(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 根据方块坐标生成方块（这里的坐标指的是网格坐标）
	 * @param x	x方向的方块单位（即x方向像素/size）
	 * @param y	y方向的方块单位（即y方向像素/size）
	 * @param fk	前一个方块（父级方块）
	 */
	public FangKuaiPosition(int x,int y, FangKuaiPosition fk){
		this.x = x;
		this.y = y;
		this.previousFK = fk;
	}
	
	/**
	 * 根据jpanel生成方块
	 * @param myPpanel	mypanel对象
	 */
	public FangKuaiPosition(MyPanel myPpanel){
		this.x = myPpanel.getX() / MyPanel.size;
		this.y = myPpanel.getY() / MyPanel.size;
	}
	
	static public final int size = 50;//一个方块单位为50像素
	private int x;//x方向的方块单位（即x方向像素/size）
	private int y;//y方向的方块单位（即y方向像素/size）
	private int F;//和值，G+H
	private int G;//该点到出发点的移动量
	private int H;//该店到目的点的估算移动辆
	private FangKuaiPosition previousFK;//父节点
	public int getF() {
		return F;
	}
	public void setF(int f) {
		F = f;
	}
	public int getG() {
		return G;
	}
	public void setG(int g) {
		G = g;
	}
	public int getH() {
		return H;
	}
	public void setH(int h) {
		H = h;
	}
	public FangKuaiPosition getPreviousFK() {
		return previousFK;
	}
	public void setPreviousFK(FangKuaiPosition previousFK) {
		this.previousFK = previousFK;
	}
	
	/**
	 * 重写equals方法，判断两个网格是否相等，比较这两个网格的X和Y是否相等
	 */
	@Override
	public boolean equals(Object obj) {
		if(((FangKuaiPosition)obj).getX() == this.x && ((FangKuaiPosition)obj).getY() == this.y){
			return true;
		}else{
			return false;
		}
	}
	
	public int getX() {
		return x;
	}
 
	public void setX(int x) {
		this.x = x;
	}
 
	public int getY() {
		return y;
	}
 
	public void setY(int y) {
		this.y = y;
	}
}
 
 
package com.leq.singlepart.autofindway.bean;
 
import javax.swing.JPanel;
/**
 * 自定义JPanel类
 * @author Administrator
 *
 */
public class MyPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//定义panel的默认size为50像素
	public final static int size = 50;
	
	
	public MyPanel(){}
	
	/**
	 * 根据方块的位置设置panel的位置属性
	 * @param x	方块的X单位
	 * @param y	方块的Y单位
	 */
	public MyPanel(int x, int y){
		this.setBounds(x * size, y * size, size, size);
	}
	
	/**
	 * 根据fangkuaiposition类设置panel的位置属性
	 * @param fk	fangkuaiposition对象
	 */
	public MyPanel(FangKuaiPosition fk){
		this.setBounds(fk.getX() * size, fk.getY() * size, size, size);
	}
}
 
 
package com.leq.singlepart.autofindway.core;
 
import java.util.ArrayList;
import java.util.List;
 
import com.leq.singlepart.autofindway.bean.FangKuaiPosition;
import com.leq.singlepart.autofindway.bean.MyPanel;
/**
 * 获取线路
 * G:起点到当前点的消耗（当前点G= 上一个点的G + 1）
 * H:当前点到终点的消耗（详见toGetH）
 * F:G+H
 * @author Administrator
 *
 */
public class AutoFindWay {
	public static FangKuaiPosition beginFk = null;
	public static FangKuaiPosition endFk = null;
	public static void main(String[] args) {
		AutoFindWay afw = new AutoFindWay();
		MyPanel cat = new MyPanel(4,6);
		MyPanel fish = new MyPanel(10,10);
		afw.getWayLine(cat,fish);
	}
	
	/**
	 * 获取路线方法入口
	 * @param cat	起点
	 * @param fish	终点
	 * @return	路线集合List<FangKuaiPosition>
	 */
	public List<FangKuaiPosition> getWayLine(MyPanel cat, MyPanel fish){
		//定义返回的结果
		List<FangKuaiPosition> wayList = new ArrayList<>();
		//中心方块的四周方块集合
		List<FangKuaiPosition> tmpList = null;
		
		//将起点和终点转换为fangkuaiposition对象
		beginFk = new FangKuaiPosition(cat);
		beginFk.setG(0);
		endFk = new FangKuaiPosition(fish);
		
		//获取中心方块（起点）四周的方块
		
		tmpList = aroundFk(beginFk);
		//如果四周没有符合条件的方块，则说明是死路
		if(tmpList == null || tmpList.size() == 0){
			return wayList;
		}
		//放入openlist中，作为向外扩散的中心方块
		BasePanel.openList.addAll(tmpList);
		
		//遍历openlist，以每个方块作为中心方块，向外扩散
		for(int i = 0; i < BasePanel.openList.size(); i++){
			//获取新的中心方块，并获取四周方块
			FangKuaiPosition tmpFk = BasePanel.openList.get(i);
			tmpList = aroundFk(tmpFk);
			
			//周围方块为空，说明 是死路，继续下一个 方块
			if(tmpList == null || tmpList.size() == 0){
				//如果openlist已经遍历完了，都没有四周方块，则要在for循环外面判断waylist是否包含终点，
				//如果不包含，则到达不了终点
				continue;
			}
			
			//如果周围方块包括终点方块，则结束寻路
			if(tmpList.contains(endFk)){
				//如果四周方块包含终点，则将终点添加到closelist中，并跳出openlist循环（已经到达终点）
				for(FangKuaiPosition obj : tmpList){
					if(obj.equals(endFk)){
						BasePanel.closedList.add(obj);
						break;
					}
				}
				break;
			}
			
			/**
			 * 将中心方块的周围方块添加到openlist集合
			 * 注意：如果openlist中已经存在，则 需要将消耗最少的方块更新到 openlist中
			 */
			for(FangKuaiPosition fk : tmpList){
				if(BasePanel.openList.contains(fk)){
					for(FangKuaiPosition openFk : BasePanel.openList){
						if(openFk.equals(fk)){
							if(openFk.getG() > fk.getG()){
								openFk.setG(fk.getG());
								openFk.setF(openFk.getG() + openFk.getH());
								openFk.setPreviousFK(fk.getPreviousFK());
								break;
							}
						}
					}
				}else{
					BasePanel.openList.add(fk);
				}
			}
			
			//删掉openlist中的当前中心方块，继续获取并处理下一个
			BasePanel.openList.remove(i);
			i--;
		}
		
		/**
		 * 从 closedlist中获取到路线
		 * 先获取终点，然后根据fangkuaiposition.previousFk获取上一个方块，一直获取到起点
		 */
		for(int i = 0; i < BasePanel.closedList.size(); i++){
			//如果wayList<=0,说明还没有获取到第一个方块(终点)；如果wayList>0,说明已经获取到第一个方块(终点)，则不用再执行下一个if语句
			if(wayList.size() > 0){
				if(wayList.get(wayList.size() - 1).getPreviousFK().equals(BasePanel.closedList.get(i))){
					wayList.add(BasePanel.closedList.get(i));
					//如果获取到的方块是起点，则跳出for循环
					if(BasePanel.closedList.get(i).equals(beginFk)){
						break;
					}
					//获取到一个方块后，将该方块从closedlist中删除，然后从0开始遍历closedlist找到第一个方块的previousfk。
					//所以需要赋值i=-1,因为continue的时候会执行一次i++
					BasePanel.closedList.remove(BasePanel.closedList.get(i));
					i = -1;
					
				}
				continue;
			}
			
			//第一个方块为终点，获取到一个方块后，将该方块从closedlist中删除，然后从0开始遍历closedlist找到第一个方块的previousfk。
			//所以需要赋值i=-1,因为continue的时候会执行一次i++
			if(BasePanel.closedList.get(i).equals(endFk)){
				wayList.add(BasePanel.closedList.get(i));
				BasePanel.closedList.remove(BasePanel.closedList.get(i));
				i = -1;
				continue;
			}
		}
		
		return wayList;
	}
	
	/**
	 * 获取周围方块
	 * ①判断是否超越边界
	 * ②判断是否是障碍物/已计算过的方块
	 * @param fk	中心方块 
	 * @return	周围方块结集合
	 */
	public List<FangKuaiPosition> aroundFk(FangKuaiPosition fk){
		if(fk.getX() == 10 && fk.getY() == 11){
			System.out.println(".....");
		}
		List<FangKuaiPosition> list = new ArrayList<FangKuaiPosition>();
		//判断上面的方块是否符合条件
		//判断是否超过越边界
		if(fk.getY() - 1 >= 0){
			FangKuaiPosition tmpFk = new FangKuaiPosition(fk.getX(), fk.getY() - 1, fk);
			//判断是否是障碍物/已计算过的方块
			if(!BasePanel.zhangaiList.contains(tmpFk) 
					&& !BasePanel.closedList.contains(tmpFk)){
				list.add(tmpFk);
			}
		}
		
		//判断下面的方块是否符合条件
		if(fk.getY() + 1 < BasePanel.heightLength){
			FangKuaiPosition tmpFk = new FangKuaiPosition(fk.getX(), fk.getY() + 1, fk);
			if(!BasePanel.zhangaiList.contains(tmpFk) 
					&& !BasePanel.closedList.contains(tmpFk)){
				list.add(tmpFk);
			}
		}
		
		//判断左面的方块是否符合条件
		if(fk.getX() - 1 >= 0){
			FangKuaiPosition tmpFk = new FangKuaiPosition(fk.getX() - 1, fk.getY(), fk);
			if(!BasePanel.zhangaiList.contains(tmpFk) 
					&& !BasePanel.closedList.contains(tmpFk)){
				list.add(tmpFk);
			}
		}
		//判断右面的方块是否符合条件
		if(fk.getX() + 1 < BasePanel.widthLength){
			FangKuaiPosition tmpFk = new FangKuaiPosition(fk.getX() + 1, fk.getY(), fk);
			if(!BasePanel.zhangaiList.contains(tmpFk) 
					&& !BasePanel.closedList.contains(tmpFk)){
				list.add(tmpFk);
			}
		}
		
		//将中心方块添加到已处理过的集合中
		BasePanel.closedList.add(fk);
		getFGH(list,fk);
		return list;
	}
	
	/**
	 * 给集合中的每个方块计算出FGH的值
	 * @param list
	 */
	public void getFGH(List<FangKuaiPosition> list,FangKuaiPosition currFk){
		if(list != null && list.size() > 0){
			for(FangKuaiPosition fk : list){
				fk.setG(currFk.getG() + 1);
				fk.setH(toGetH(fk,endFk));
				fk.setF(fk.getG() + fk.getH());
			}
		}
	}
	
	/**
	 * 获取从一个方块到另一个方块的移动量（按方块个数计算）
	 * @param currentFangKuai
	 * @param targetFangKuai
	 * @return
	 */
	public int toGetH(FangKuaiPosition currentFangKuai,FangKuaiPosition targetFangKuai){
		int h = 0;
		h += Math.abs(currentFangKuai.getX() - targetFangKuai.getX());
		h += Math.abs(currentFangKuai.getY() - targetFangKuai.getY());
		return h;
	}
	
}
 
 
package com.leq.singlepart.autofindway.core;
 
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
 
import javax.swing.JFrame;
 
import com.leq.singlepart.autofindway.bean.BackGroundPanel;
import com.leq.singlepart.autofindway.bean.FangKuaiPosition;
import com.leq.singlepart.autofindway.bean.MyPanel;
/**
 * 自动寻路展示界面
 * @author Administrator
 *
 */
public class BasePanel extends JFrame{
	private static final long serialVersionUID = 1L;
	private static int beginX = 0;//jframe的x坐标
	private static int beginY = 0;//jframe的y坐标
	private static int frameWidth = 815;//jframe的宽
	private static int frameHeight = 635;//jframe的高
	private static int width = 800;//内部panel的宽
	private static int height = 600;//内部panel的高
	public static int widthLength = 16;//方块单位的y方向最大值
	public static int heightLength = 12;//方块单位的x方向最大值
	public static BackGroundPanel bgp = new BackGroundPanel();//容器panel，所有的方块都放入这个panel中，然后将这个panel添加到jframe中
	
	public static MyPanel cat = new MyPanel(0,0);//起点
	public static MyPanel fish = new MyPanel(ThreadLocalRandom.current().nextInt(widthLength),ThreadLocalRandom.current().nextInt(heightLength));//随机生成终点
	private final long sleepTime = 10;//方块自动移动的间隔时间
	
	public static List<FangKuaiPosition> zhangaiList = new ArrayList<>(); //地图上的障碍物/不可穿越地方的集合
	public static List<FangKuaiPosition> closedList = new ArrayList<>(); //已走过路线集合
	public static List<FangKuaiPosition> openList = new ArrayList<>(); //需要向外扩散的方块的集合
	
	public BasePanel(){
		//获取屏幕尺寸相关信息
		Dimension dimension = CommonUtil.getScreenSize();
		//设定JFrame基础属性 
		beginX = (int) (dimension.getWidth()/2-400);
		beginY = (int) (dimension.getHeight()/2-300);
		this.setBounds(beginX, beginY, frameWidth, frameHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		//起点panel
		cat.setBackground(Color.green);
		//终点panel
		fish.setBackground(Color.red);
		
		bgp.setBounds(0, 0, width, height);
		bgp.add(cat);
		bgp.add(fish);
		
		//将障碍物生成panel
		for(FangKuaiPosition fk : zhangaiList){
			MyPanel panel = new MyPanel(fk);
			panel.setBackground(Color.gray);
			bgp.add(panel);
		}
		
		this.add(bgp);
		this.repaint();
		this.setVisible(true);
	}
	
	public static void main(String[] args) throws InterruptedException {
		getZhangAiList();
		BasePanel bp = new BasePanel();
		AutoFindWay afw = new AutoFindWay();
		List<FangKuaiPosition> wayList = afw.getWayLine(cat, fish);
		bp.movePanel(wayList);
	}
	
	/**
	 * 方块移动
	 * @param wayList	移动路线
	 * @throws InterruptedException
	 */
	public void movePanel(List<FangKuaiPosition> wayList) throws InterruptedException{
		
		if(wayList == null || wayList.size() == 0){
			System.out.println("无法 到达终点 ！");
			return;
		}
		
		for(int i = wayList.size() - 2; i >= 0; i--){
			FangKuaiPosition fk = wayList.get(i);
			//向上
			while(cat.getY() > fk.getY() * MyPanel.size){
				cat.setBounds(cat.getX(), cat.getY() - 2, MyPanel.size, MyPanel.size);
				Thread.sleep(sleepTime);
			}
			
			//向下
			while(cat.getY() < fk.getY() * MyPanel.size){
				cat.setBounds(cat.getX(), cat.getY() + 2, MyPanel.size, MyPanel.size);
				Thread.sleep(sleepTime);
			}
			
			//向左
			while(cat.getX() > fk.getX() * MyPanel.size){
				cat.setBounds(cat.getX() - 2, cat.getY(), MyPanel.size, MyPanel.size);
				Thread.sleep(sleepTime);
			}
			
			//向右
			while(cat.getX() < fk.getX() * MyPanel.size){
				cat.setBounds(cat.getX() + 2, cat.getY(), MyPanel.size, MyPanel.size);
				Thread.sleep(sleepTime);
			}
			
		}
		System.out.println("寻路结束！");
	}
	
	/**
	 * 随机生成障碍方块
	 */
	public static void getZhangAiList(){
		
		//随机生成60个障碍方块
		while(zhangaiList.size() < 60){
			
			int x = ThreadLocalRandom.current().nextInt(widthLength);
			int y = ThreadLocalRandom.current().nextInt(heightLength);
			FangKuaiPosition fk = new FangKuaiPosition(x,y);
			//新生成的方块不能已存在zhangailist中，也不能喝起点/终点重合
			if(zhangaiList.contains(fk) || (cat.getX() == fk.getX()*MyPanel.size && cat.getY() == fk.getY() * MyPanel.size) 
					|| (fish.getX() == fk.getX() * MyPanel.size && fish.getY() == fk.getY() * MyPanel.size)){
				continue;
			}
			zhangaiList.add(fk);
		}
	}
	
}
 
 
package com.leq.singlepart.autofindway.core;
 
import java.awt.Dimension;
import java.awt.Toolkit;
 
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
 
/**
 * 工具类
 * @author Administrator
 *
 */
public class CommonUtil {
	/**
	 * 获取屏幕尺寸
	 * @return	Dimension    
	 * Dimension.getWidth()     
	 * Dimension.getHeight()
	 */
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
————————————————
版权声明：本文为CSDN博主「刘大神仙」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/leq3915/article/details/80714902

