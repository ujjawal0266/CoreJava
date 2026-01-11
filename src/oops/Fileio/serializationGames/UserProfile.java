package oops.Fileio.serializationGames;

import java.io.Serializable;

public class UserProfile implements Serializable{
    private  static final long serialVersionUID=10000;
    private int level=1;
    private final String GamerName;
    private int score=0;
    UserProfile(String GN){
        this.GamerName=GN;
    }

    public int getLevel() {
        return level;
    }

    public String getGamerName() {
        return GamerName;
    }

    public int getScore() {
        return score;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
