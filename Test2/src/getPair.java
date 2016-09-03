/**
 * Created by dongdor on 2016. 9. 3..
 */
public class getPair {

    public static void main(String[] args){

        int[] array = new int[6];
        array[0] = 3;
        array[1] = 5;
        array[2] = 6;
        array[3] = 3;
        array[4] = 3;
        array[5] = 5;

        int result = solution(array);
        System.out.println(result);
    }
    public static int solution(int[] A) {
        int count = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = i+1; j < A.length; j++){
                if(A[i] == A[j]){
                    count++;
                }
            }
        }
        return count;
        // write your code in Java SE 8
    }
}
