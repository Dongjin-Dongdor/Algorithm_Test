/**
 * Created by dongdor on 2017. 2. 26..
 */

import java.util.Scanner;
public class Pinary_Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] pinary = new int[N][2];


        pinary[1][1] = 1;


        for(int i = 2; i<N; i++) {
            pinary[i][0] = pinary[i - 1][1] + pinary[i - 1][0];
            pinary[i][1] = pinary[i - 1][0];
        }

        int result = pinary[N-1][0]+pinary[N-1][1];
        System.out.println(result);


    }

}
