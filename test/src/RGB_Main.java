/**
 * Created by dongdor on 2016. 11. 27..
 */

import java.util.Scanner;

public class RGB_Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 주택 수
        int [][] cost = new int[3][N];
        cost[0][0] = sc.nextInt();
        cost[1][0] = sc.nextInt();
        cost[2][0] = sc.nextInt();

        final int R = 0;
        final int G = 1;
        final int B = 2;

        for(int i = 1; i<N; i++){
            cost[R][i] = sc.nextInt();
            cost[G][i] = sc.nextInt();
            cost[B][i] = sc.nextInt();

            cost[R][i] = cost[R][i] + min(cost[G][i-1], cost[B][i-1]);
            cost[G][i] = cost[G][i] + min(cost[R][i-1], cost[B][i-1]);
            cost[B][i] = cost[B][i] + min(cost[R][i-1], cost[G][i-1]);
        }
        int result = min(cost[R][N-1],min(cost[G][N-1],cost[B][N-1]));
        System.out.println("dongdor : "+result);


    }

    static int min(int p1, int p2){
        return (p1>p2) ? p2 : p1;
    }


}
/**
 *
26  40  83

49  60  57

13  89  99





*
**/






