/**
 * Created by dongdor on 2017. 4. 16..
 */

import java.util.*;
public class RegisterClass_Main {

    static int M;
    static int N;
    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[] classCredit = new int[N];

        for(int i = 0; i < N; i++){

            classCredit[i] = sc.nextInt();
        }

        int result = credit(classCredit, 0, 0);
        System.out.println(result);


    }

    public static int credit(int[] classCredit, int sum, int count){
        System.out.println(sum);
        if(sum > M){
            return 0;
        }
        if(sum <= M){
            System.out.println("hrer");
            return sum;
        }
        if(count > N-1){
            return 0;
        }
        return Math.max(credit(classCredit, sum+classCredit[count], count+1), credit(classCredit, sum, count+1));
    }
}
