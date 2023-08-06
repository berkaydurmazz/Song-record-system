
public class LinkedList <Item>{
  Node<Item> first,last;
  int size=0  ;
  Node<Item> current;
  
  public LinkedList(){
      first=null;
      last=null;
      size=0;
  }
  public void insertFirst(Song x) {
        Node newNode = new Node<Item>(x);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        size++;
        current=newNode;
    } 
      
    
    public void insertAfter(Node<Item> p, Song x) {
        Node<Item> newNode = new Node<Item>(x);
        if (p == null || size == 0) {
            
            return;
        }
        if (p==last){
            insertLast(x);
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
        size++;
    }
    
    public void insertLast(Song x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }
    
     public boolean isEmpty() {
        return size == 0;
    }
     public void delete(Node<Item> s){
         Node<Item> tmp,previous;
         tmp=first;
         previous=null;
         if (tmp != null && tmp.data.key == s.data.key) {
            first = tmp.next; // Changed head
            return;
        }
         while(tmp!=s){
             previous=tmp;
             tmp=tmp.next;
         }
         if (tmp == null)
            return;
        previous.next=tmp.next;
     }
     public Node<Item> searchG(int s){
         Node<Item> tmp;
         tmp=first;
         while(tmp!=null){
             if(tmp.data.getID()==s)
                 return tmp;
             tmp=tmp.next;
         }
         return null;
     }
     public Node<Item> search(int s){
         Node<Item> tmp;
         tmp=first;
         while(tmp!=null){
             if(tmp.data.key==s)
                 return tmp;
             tmp=tmp.next;
         }
         return null;
     }
     void print(){
        Node tmp=this.first;
        while(tmp!= null){
            System.out.print(tmp.data.toString());
            tmp=tmp.next;
        }
        System.out.println("");
    }
}
