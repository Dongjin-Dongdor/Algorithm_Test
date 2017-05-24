/**
 * Created by dongdor on 2017. 4. 13..
 */
import java.util.*;
public class Baam_Main {
    static int[][] map;
    static int position;
    static int x;
    static int y;
    static int map_size;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();


        int N = sc.nextInt();

        //방향 0: 오른쪽이동 / 1: 위쪽이동 / 2: 왼쪽이동 / 3: 아래쪽이동
        position = 0;
        int[] move = new int[N];
        String[] direction = new String[N];

        for(int i = 0; i < N; i++){
            move[i] = sc.nextInt();
            direction[i] = sc.next();
        }
        map_size = 2*N+1;
        map = new int[map_size][map_size];
        map[N][N] = 1;
        x = N;
        y = N;
        int result = 0;
        for(int i = 0; i < N; i++){

            result += baam(move[i], direction[i], 0);
        }
        System.out.println(result+1);

    }

    public static int baam(int move, String direction, int count){
        for(int i = 0; i<move ; i++) {
            if(position == 0){
                y += 1;
                if(y >= map_size){
                    return count;
                }
                else if(map[x][y] == 2){
                    return count;
                }
                else{
                    map[x][y] = 1;
                    map[x][y-1] = 2;
                }
                count += 1;
            }
            else if(position == 1){
                x -= 1;
                if(x < 0){
                    return count;
                }
                else if(map[x][y] == 2){
                    return count;
                }
                else{
                    map[x][y] = 1;
                    map[x+1][y] = 2;
                }
                count += 1;
            }
            else if(position == 2){
                y -= 1;
                if(y < 0){
                    return count;
                }
                else if(map[x][y] == 2){
                    return count;
                }
                else{
                    map[x][y] = 1;
                    map[x][y+1] = 2;
                }
                count += 1;
            }
            else{
                x += 1;
                if( x >= map_size){
                    return count;
                }
                else if(map[x][y] == 2){
                    return count;
                }
                else{
                    map[x][y] = 1;
                    map[x-1][y] = 2;
                }
                count += 1;
            }
        }
            //오른쪽 이동
            if(position == 0){
                if(direction == "L"){
                    position = 1;
                }
                else{
                    position = 3;
                }
            }
            //위쪽 이동
            else if(position == 1){
                if(direction == "L"){
                    position = 2;
                }
                else{
                    position = 0;
                }
            }
            //왼쪽 이동
            else if(position == 2){
                if(direction == "L"){
                    position = 3;
                }
                else{
                    position = 1;
                }
            }
            //아래쪽 이동
            else{
                if(direction == "L"){
                    position = 0;
                }
                else{
                    position = 2;
                }
            }

            return count;
    }
}
