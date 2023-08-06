
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class Test {
    
    public static void main(String[] args) {
        ChainHash<String> ch=new ChainHash<>(15);
        ChainHash<String> ch_genre=new ChainHash<>(10);
        AVLTree<AVLNode> id_AVLTree= new AVLTree<>();
        AVLTree<AVLNode> name_AVLTree= new AVLTree<>();
        AVLTree<AVLNode> artist_AVLTree= new AVLTree<>();
        AVLTree<AVLNode> genre_AVLTree=new AVLTree<>();
        String fname = "songlist.txt";
        Scanner scn = null;
         int option=0;
        try{
            scn = new Scanner(new BufferedReader(new FileReader(fname)));
            while(scn.hasNextLine()){
                String s = scn.nextLine();
                String[] sarray=s.split(";");
                Song newSong= new Song(sarray[0], sarray[1], Integer.valueOf(sarray[2]), sarray[3], Integer.valueOf(sarray[4]));
                int data= ch.insert(newSong);
                ch_genre.insertforGenre(newSong,getsum(sarray[3]));
                int hash_g= ch_genre.hashforGenre( getsum(sarray[3]));
                ch.toString();
                name_AVLTree.insert( data, getsum(sarray[0]));
                artist_AVLTree.insert( data, getsum(sarray[1]));
                id_AVLTree.insert( data,newSong.getID());
                genre_AVLTree.insert(hash_g, getsum(sarray[3]));
                
            }
            scn.close();
        }
        catch(Exception e){
            System.out.println("Unable to read the file!"+e);
        }
        
        do{
            try{
            System.out.println("The following options are available for you: ");
           System.out.println("Please choose an option \n 1) Search for a song \n 2) Display the songs according to genre"
                   + "\n 3) Search a range of the songs according to ID numbers \n 4) Add a new song \n"
                   + " 5)Delete a song  \n 6) Quit");
           scn=new Scanner(System.in); boolean t;int a;
            option=scn.nextInt();String name="";int ID_entered;String output;
            switch(option){
               
                case 1:
                     
                        do{
                    try{
                        System.out.println("Choose an option to search: \n 1)Song name \n 2) Artist \n 3)ID"
                                + "\n 4) Back to Main Menu");
                        option=scn.nextInt();
                
                switch(option){
                    case 1:
                         a=1;
                        try{
                          //name_AVLTree.traverseInOrder(name_AVLTree.root);
                        System.out.print("Please enter the name of song: ");
                        output=BalanceUpandDownLetter(name, scn,a);
                        System.out.println(output);
                        System.out.println(ch.search(name_AVLTree.search(getsum(output)).data));
                       
                    }catch(Exception e){
                     System.out.println("The song is not in the list! "+e); a--;
                    }
                        break;
                    case 2:
                          a=1;
                        try{
                        System.out.print("Please enter the name of artist: ");
                         output=BalanceUpandDownLetter(name, scn,a);
                        System.out.println(output);
                        System.out.println(ch.search(artist_AVLTree.search(getsum(output)).data));
                        }catch(Exception e){
                     System.out.println("The song is not in the list! "+e); a--;
                    }
                        break;
                    case 3:
                        try{
                        System.out.print("Please enter the ID of song: ");
                        ID_entered = scn.nextInt();
                        System.out.println(ch.search(id_AVLTree.search(ID_entered).data));
                        }catch(Exception e){
                     System.out.println("The song is not in the list! "+e);
                    };
                        break;
                    case 4: break;
                    default: System.out.println("The option you chose is not avaible!");
                }
                    }catch(Exception e){
                     System.out.println("The option is not available! "+e); 
                    }}while(option!=4);
                    break;
                case 2:
                    
                    System.out.print("Please enter the genre which you want to list: ");
                     output=BalanceUpandDownLetter(name, scn,1);
                        System.out.println(output);
                      //  genre_AVLTree.traverseInOrder(genre_AVLTree.root);
                        LinkedList link=ch_genre.searchforG(genre_AVLTree.search(getsum(output)).data);
                       Node tmp=link.first;
                       //System.out.println("LinkedList first item: "+ tmp);
                       //System.out.println(link);
                        while(tmp!=null){
                            System.out.println(tmp.data.toString());
                            tmp=tmp.next;
                        }
                        
                    break;
                case 3: 
                    System.out.print("Please enter the head id: ");
                ID_entered=scn.nextInt();int hid=ID_entered;
                    System.out.print("Please enter the last id: ");
                    ID_entered=scn.nextInt();int lid=ID_entered;
                    for (int i = hid; i <= lid; i++) {
                        try{
                            System.out.println(ch.search(id_AVLTree.search(i).data));
                        }catch(Exception e){
                            System.out.println("There is no song with using this ID: "+i);
                        }
                    }
                    break;
                case 4:try{
                    System.out.print("Please enter the name of song: ");
                    String namee=BalanceUpandDownLetter(name, scn,1);
                    System.out.print("Please enter the name of artist: ");
                    String artist=BalanceUpandDownLetter(name, scn,0);
                    int ID;
                    do{
                    System.out.print("Please enter the ID: ");
                    ID=scn.nextInt();
                    if(id_AVLTree.search(ID)!=null)
                            System.out.println("Entered ID already exists!");
                    }while(id_AVLTree.search(ID)!=null);
                    
                    System.out.print("Please enter the genre: ");
                    String genre=BalanceUpandDownLetter(name, scn,1);
                    System.out.print("Please enter the year of song: ");
                    int year=scn.nextInt();
                    
                    Song newSong= new Song(namee, artist, ID, genre, year);
                    int data= ch.insert(newSong);
                    ch_genre.insertforGenre(newSong,getsum(genre));
                    int hash_g= ch_genre.hashforGenre( getsum(genre));
                    name_AVLTree.insert( data, getsum(namee));
                    artist_AVLTree.insert( data, getsum(artist));
                    id_AVLTree.insert( data,ID);
                    genre_AVLTree.insert(hash_g, getsum(genre));
                    System.out.println("The song : "+newSong.toString()+" is added.");
                    }catch(Exception e){
                       System.out.println("Please enter the available value ! "+e);
                  }
                    break;
                case 5:
                    try{
                         System.out.print("Please enter the ID of the song you want to delete: ");
                        ID_entered = scn.nextInt();
                         try{
                        Node deletingNode =ch.search(id_AVLTree.search(ID_entered).data, ch.searchforint(id_AVLTree.search(ID_entered).data));
                        int hash=ch.searchforint(id_AVLTree.search(ID_entered).data);
                        ch.table[hash].delete(deletingNode); // hash tabledan silmesi gerek    
                        int genre_number= getsum(deletingNode.data.getGenre());
                        int hashG = ch_genre.hashforGenre(genre_number);
                        int y=ch_genre.table[hashG].searchG(ID_entered).data.getKey();
                         int al=ch_genre.searchforint(id_AVLTree.search(ID_entered).data);
                        Node delNode= ch_genre.search(y,al);
                        ch_genre.table[hashG].delete(delNode);
                        id_AVLTree.delete(ID_entered);
                        System.out.println("The song: "+deletingNode.data.toString()+" is deleted!");
                    }catch(Exception e){
                        System.out.println("There is no song with written ID: "+ID_entered+" "+e);
                    }
                    }catch(Exception e){
                       System.out.println("Please enter the integer value of ID! "+e);
                  }
                    break;
                case 6:break;
                /*case 7:System.out.println("genre tree root: "+genre_AVLTree.root);
                    genre_AVLTree.traverseInOrder(genre_AVLTree.root);
                    System.out.println("");
                    System.out.println("id tree root: "+id_AVLTree.root);
                    id_AVLTree.traverseInOrder(id_AVLTree.root);
                    System.out.println("Hash table printi");
                    for (int i = 0; i < ch.table.length; i++) {
                        ch.table[i].print();
                    }
                    System.out.println("Hash Genre table printi");
                    for (int i = 0; i < ch_genre.table.length; i++) {
                        for (int j = 0; j < ch_genre.table[i].size; j++) {
                            System.out.println("i: "+i+" genre j: "+j );
                            
                        }
                        ch_genre.table[i].print();
                    }
                break;*/
                default:System.out.println("Your option is not available!");
            } 
        }catch(Exception e){
           System.out.println("Please enter a available integer ! "+e);
            }
        
        }while(option!=6);
        
    }
    public static int getsum(String s){
        String name_number="";
             for (int j = 0; j < s.length(); j++) {
                    char a=s.charAt(j);
                    long ascii_value = a;
                    name_number+=ascii_value;
                }
               return getintofString(name_number);
        }
    public static int getintofString(String name_number){
        int sum=0;
                for (int j = 0,k=8; j < name_number.length(); j+=8,k+=8) {
                    if(k<name_number.length()){
                   // System.out.println(name_number.substring(j, k));
                    sum += Integer.valueOf(name_number.substring(j, k));
                    }else{
                       //System.out.println(name_number.substring(j, name_number.length()));
                    sum += Integer.valueOf(name_number.substring(j, name_number.length()));
                    }
                }
                //System.out.println(sum);
                return sum;
    }
    public static String BalanceUpandDownLetter(String name,Scanner scn,int s){
        if(s==1)
         scn.nextLine();
        name= scn.nextLine();
        String[] genre_array=name.split(" ");
        String output="";
        for (int i = 0; i < genre_array.length; i++) {
            //System.out.println(genre_array[i]);
            if(i+1!=genre_array.length){
               output+=genre_array[i].substring(0, 1).toUpperCase()+ genre_array[i].substring(1).toLowerCase()+" ";
            }else 
                output+=genre_array[i].substring(0, 1).toUpperCase()+ genre_array[i].substring(1).toLowerCase();
            }
      return output;
    }
}
