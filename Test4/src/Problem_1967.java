


import java.util.Scanner;
import java.util.LinkedList;

public class Problem_1967{


    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[][] weights = new int[count+1][count+1];
        int root = 0;
        sc.nextLine();

        for(int i = 0;  i < count - 1; i++ ){

            String[] inputs = sc.nextLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            int weight = Integer.parseInt(inputs[2]);
            if(i == 0){
                root = start;
            }
            weights[start][end] = weights[end][start] = weight;
        }

        Node maxNode;
        Node resultNode;

        maxNode = bfs(weights, root);
        resultNode = bfs(weights, maxNode.value);


        System.out.println(maxNode.toString());
        System.out.println(resultNode.toString());

    }

    static Node bfs(int[][] graph, int start){

        LinkedList queue = new LinkedList<Node>();
        boolean[] isVisited = new boolean[graph.length + 1];

        Node maxNode = new Node(start, 0);
        queue.add(maxNode);



        while(!queue.isEmpty()){

            Node vertex = (Node)queue.poll();
            boolean isNotFinished = false;
            isVisited[vertex.value] = true;
            for(int i = 1; i<graph.length; i++){
                if(graph[vertex.value][i] > 0 && !isVisited[i]){

                    queue.add(new Node(i,vertex.sum + graph[vertex.value][i]));
                    //한개라도 들어갔다면 끝날수있다
                    isNotFinished = true;

                }
            }
            if(!isNotFinished){
                if(maxNode.sum < vertex.sum){
                    maxNode = vertex;
                }
            }



        }


        return maxNode;


    }



    static class Node{

        int sum;
        int value;
        public Node(int value, int sum){

            this.value = value;
            this.sum = sum;

        }

        @Override
        public String toString(){

            return "value : "+ value+ "Sum : " + sum;


        }


    }


}