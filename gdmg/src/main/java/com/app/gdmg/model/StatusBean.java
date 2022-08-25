package com.app.gdmg.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table (name = "status")
public class StatusBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long statut_id;

    private String statut_code;
    private String statut_label;

    @OneToMany(mappedBy = "statut")
    private Collection<ReservationBean> reservationBeans;

    public long getStatut_id() {
        return statut_id;
    }

    public void setStatut_id(long statut_id) {
        this.statut_id = statut_id;
    }

    public String getStatut_code() {
        return statut_code;
    }

    public void setStatut_code(String statut_code) {
        this.statut_code = statut_code;
    }

    public String getStatut_label() {
        return statut_label;
    }

    public void setStatut_label(String statut_label) {
        this.statut_label = statut_label;
    }
}
