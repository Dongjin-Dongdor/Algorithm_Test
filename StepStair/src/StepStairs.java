/**
 * Created by dongdor on 2016. 9. 30..
 */

import java.util.Scanner;
import java.util.LinkedList;
public class StepStairs {

    public static void main(String[] args){

        LinkedList<Node> queue = new LinkedList<Node>();
        Scanner sc = new Scanner(System.in);
        int countStair = sc.nextInt();
        sc.nextLine();

        int[] stairs = new int[countStair];

        //계단 개수만큼 for문 돌리기
        for(int i = 0; i < countStair; i++){

            String index = sc.nextLine();
            stairs[i] = Integer.parseInt(index);

        }

        //처음 root 노드 생성
        Node root = new Node(0,0,0,stairs[0]);

        //큐에 root 노드를 넣어준다 -> 시작해야하니깐
        queue.add(root);

        int max = step(queue, stairs);



    }
    public static int step(LinkedList<Node> queue, int[] stairs){


        int max = 0;
        while(!queue.isEmpty()){
            Node vertex = queue.poll();
            System.out.println("**current vertex : "+ vertex.num+ " **");
            //꺼낸 애의 num이 stair 배열 길이인지 검사한다 만약 vertex가 6번째 애라면 꺼내진 노드 뒤엔 더이상 그 뒤에 넣을 값이 없으므로 패스한다.
            if(vertex.num  == stairs.length - 1){
                if(max < vertex.max){
                    max = vertex.max;
                }
            }

            //꺼낸 애의 value가 stairs.length가 아니라면 다시 넣는다
            else{
                // 만약 현재 vertex의 count가 3보다 작다면 즉 3칸을 연속으로 올라온 아이가 아니면 if 문 안에 들어온다
                if(vertex.count + 1 <3){
                    if(vertex.num + 1 <= stairs.length - 1){
                        //1칸씩 3번 연속된 애가 아니므로 queue에 집어 넣는다.
                        System.out.println("add queue num1 : "+(vertex.num+1));
                        System.out.println("current max1 "+(vertex.max+stairs[vertex.num+1]));
                        queue.add(new Node(vertex.max + stairs[vertex.num+1], vertex.count+1, vertex.num + 1, stairs[vertex.num+1]));

                    }

                }
                //2칸 뛴 애는 그냥 큐에 넣는다.
                if(vertex.num + 2 <= stairs.length-1) {
                    System.out.println("add queue num2 : "+(vertex.num+2));
                    System.out.println("current max2 "+(vertex.max+stairs[vertex.num+2]));
                    queue.add(new Node(vertex.max + stairs[vertex.num+ 2], 0, vertex.num + 2, stairs[vertex.num + 2]));

                }
            }

        }

        System.out.println(max);





        return 0;
    }

    public static class Node{

        private int max; // 얘까지 도달한 값중 최대값
        private int count; // 1이 3번 반복된건 아닌지 검사
        private int num; // 배열의 몇번째 값인지
        private int value;// 해당 배열의 값

        public Node(int max, int count, int num, int value){

            this.max = max;
            this.count = count;
            this.num = num;
            this.value = value;

        }

    }
}
