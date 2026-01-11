package oops.immutableClass;

import java.io.Serializable;

public class personDTOs implements Serializable {
    private final int id;
    private final String name;
    private final transient  String password;
    personDTOs(int id,String name,String password){
        this.id=id;
        this.name=name;
        this.password=password;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
}


