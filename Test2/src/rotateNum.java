/**
 * Created by dongdor on 2016. 9. 2..
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class rotateNum {

    static Queue<Integer> queue;
    static Stack<Integer> stack;

    public static void main(String[] args){


        queue = new LinkedList<Integer>();
        int[] A = {3,8,9,7,6};
        solution(A,3);
    }
    static int[] solution(int[] A, int K) {
        // write your code in Java SE 8

        for(int i = A.length -1; i>=0; i--){
            queue.add(A[i]);
        }

        for(int i = 0; i < K; i++){
            int tmp = queue.poll();

            queue.add(tmp);
        }

        for(int i = A.length -1; i>= 0; i--){

            A[i] =  queue.poll();

        }

        return A;
    }


}
