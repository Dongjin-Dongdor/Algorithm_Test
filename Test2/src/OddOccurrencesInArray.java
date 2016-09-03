/**
 * Created by dongdor on 2016. 9. 3..
 */
public class OddOccurrencesInArray {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int[] oddCheck = new int[A.length];

        int count = 1;

        for(int i = 0; i < A.length; i++){
            oddCheck[i] = count;
        }
        int result = 0;
        for(int i = 0; i < A.length; i++){
            if(oddCheck[i] != -1){
                for(int j = i+1; j < A.length; j++){
                    if(A[i] == A[j]){
                        count += 1;
                        if(A[i] == 3){

                        }
                        oddCheck[i] = count;
                        oddCheck[j] = -1;
                    }
                }

            }
            count = 1;
        }
        for(int i = 0; i < A.length; i++){

            if(oddCheck[i]%2 == 1 || oddCheck[i] != -1 )
                result = A[i];
        }

        return result;

    }

}
