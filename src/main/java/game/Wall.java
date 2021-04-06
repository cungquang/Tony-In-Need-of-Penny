package game;

import java.awt.*;

import game.PrizeFactory;
import game.PrizeType;

public class Wall {
    private static int blockDimension;
    private static int numBlocks;
    private static final int SIZE = blockDimension * numBlocks;

    private int px; 
    private int py;
    private int width;
    private int height;

    protected static int[][] maze = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,3,0,0,0,1,0,0,2,2,2,0,2,0,1,0,0,0,3,1},
        {1,0,1,1,0,0,0,1,1,0,1,1,1,0,1,0,1,1,1,1},
        {1,0,1,0,0,1,0,1,0,0,0,0,3,0,0,0,0,0,2,1},
        {1,0,1,0,1,1,0,1,0,1,1,1,0,1,1,1,0,1,0,1},
        {1,0,1,0,0,1,2,2,0,0,0,1,0,1,0,0,0,1,0,1},
        {1,0,1,1,0,0,0,1,1,1,0,1,0,0,2,1,1,1,0,1},
        {1,0,0,0,0,1,0,1,0,0,3,1,0,1,0,1,0,0,0,1},
        {1,1,1,0,1,1,0,0,0,1,0,1,0,1,2,2,0,1,0,1},
        {1,1,2,2,0,1,0,1,0,1,0,1,0,1,1,0,1,1,0,1},
        {1,2,2,1,0,0,0,1,0,1,0,1,0,0,1,0,1,0,0,1},
        {1,0,1,1,1,1,0,1,0,0,0,1,1,0,1,0,0,0,1,1},
        {1,0,1,0,0,0,0,1,0,1,0,2,2,0,0,0,1,0,0,1},
        {1,0,1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1},
        {1,2,0,0,2,2,0,1,0,1,0,0,0,0,0,0,0,0,3,1},
        {1,0,1,0,1,0,0,0,0,0,0,1,1,0,1,1,1,1,0,1},
        {1,2,1,0,1,1,1,1,0,1,1,1,1,0,1,1,0,0,0,1},
        {1,0,1,0,0,0,0,2,0,0,0,1,0,2,2,0,0,1,0,1},
        {1,2,1,1,1,0,1,1,1,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,2,2,0,0,0,2,2,0,0,1,0,0,0,2,2,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}

    };

    /*-----------------------------------Reward & Bonus Object-----------------------------------*/
   
    private PrizeFactory prizefactory = new PrizeFactory();                 //Factory to create [Reward] or [Bonus]
    private int NUM_PRIZE[] = new int[2];                                   //Number of prize: 0 - [Bonus], 1 - [Reward]
    private PrizeType bonustype = PrizeType.bonus;                          //Enum type [Bonus]
    private PrizeType rewardtype = PrizeType.reward;                        //Enum type [Reward]              
    private final int PRIZE_VALUE = 5;                                      //Base value of prize object

    /*-----------------------------------Reward & Bonus Object-----------------------------------*/


    public Wall(int mapWidth, int mapHeight, int blockSize, int numBlocks) {
        px = 0;
        py = 0;
        width = mapWidth;
        height = mapHeight;
        blockDimension = blockSize;
        numBlocks = numBlocks;
    }

    public void draw(Graphics g) {
        for(int i = 0; i < maze[0].length; i++) {
            for(int j = 0; j < maze.length; j++) {
                if(maze[j][i] == 1) {
                    g.setColor(Color.BLACK);
                    g.fillRect(i * blockDimension,j * blockDimension,blockDimension,blockDimension);
                } else if(maze[j][i] == 0) {
                    g.setColor(Color.GRAY);
                    g.fillRect(i * blockDimension,j * blockDimension,blockDimension,blockDimension);
                } else if(maze[j][i] == 2) {
                    g.setColor(Color.GRAY);
                    g.fillOval(i * blockDimension + 12, j * blockDimension + 12,5,5);
                } else if(maze[j][i] == 3) {
                    g.setColor(Color.GRAY);
                    g.fillOval(i * blockDimension + 8, j * blockDimension + 8,11,11);
                }
            }
        }
    }

    public void reset() {
        for (int i = 0; i < maze[0].length; i++) {
            for (int j = 0; j < maze.length; j++) {
                if (maze[j][i] == 5) {
                    maze[j][i] = 2;
                } else if (maze[j][i] == 6) {
                    maze[j][i] = 5;
                } else if(maze[j][i] == 7) {
                    maze[j][i] = 4;
                }
            }
        }
    }

    public static int[][] getMaze() {
        return maze;
    }

    public int getLocation(int x, int y) {
        return maze[y][x];
    }



    /*-----------------------------------Reward & Bonus Object-----------------------------------*/
    /*
    CountPrize()
    pre-cond: none
    post-cond: count number of [Bonus] and [Reward] on the maze
    */
    public void CountPrize(){
        int num_prize[] = {0,0};

        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[0].length; j++) {
                //Count Number of Bonus
                if(maze[i][j] == 3){
                    num_prize[0]++;
                }

                //Count Number of Reward
                if(maze[i][j] == 2){
                    num_prize[1]++;
                }
            }
        }
        this.NUM_PRIZE = num_prize;
    }

    /*
    NoOfPrize()
    Pre-cond: none
    Post-cond: return number of: index 0 is [Bonus] - index 1 is [Reward]
    */
    public int[] NoOfPrize(){
        this.CountPrize();
        return NUM_PRIZE;
    }


    /*
    GetBonusArray()
    Pre-cond: none
    Post-cond: return an array of Bonus object
    */
    public Prize[] GetBonusArray(){
        Prize bonusArr[]= new Prize[NUM_PRIZE[0]];
        int bonusEle = 0;

        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[0].length; j++) {
                if(maze[i][j] == 3){
                    bonusArr[bonusEle] = prizefactory.createPrize(bonustype, i, j, PRIZE_VALUE);
                    bonusEle++;
                }
            }
        }

        return bonusArr;
    }


    /*
    GetRewardArray()
    Pre-cond: none
    Post-cond: return an array of Reward object
    */
    public Prize[] GetRewardArray(){
        Prize rewardArr[]= new Prize[NUM_PRIZE[1]];
        int rewardEle = 0;

        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[0].length; j++) {
                if(maze[i][j] == 2){
                    rewardArr[rewardEle] = prizefactory.createPrize(rewardtype, i, j, PRIZE_VALUE);
                    rewardEle++;
                }
            }
        }

        return rewardArr;
    }
}