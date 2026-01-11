package oops.Fileio.serializationGames;

import java.util.HashMap;

public class Games {
    private HashMap<Integer,String> games=new HashMap<>();
    private  int currentNumber=0;
    Games(){
        // insert default values on teh games hashmap
        games.put(0,"gta 5");
        games.put(1,"gta 4");
        games.put(2,"gta 3");
        games.put(3,"gta vice city");
    }
    public void CurrentNumberSetter(int n){
        this.currentNumber=n;
    }
    public int gamesLength(){
        return games.size();
    }
    public int getCurrentNumber(){
        return currentNumber;
    }
    public  void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public String getNext(){
        currentNumber++;
        currentNumber%=games.size();
        return games.get(currentNumber);
    }
}
