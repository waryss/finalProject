package finalProject.dao.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "USER")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "name")
    private String password;

    public UserEntity() {

    }


    public UserEntity(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
