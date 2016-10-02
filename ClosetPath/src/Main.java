/**
 * Created by dongdor on 2016. 10. 1..
 */


import java.util.Scanner;
public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        //이동횟수
        int count = 0;
        // 벽장 길이
        int cLength = sc.nextInt();

        sc.nextLine();
        String[] index = sc.nextLine().split(" ");

        // 열려있는 벽장 1
        int cOpen1 = Integer.parseInt(index[0]);
        // 열려있는 벽장 2
        int cOpen2 = Integer.parseInt(index[1]);

        //사용할 벽장 순서 길이
        int uLength = sc.nextInt();
        sc.nextLine();
        int[] uOrder = new int[uLength];
        for(int i = 0; i<uLength; i++){
            uOrder[i] = sc.nextInt();
            sc.nextLine();
        }

        for(int i = 0; i < uLength; i++){

            // 가까운 거리를 비교한다
            if(Math.abs(cOpen1-uOrder[i])>Math.abs(cOpen2-uOrder[i])){
                count += Math.abs(cOpen2 - uOrder[i]);
                cOpen2 = uOrder[i];
            }
            else{
                count += Math.abs(cOpen1 - uOrder[i]);
                cOpen1 = uOrder[i];
            }
        }
        System.out.println(count);




    }
}
