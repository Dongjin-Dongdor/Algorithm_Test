import java.util.EmptyStackException;

/**
 * Created by dongdor on 2016. 8. 25..
 */
public class Queue {

    private Queue nextQueue;
    private Node frontNode;
    private Node rearNode;

    private int data;

    private Queue(){
        this.frontNode = null;
        this.rearNode = null;
    }

    public void enQueue(int data){

        Node newNode = new Node(data);

        if(rearNode != null){
            rearNode.setNext(newNode);
        }
        rearNode = newNode; // 이제 rearNode(맨끝노드)는 newNode이다.
        if(frontNode == null){ //frontNode가 null이라는 것은 지금 들어온 노드가 처음이라는 것이다
            frontNode = rearNode; //따라서 frontNode에 rearNode를 지정시킨다
        }

    }

    public int getQueueSize(){
        int count = 0;

//        Node currentNode = queue.frontNode;
//        while(currentNode != null){
//            count += 1;
//            currentNode = currentNode.getNext();
//        }
//        return count;
//

        Node currentNode = this.frontNode;
            while(currentNode != null){
            count += 1;
            currentNode = currentNode.getNext();
        }
        return count;
    }
    public int deQueue(){
        int data = -1;
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else{
            data = frontNode.getData();
            frontNode = frontNode.getNext();
        }
        return data;
    }

    public static Queue createQueue(){
        return new Queue();
    }

    public boolean isEmpty(){
        if(this.frontNode == null)
            return true;
        return false;
    }
}
