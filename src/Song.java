
public final class Song {
    public  int key;  
    private final String artist;
    private final String name;
    private final int ID;
    private final String genre;
    private final int age;
    
    
    
    public Song(String name, String artist,int ID,String genre,int age) {
        this.artist = artist;
        this.name = name;
        this.ID = ID;
        this.genre = genre;
        this.age=age;
        this.key = hashCode(); 
    }

    @Override
    public String toString() {
        return "Song:" + " artist=" + getArtist() + ", name=" + getName() + ", ID=" + getID() + ", genre=" + getGenre() + ", age=" + getAge();
    }
    @Override
    public int hashCode(){
       return (17 + getID()*3 ); 
    }
    
    public int getKey() {
        return key;
    }

    public String getArtist() {
        return artist;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String getGenre() {
        return genre;
    }

    public int getAge() {
        return age;
    }
}
