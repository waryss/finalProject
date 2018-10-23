package project.dao.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @Column(name = "idUser")
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @Column(name = "id")
    private String login;
    @Column(name = "password")
    private String password;

    public UserEntity() {

    }


    public UserEntity(Integer id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
