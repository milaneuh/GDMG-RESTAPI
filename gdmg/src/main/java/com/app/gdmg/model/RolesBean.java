package com.app.gdmg.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table (name = "roles")
public class RolesBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long role_id;

    private String role_label;

    @OneToMany(mappedBy = "role")
    private Collection<UtilisateurBean> utilisateurBeans;

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public String getRole_label() {
        return role_label;
    }

    public void setRole_label(String role_label) {
        this.role_label = role_label;
    }
}
