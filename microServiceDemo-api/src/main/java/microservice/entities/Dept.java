package microservice.entities;

import java.io.Serializable;

public class Dept implements Serializable {  //entity orm

    private long id;
    private String name;
    private String location;
    private int organizationId;
    private String dbSource;

    public Dept() {
        super();
    }

    public Dept(long id, String name, String location, int organizationId, String dbSource) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.organizationId = organizationId;
        this.dbSource = dbSource;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", organizationId=" + organizationId +
                ", dbSource='" + dbSource + '\'' +
                '}';
    }
}
