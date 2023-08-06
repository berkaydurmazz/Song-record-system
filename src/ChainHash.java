
public class ChainHash <Item>{
    LinkedList<Item>[] table;
    int M;
    
     public ChainHash(int M) {
        table = new LinkedList[M];
        for (int ix = 0; ix < M; ix++) {
            table[ix] = new LinkedList<Item>();
        }
        this.M = M;

    }
    public int hash(Song t) {
        return ((t.hashCode()& 0x7ffffff ) % M);
    }
    public int hashforGenre (int genre_num){
        return ((genre_num & 0x7ffffff) % M);
    }
    public Node<Item> search(int hc,int index){
       return table[index].search(hc);
    }
    public int searchforint(int i){
        for (int j = 0; j < M; j++) {
            Node tmp=table[j].first;
            while(tmp!=null){
                if(tmp.data.getKey()==i){
                    return j; //hash veriyor
                }
                tmp=tmp.next;
            }
            
        }return 0;
    }
    public LinkedList<Item> searchforG(int i){
        for (int j = 0; j < M; j++) {
            if(j==i)
                return table[j];
        }
        return null;
    }
    public String search(int i){
        for (int j = 0; j < M; j++) {
            Node tmp=table[j].first;
            while(tmp!=null){
                if(tmp.data.getKey()==i){
                    return tmp.data.toString();
                }
                tmp=tmp.next;
            }
            
        }return " The song is not in the list!";
    }
    
    public int insert(Song t) {
        int ix = hash(t);
       // System.out.println("hash index: "+ix);

        table[ix].insertFirst(t);
     //   System.out.println(ix+"th chain: "+table[ix].current);
        return getcurrentHashcode(ix);
        
    }
    public int insertforGenre(Song t,int genre_num) {
        int ix = hashforGenre(genre_num);
       // System.out.println("hash index: "+ix);

        table[ix].insertFirst(t);
       // System.out.println(ix+"th chain: "+table[ix].current);
        return getcurrentHashcode(ix);
        
    }
  
    public int getcurrentHashcode(int ix){
       return table[ix].current.data.getKey();
    }

    public String toString() {
        String s = "";
        for (int ix = 0; ix < M; ix++) {
            if (table[ix] != null) {
                s += ix + "th " + table[ix].toString() + "\n";
            }
        }
        return s;
    }
}
