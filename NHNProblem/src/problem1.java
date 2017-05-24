/**
 * Created by dongdor on 2016. 10. 9..
 */

import java.util.Scanner;

public class problem1 {

    static int[] array;
    static int count;
    static int[] result_array;
    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");


        array = new int[inputs.length];
        count = 1;

        for(int i = 0; i< inputs.length; i++){
            array[i] = Integer.parseInt(inputs[i]);
            count *= i+1;
        }

        result_array = new int[count];
        System.out.println(count);


        dp(array, 0, inputs.length, inputs.length);
        for(int i = 0; i < result_array.length; i++){
            System.out.println(result_array[i]);
        }

    }

    public static void dp(int[] arr, int depth, int n, int k){ // n은 배열안에 개수 k는 몇 개를 뽑을 것인지

        if(depth == k){
            print(arr);
            return;
        }
        for(int i = depth; i<n; i++){
            swap(arr, i, depth);
            dp(arr, depth + 1,n,k);
            //swap(arr, i,depth);
        }
    }
    public static void swap(int[] arr,int a1, int a2){
        int tmp = arr[a1];
        arr[a1] = arr[a2];
        arr[a2] = tmp;
    }

    public static void print(int[] arr){

        String numS = new String();
        for(int i = 0; i < arr.length; i++){
            numS += String.valueOf(arr[i]);
        }

        int num = Integer.parseInt(numS);
        //System.out.println(num);
        count--;

        result_array[count] = num;

    }
}
