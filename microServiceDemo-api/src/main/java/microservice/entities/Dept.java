package microservice.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class Dept implements Serializable {  //entity orm

    private long id;
    private String name;
    private String location;
    private int organizationId;
    private String dbSource;

    public Dept() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
