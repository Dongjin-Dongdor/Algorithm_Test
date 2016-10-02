/**
 * Created by dongdor on 2016. 10. 3..
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        int[] count = new int[2];

        Scanner sc = new Scanner(System.in);
        int tCase = sc.nextInt();
        sc.nextLine();

        int[] tCaseArray = new int[tCase];

        for(int i = 0; i<tCase; i++ ){
            tCaseArray[i] = sc.nextInt();
            sc.nextLine();
        }
        for(int i = 0; i<tCase; i++){
            fibonacci(tCaseArray[i],count);
            System.out.println(count[0]+" "+count[1]);
            count[0] = 0;
            count[1] = 0;
        }

    }

    public static int fibonacci(int n,int[] count){

        if(n == 0){
            count[0] += 1;
            return 0;
        }

        else if(n == 1){
            count[1] += 1;
            return 1;
        }

        else
            return fibonacci(n-1,count) + fibonacci(n-2,count);


    }
}
