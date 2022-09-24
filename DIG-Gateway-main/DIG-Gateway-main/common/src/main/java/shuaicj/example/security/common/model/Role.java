package shuaicj.example.security.common.model;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "application_api_mascom", schema = "public")
@ToString
public class Role {
//    static final long serialVersionUID = -681492884005033L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    protected int id;

//    @ManyToOne
//    @JoinColumn(name="application_id", nullable=false)
//    @Id
//    protected GatewayUser user;

//    @Column(name = "application_id")
//    protected int application_id;
//
//    @Column(name = "api_mascom_id")
//    protected int api_mascom_id;

    @EmbeddedId
    protected RolePK id;

    @Column(name = "role")
    protected String role;

    @Column(name = "active")
    protected boolean active;
}
