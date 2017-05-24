/**
 * Created by dongdor on 2017. 4. 15..
 */


import java.util.*;
public class Dice_Main {

    public static final int RIGHT = 1;
    public static final int LEFT = 2;
    public static final int UP = 3;
    public static final int DOWN = 4;
    public static int dX;
    public static int dY;
    public static Dice dice;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int temp;
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N][M];
        dX = sc.nextInt();
        dY = sc.nextInt();
        int i_size = sc.nextInt();
        int[] instruction = new int[i_size];
        for(int i = 0; i<N ; i++){
            for(int j = 0; j<M; j++){
                map[i][j] = sc.nextInt();
            }
        }
        dice  = new Dice(0, 0, 0, 0, 0, 0);
        for(int i = 0; i < i_size; i++){
            instruction[i] = sc.nextInt();

        }
        for(int i = 0; i<i_size; i++){
            Dice newDice = new Dice(dice.top, dice.bottom, dice.east, dice.west, dice.south, dice.north);
            move(instruction[i], newDice.top, newDice.bottom, newDice.east, newDice.west, newDice.south, newDice.north);
            if(map[dX][dY] != 0){
                dice.bottom = map[dX][dY];
                map[dX][dY] = 0;
            }
            //0이면
            else{
                map[dX][dY] = dice.bottom;
            }
            System.out.println(dice.top);
        }





    }

    public static void move(int direction, int top, int bottom, int east, int west, int south, int north ){

        switch(direction){

            case RIGHT :
                dY += 1;
                dice.top = west;
                dice.bottom = east;
                dice.east = top;
                dice.west = bottom;
                dice.south = south;
                dice.north = north;
                break;

            case LEFT :
                dY -= 1;
                dice.top = east;
                dice.bottom = west;
                dice.east = bottom;
                dice.west = top;
                dice.south = south;
                dice.north = north;
                break;

            case UP :
                dX -= 1;
                dice.top = north;
                dice.bottom = south;
                dice.east = east;
                dice.west = west;
                dice.south = top;
                dice.north = bottom;
                break;


            case DOWN :
                dX += 1;
                dice.top = south;
                dice.bottom = north;
                dice.east = east;
                dice.west = west;
                dice.south = bottom;
                dice.north = top;
                break;




        }

    }
}

class Dice{

    int top;
    int bottom;
    int east;
    int west;
    int south;
    int north;
    public Dice(int top, int bottom, int east, int west, int south, int north){
        this.top = top;
        this.bottom = bottom;
        this.east = east;
        this.west = west;
        this.south = south;
        this.north = north;
    }

}
