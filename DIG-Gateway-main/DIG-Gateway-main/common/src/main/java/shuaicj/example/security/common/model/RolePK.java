package shuaicj.example.security.common.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class RolePK implements Serializable {
    @ManyToOne
    @JoinColumn(name="application_id", nullable=false)
    protected GatewayUser user;

    @Column(name = "api_mascom_id")
    protected int api_mascom_id;
}
