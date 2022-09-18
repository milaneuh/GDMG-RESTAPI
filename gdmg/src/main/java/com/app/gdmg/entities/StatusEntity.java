package com.app.gdmg.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table (name = "status")
public class StatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long statut_id;

    private String code;
    private String label;

    @OneToMany(mappedBy = "statut")
    private Collection<ReservationEntity> reservationEntities;

    public long getStatut_id() {
        return statut_id;
    }

    public void setStatut_id(long statut_id) {
        this.statut_id = statut_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
