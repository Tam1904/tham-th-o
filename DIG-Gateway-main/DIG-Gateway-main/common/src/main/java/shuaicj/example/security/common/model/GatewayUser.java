package shuaicj.example.security.common.model;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "users", schema = "public")
@ToString
public class GatewayUser {

    @Id
    @Column(name = "id")
    protected int id;

    @Column(name = "username")
    protected String username;

    @Column(name = "email")
    protected String email;

    @Column(name = "fullname")
    protected String fullname;

    @Column(name = "password")
    protected String password;

    @Column(name = "application_api_code")
    protected String application_api_code;

    @Column(name = "application_api_key")
    protected String application_api_key;

    @Column(name = "status")
    protected boolean status;

    public GatewayUser(String username, String email, String fullname, String password, String application_api_code, String application_api_key) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.application_api_code = application_api_code;
        this.application_api_key = application_api_key;
    }

    public GatewayUser() {

    }
}
