/**
 * Created by dongdor on 2016. 10. 1..
 */


import java.util.Scanner;
public class Main {

    static int openLength;
    static int[] openOrder;
    static int[][][] dp;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int closetCount = sc.nextInt(); //벽장 개수
        sc.nextLine();
        String[] index = sc.nextLine().split(" ");
        int cOpen1 = Integer.parseInt(index[0]); // 초기 벽장문1
        int cOpen2 = Integer.parseInt(index[1]); // 초기 벽장문2

        openLength = sc.nextInt(); //문 열고 닫을 횟수
        openOrder = new int[openLength];

        for(int i = 0; i< openLength; i++){

            openOrder[i] = sc.nextInt();
            sc.nextLine();

        }
        int result;
        result = dp(0, cOpen1, cOpen2);
        System.out.println(result);

    }

    public static int dp(int position, int open1, int open2){

        if(position == openLength){
            return 0;
        }
        if(dp[position][open1][open2] != 0){
            return dp[position][open1][open2];
        }

        return min(Math.abs(openOrder[position] - open1) + dp(position + 1, openOrder[position] , open2) ,
                Math.abs(openOrder[position] - open2) + dp(position + 1, open1 , openOrder[position]) );
    }

    public static int min(int a, int b){
        if(a>b) return b;
        else return a;
    }


}


