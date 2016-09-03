/**
 * Created by dongdor on 2016. 9. 3..
 */


public class makeTime {

    public static void main(String[] args){

        solution(1,8,3,2);


    }

    static int[] time = new int[4];
    static int check = -1;
    static int pic = -1;
    public static String solution(int A, int B, int C, int D) {
        // write your code in Java SE 8




        int[] array = {A,B,C,D};

        //get First Hour
        array = getHour1(array);
        if(check == -1){
            System.out.println("NOT POSSIBLE");
            return "NOT POSSIBLE";
        }
        check = -1;


        //get Second Hour
        array = getHour2(array);
        if(check == -1){
            System.out.println("NOT POSSIBLE");
            return "NOT POSSIBLE";
        }
        check = -1;


        //get First Minute
        array = getMinute1(array);
        if(check == -1){
            System.out.println("NOT POSSIBLE");
            return "NOT POSSIBLE";
        }
        check = -1;

        //get Second Minute
        getMinute2(array);


        String hour1 = String.valueOf(time[0]);
        String hour2 = String.valueOf(time[1]);
        String minute1 = String.valueOf(time[2]);
        String minute2 = String.valueOf(time[3]);
        String result = hour1+hour2+":"+minute1+minute2;

        return result;
    }

    public static int[] getHour1(int[] array){
        for(int i = 0; i<4 ; i++){
            if(array[i] <= 2) {
                if (check <= array[i]) {
                    check = array[i];
                    pic = i;
                    time[0] = check;
                }
            }
        }
        array[pic] = -1;
        return array;

    }
    public static int[] getHour2(int[] array){
        for(int i = 0; i<4; i++){
            if(time[0] == 2) {
                if (array[i] < 4 && array[i] != -1) {
                    if (check <= array[i]) {
                        check = array[i];
                        pic = i;
                        time[1] = check;
                    }
                }
            }
            else{
                if(array[i] < 10 && array[i] != -1){
                    if (check <= array[i]) {
                        check = array[i];
                        pic = i;
                        time[1] = check;
                    }
                }
            }
        }
        array[pic] = -1;
        return array;
    }
    public static int[] getMinute1(int[] array){
        for(int i = 0; i<4; i++){
            if(array[i] < 6 && array[i] != -1){
                if(check <= array[i]){
                    check = array[i];
                    pic = i;
                    time[2] = check;
                }
            }
        }
        array[pic] = -1;
        return array;

    }
    public static void getMinute2(int[] array){
        for(int i = 0; i<4; i++){
            if(array[i] != -1){
                check = array[i];
                time[3] = check;
            }
        }

    }

}
