
import java.util.NoSuchElementException;


public class AVLTree <Item > {
    
   AVLNode<Item> root;
   
   
    public AVLTree() {
        root = null;
        
    }

    public int height(AVLNode<Item> d) {
        if (d == null) {
            return 0;
        } else {
            return d.height;
        }
        
    }

    //rotate focus. to right. replace it with left child
    public AVLNode<Item> rotateMyLeft(AVLNode focus) {
        AVLNode<Item> k = focus.left;
        focus.left = k.right;
        k.right = focus;
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        k.height = Math.max(height(k.left), height(k.right)) + 1;
        return k;
    }

    //rotate focus left, replace it with right child
    public AVLNode<Item> rotateMyRight(AVLNode focus) {
        AVLNode<Item> k = focus.right;
        focus.right = k.left;
        k.left = focus;
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        k.height = Math.max(height(k.left), height(k.right)) + 1;
        return k;
    }

    public AVLNode<Item> doubleRotateLeftSide(AVLNode focus) {
        focus.left = rotateMyRight(focus.left);
        return rotateMyLeft(focus);
    }

    public AVLNode<Item> doubleRotateRightSide(AVLNode focus) {
        focus.right = rotateMyLeft(focus.right);
        return rotateMyRight(focus);
    }

    // Get Balance factor of node focus
    int getBalance(AVLNode<Item> focus) {
        if (focus == null) {
            return 0;
        }
        return height(focus.left) - height(focus.right);
    }
    public AVLNode search(int key) {
        return searchRecursive(this.root, key);
    }
    public void traverseInOrder(AVLNode focus){    
        if(focus.left != null)
            traverseInOrder(focus.left);
        System.out.println(focus.toString());
        if(focus.right != null)
            traverseInOrder(focus.right);    
}

    public AVLNode searchRecursive(AVLNode focus, int key) {
        if (focus == null) {
            return null;
        }
        if (focus.key == key) 
        {
            return focus;
        } else if (key < focus.key) 
        {
            return searchRecursive(focus.left, key);
        } else 
        {
            return searchRecursive(focus.right, key);
        }
    }
    public void delete(int key) {
        if(search(key)==null){
            System.out.println("The "+key+ "is not found!");   
        }
        root = delete(root, key);
        
    }
     private int size(AVLNode x) {
        if (x == null) return 0;
        return x.size;
    }
     private AVLNode min(AVLNode x) {
        if (x.left == null) return x;
        return min(x.left);
    } 
     public boolean isEmpty() {
        return root == null;
    }
     public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("called deleteMin() with empty symbol table");
        root = deleteMin(root);
    }
    private AVLNode delete(AVLNode x, int key) {
        if (key < x.key) {
            x.left = delete(x.left, key);
        } else if (key > x.key) {
            x.right = delete(x.right, key);
        } else {
          
            if (x.left == null) {
                return x.right;
            } else if (x.right == null) {
                return x.left;
            } else {
                AVLNode y = x;
                x = min(y.right);
                x.right = deleteMin(y.right);
                x.left = y.left;
            }
        }
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return balance(x);
    }
    private AVLNode deleteMin(AVLNode x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = 1 + size(x.left) + size(x.right);
        x.height = 1 + Math.max(height(x.left), height(x.right));
        return balance(x);
    }
    private AVLNode balance(AVLNode x) {
        if (balanceFactor(x) < -1) {
            if (balanceFactor(x.right) > 0) {
                x.right = rotateMyLeft(x.right);
            }
            x = rotateMyRight(x);
        } else if (balanceFactor(x) > 1) {
            if (balanceFactor(x.left) < 0) {
                x.left = rotateMyRight(x.left);
            }
            x = rotateMyLeft(x);
        }
        return x;
    }
    private int balanceFactor(AVLNode x) {
        return height(x.left) - height(x.right);
    }
     public void insert(int data, int key) {
        root = insert(root, data, key);
    }
    public AVLNode<Item> insert(AVLNode focus, int data, int key) {
        if (focus == null) {
            focus = new AVLNode(key, data);
        } else if (key < focus.key) {
            focus.left = insert(focus.left, data, key);
            if (getBalance(focus) == 2) {
                if (key < focus.left.key) {
                    focus = rotateMyLeft(focus);
                } else {
                    focus = doubleRotateLeftSide(focus);
                }
            }
        } else if (key > focus.key) {
            focus.right = insert(focus.right, data, key);
            if (getBalance(focus) == 2) {
                if (key > focus.right.key) {
                    focus = rotateMyRight(focus);
                } else {
                    focus = doubleRotateRightSide(focus);
                }
            }
        } else {
           focus.data = data;
        }

        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        return focus;
    }
    
}
