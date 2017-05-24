/**
 * Created by dongdor on 2017. 3. 8..
 */

import java.util.Scanner;
public class Zoo_Main {


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] zoo = new int[N][3];

        zoo[0][0] = 1;
        zoo[0][1] = 1;
        zoo[0][2] = 1;


        for(int i = 1; i<N; i++){

            zoo[i][0] = (zoo[i-1][0] + zoo[i-1][1] + zoo[i-1][2]) % 9901;
            zoo[i][1] = (zoo[i-1][0] + zoo[i-1][2]) % 9901;
            zoo[i][2] = (zoo[i-1][0] + zoo[i-1][1]) % 9901;

        }

        int result = (zoo[N-1][0] + zoo[N-1][1] + zoo[N-1][2])%9901;

        System.out.println(result);
    }
}
