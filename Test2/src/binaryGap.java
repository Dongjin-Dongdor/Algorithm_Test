/**
 * Created by dongdor on 2016. 9. 1..
 */

import java.util.Stack;
public class binaryGap {

    public static void main(String[] args){
        int kk;

        kk = solution(141);

    }

    static int maxCount = 0;
    static int count = 0;
    public static int solution(int N) {


        int binaryNum;
        int gap;
        Stack<Integer> st = new Stack<Integer>();

        while(N != 0){
            binaryNum = N%2;
            N = N/2;
            st.push(binaryNum);

        }

        gap = findGap(st);

        return gap;
    }

    public static int findGap(Stack<Integer> st){
        if(st.isEmpty()){
            return maxCount;
        }
        else{
            if(st.pop() == 1){
                if(count > maxCount){
                    maxCount = count;
                    count = 0;
                    System.out.println("here");
                }
                return findGap(st);
            }
            else{
                count++;
                System.out.println("count : "+count);
                System.out.println("maxCount : "+maxCount);
                return findGap(st);

            }
        }

    }
}
