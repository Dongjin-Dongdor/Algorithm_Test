
import java.util.LinkedList;
public class Solution{

    class Node{

        private int data;
        private Node nextNode;
        public Node(int data){

            this.data = data;
            this.nextNode = null;

        }

        public void setData(int data){
            this.data = data;
        }
        public void setNextNode(Node nextNode){
            this.nextNode = nextNode;
        }

        public int getData(){
            return this.data;
        }

        public Node getNext(){
            return this.nextNode;
        }

    }
    LinkedList<Solution>  solutionList;
    Node headNode;
    public Solution(){

        solutionList = new LinkedList<Solution>();
        headNode = null;
    }

    public void push(int value){
        Node newNode = new Node(value);
    }




}