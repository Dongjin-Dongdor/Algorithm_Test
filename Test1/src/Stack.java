/**
 * Created by dongdor on 2016. 8. 25..
 */
public class Stack {

    private Node headNode;
    private int data;
    private static int count;

    private Stack(){
        headNode = null;
    }

    public void push(int data){

        Node newNode = new Node(data);
        if(headNode==null){
            headNode = newNode;
        }
        else{

            newNode.setNext(headNode);
            headNode = newNode;
        }
        count += 1;
    }

    public int getSizeStack(){
        return count;
    }

    public int pop(){
        int popData = -1;
        if(headNode != null){
            popData = headNode.getData();
            headNode = headNode.getNext();
            count -=1;
        }
        else{
            return -1;
        }


       return popData;
    }

    public int top(){
        if(headNode==null){
            return -1;
        }
        return headNode.getData();
    }

    public boolean isEmpty(){
        if(headNode == null){
            return true;
        }
        else
            return false;

    }

    public static Stack createStack(){

        return new Stack();
    }
}
