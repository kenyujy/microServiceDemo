package microservice.entities;

import lombok.Data;

@Data
public class DeptWithOrg {

    private long id;
    private String name;
    private String location;
    private String organization;

    public DeptWithOrg(){

    }
}
