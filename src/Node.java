
public class Node<Item>{
    Song data;
    Node next;

    public Node(Song data) {
        this.data = data;
        next = null;
    }
    
    @Override
    public String toString(){
        return (""+data.toString());
    }
   
}
