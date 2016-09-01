/**
 * Created by dongdor on 2016. 9. 1..
 */

import java.util.Stack;
public class binaryGap {


    static int maxCount = 0;
    static int count = 0;
    public int solution(int N) {


        int binaryNum;
        int gap;
        Stack<Integer> st = new Stack<Integer>();

        while(N != 0){
            binaryNum = N%2;
            N = N/2;
            st.push(binaryNum);
        }


        gap = findGap(st);
        System.out.println(gap);
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

                }

                return findGap(st);
            }
            else{
                count++;

                return findGap(st);

            }
        }

    }
}
