/**
 * Created by dongdor on 2017. 4. 8..
 */

import java.util.Scanner;
public class TestMonitor_Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int classNum = sc.nextInt();
        int[] A = new int[classNum+1];
        long[] DP = new long[classNum+1];
        for(int i = 0; i < classNum; i++){

            A[i] = sc.nextInt();

        }
        int B = sc.nextInt();
        int C = sc.nextInt();
        for(int i = 1; i<=classNum; i++){
            //주감독관으로 충분히 모든 아이들을 관리할 수 있을 떄
            if(A[i]-B>0) {
                if(A[i]-B % C != 0){
                    DP[i] = DP[i-1] + (A[i]-B)/C + 2;
                }
                else DP[i] = DP[i-1] + (A[i]-B)/C + 1;
            }
            else DP[i] = DP[i-1] + 1;
        }
        System.out.println(DP[classNum]);
    }
}
