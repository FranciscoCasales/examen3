package mx.com.axity.model;

import javax.persistence.*;

@Entity
@Table(name = "login", schema = "public")
public class LoginDO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UsersSeq")
    @SequenceGenerator(name = "UsersSeq", sequenceName = "users_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    @Column(name = "ds_username")
    private String username;
    @Column(name = "ds_password")
    private String password;

    protected LoginDO() {
    }

    public LoginDO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
