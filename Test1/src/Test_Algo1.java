/**
 * Created by dongdor on 2016. 8. 25..
 */

/**
 문제1
 여러 개의 시험장이 있고 각 시험장마다 임의의 응시자들이 존재한다. 이 응시자들을 모두 감독하기 위한 감독관 배치 문제이다.
 감독관은 ‘총감독관’과 ‘부감독관’ 이렇게 두 종류가 있다. 둘은 같은 방안에서 감시할 수 있는 응시생들의 숫자가 다르다.

 총감독관은 모든 감독관을 통틀어서 오로지 1명만 존재하며 무조건 존재해야 한다.

 부감독관은 여러 명을 사용해도 된다.

 각 시험장에서 모든 응시생들을 감시해야 한다.

 시험장의 수, 시험장 마다 존재하는 응시생의 수가 주어졌을 때 필요한 최소 감독관의 수를 구하는 것이 문제이다.
 -> input(시험장수, 응시생 수) // output(최소감독관 수)

 테스트 케이스(시험장의 수, 시험장 마다 존재하는 응시생 수, 총감독관 감시가능 응시생 수, 부감독관 감시가능 응시생 수)는 30개가 주어진다.
 작성한 프로그램이 모든 결과를 도출하는데 걸리는 시간은 1초 이내여야 한다.
 */

import java.util.Scanner;

public class Test_Algo1 {

    public static void main(String[] args){
        int monitorCount = 0;
        int spaceCount;
        int studentCount;
        int mainMonitorCount;
        int subMonitorCount;

        Scanner sc = new Scanner(System.in);
        String[] array = sc.nextLine().split(" ");

        spaceCount = Integer.parseInt(array[0]);
        studentCount = Integer.parseInt(array[1]);
        mainMonitorCount = Integer.parseInt(array[2]);
        subMonitorCount = Integer.parseInt(array[3]);


        monitorCount = findMonitorCount(spaceCount, studentCount);

    }


    public static int findMonitorCount(int spaceCount, int studentCount){ //시험장수와 응시생수가 input으로 들어간다
        int count = -1;
        int[] space = new int[spaceCount];

        for(int i = 0; i<=space.length-1; i++){
            space[i] = studentCount;
        }

        return count;
    }
}
