/**
 * Created by dongdor on 2016. 8. 25..
 */
public class Node {

    private int data;
    private Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }

    public void setNext(Node nextNode){
        this.next = nextNode;
    }

    public int getData(){
        return data;
    }

    public Node getNext(){
        return this.next;
    }


}


/**

 자바접근제한자
 종류
 1) public
 --> 모든 접근 허용
 2) protected
 --> 같은 패키지에 있는 객체와 상속관계의 객체들만 허용
 3) default
 --> 같은 패키지에 있는 개체만 허용
 4) private
 --> 현재 객체 내에서만 허용

 */