import java.util.Scanner;

public class Main {

    public static int computerN;
    public static int[] isVisit;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        computerN = sc.nextInt();
        sc.nextLine();
        int vertex = sc.nextInt();
        sc.nextLine();

        int[][] comNode = new int[computerN+1][computerN+1];
        isVisit = new int

        for(int i = 0; i < vertex; i++){

            String[] index = sc.nextLine().split(" ");
            comNode[Integer.parseInt(index[0])][Integer.parseInt(index[1])] = 1;

        }



    }

    public static void dp(int root){

        for(int i  = 1; i<=computerN; i++){

            isVisit[]

        }
    }

}