/**
 * Created by dongdor on 2016. 10. 3..
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        int count = 0;
        int result = 0;
        Scanner sc = new Scanner(System.in);
        String[] index = sc.nextLine().split(" ");

        int W = Integer.parseInt(index[0]); // 12
        int H = Integer.parseInt(index[1]); // 10
        String[][] Lake = new String[H][W];
        for(int i = 0; i <H ; i++){
            String[] LakeArray = sc.nextLine().split(" ");
            for(int j = 0; j < W; j++){
                Lake[i][j] = LakeArray[j];
            }
        }

        for(int i = 1; i < H - 1; i++){

            for(int j = 1; j < W - 1; j++){
                if(Lake[i-1][j].equals("L")){

                    count += 1;
                }
                if(Lake[i][j-1].equals("L")){

                    count += 1;
                }
                if(Lake[i+1][j].equals("L")){

                    count += 1;
                }
                if(Lake[i][j+1].equals("L")){

                    count += 1;
                }

                if(count == 4){
                    count = 0;
                    result += 1;
                }
                else{
                    count = 0;
                }
            }
        }

        System.out.println(result);


    }
}
