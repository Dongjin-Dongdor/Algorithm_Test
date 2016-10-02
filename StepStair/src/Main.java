/**
 * Created by dongdor on 2016. 9. 30..
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        int n;
        int[][] dp = new int[300][3];
        int[] score = new int[300];

        Scanner sc = new Scanner(System.in);
        //n 은 계단의 개수이다
        n = sc.nextInt();
        sc.nextLine();
        for(int i = 1; i <= n; i++){
            score[i] = sc.nextInt();
            sc.nextLine();
        }

        //첫번째 계단의 점수 최대값은 그냥 첫번째 점수의 값이 계산

        dp[1][1] = dp[1][2] = score[1];

        for(int i = 2; i<=n; i++){

            dp[i][1] = dp[i - 1][2] + score[i];
            dp[i][2] = max(dp[i - 2][1],dp[i - 2][2]) + score[i];

        }

        System.out.println(max(dp[n][1],dp[n][2]));


   }

   public static int max(int num1, int num2){

       if(num1>=num2){
           return num1;
       }
       else{
           return num2;
       }

   }


}
