
public class AVLNode<Item> {
    public int key;
    public int data;
    public int height;
    public int size;
    public AVLNode left;
    public AVLNode right;
    
    public AVLNode(int key, int data) {
        this.key = key;
        this.data = data;
        left=null;
        right=null;
        height=1;
    }

    @Override
    public String toString() {
       return "Key: "+key+" Data: "+data;
    }
    
}
