package game;


public class EnemyBlock {
    public EnemyBlock(){}

    public EnemyBlock(int x,int y){
		this.x = x;
		this.y = y;
    }
    
    public EnemyBlock(int x,int y, EnemyBlock fk){
		this.x = x;
		this.y = y;
		this.previousFK = fk;
    }
    
    static public final int size = 25;
	public int x;//x position of the enemy
	public int y;//y position of the enemy
	// the value in appling a star alogoritiom
	private int F;
	private int G;
	private int H;
	private EnemyBlock previousFK;
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
	public EnemyBlock getPreviousFK() {
		return previousFK;
	}
	public void setPreviousFK(EnemyBlock previousFK) {
		this.previousFK = previousFK;
    }
    
    @Override
	public boolean equals(Object obj) {
		if(((EnemyBlock)obj).getX() == this.x && ((EnemyBlock)obj).getY() == this.y){
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
