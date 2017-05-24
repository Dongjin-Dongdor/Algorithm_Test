/**
 * Created by dongdor on 2017. 3. 25..
 */


/**
 *
 * 욕심쟁이 팬더(#1937)
 *
 * N*N의 대나무 숲이 있다 팬더새끼는 한곳에 대나무를 다 먹으면 다음 장소로 이동한다
 * 이때 팬더는 무조건 기존 위치보다 더 많은 대나무가 있는 곳으로 이동한다.
 * 그렇지않으면 팬더는 굻어죽는다
 * 그렇다면 N*N의 대나무숲의 어디에 팬더를 위치시켜야 오래 살아 남을까
 *
 *  14 9 12 10
 *  1 11 5 4
 *  7 15 2 13
 *  6 3 16 8
 *

 */



import java.util.Scanner;
public class GreedyPanda2_Main {

    private int size;
    private int Max;
    private int[][] forest;

    private final int[] cX = {0,1,0,-1};
    private final int[] cY = {1,0,-1,0};


    public GreedyPanda2_Main(int size, int[][] forest){

        this.size = size;
        this.Max = size*size;
        this.forest = forest;

    }

    public int getMaximumAliveDay(){

        int result = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){

                result = max(result, findMaximumPath(i, j));
                if(result == this.Max){
                    return result;
                }

            }
        }
        return result;

    }

    public int findMaximumPath(int x, int y){
        int result = 1;
        int nextX, nextY;

        for(int i = 0; i < 4; i++){

            nextX = x + cX[i];
            nextY = y + cY[i];

            if(inForest(nextX, nextY) && forest[x][y] < forest[nextX][nextY]) {
                result = max(result, findMaximumPath(nextX, nextY) + 1);
            }
        }
        return result;

    }

    private boolean inForest(int x, int y){

        return (x<size && 0<=x && y<size && 0<=y);

    }



    public int max(int i1, int i2){

        return i1<i2?i2:i1;

    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] forest = new int[N][N];
        for(int i=0; i<N; i++ ){
            for(int j=0; j<N; j++){
                    forest[i][j] = sc.nextInt();
            }
        }

        GreedyPanda2_Main g2M = new GreedyPanda2_Main(forest.length, forest);
        int result = g2M.getMaximumAliveDay();
        System.out.println(result);

    }



}
