/**
 * Created by dongdor on 2017. 3. 13..
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
public class GreedyPanda_Main {


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] panda = new int[N][N];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){

                panda[i][j] = sc.nextInt();

            }
        }

        int tmp = 0;

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                System.out.println("panda position : "+panda[i][j]);
                tmp = get_max(tmp, greedyPanda(0, i, j, panda));
                System.out.println("max : "+tmp);

            }
        }

        System.out.println(tmp);


    }

    public static int get_max(int n1, int n2){

        return n1>n2?n1:n2;

    }

    public static int greedyPanda(int max, int x, int y, int[][] pandaV){

        //왼쪽으로 이동
        if(y-1>0 && pandaV[x][y] < pandaV[x][y-1]){
            pandaV[x][y] = 0;
            return get_max(max+1, greedyPanda(max+1, x, y-1, pandaV));
        }

        //오른쪽으로 이동
        if(y+1<pandaV.length && pandaV[x][y] < pandaV[x][y+1]){
            pandaV[x][y] = 0;
            return get_max(max+1, greedyPanda(max+1, x, y+1, pandaV));
        }

        //위로 이동
        if(x-1>0 && pandaV[x][y] < pandaV[x-1][y]){
            pandaV[x][y] = 0;
            return get_max(max+1, greedyPanda(max+1, x-1, y,pandaV));
        }
        //아래로 이동
        if(x+1<pandaV.length && pandaV[x][y] < pandaV[x+1][y]){
            pandaV[x][y] = 0;
            return get_max(max+1, greedyPanda(max+1, x+1, y, pandaV));
        }
        else{
            return max;
        }

    }
}
