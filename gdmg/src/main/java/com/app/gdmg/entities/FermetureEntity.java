package com.app.gdmg.entities;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "fermetures")
public class FermetureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fermeture_id;

    private Calendar fermeture_start_date;
    private Calendar fermeture_end_date;

    public long getFermeture_id() {
        return fermeture_id;
    }

    public void setFermeture_id(long fermeture_id) {
        this.fermeture_id = fermeture_id;
    }

    public Calendar getFermeture_start_date() {
        return fermeture_start_date;
    }

    public void setFermeture_start_date(Calendar fermeture_start_date) {
        this.fermeture_start_date = fermeture_start_date;
    }

    public Calendar getFermeture_end_date() {
        return fermeture_end_date;
    }

    public void setFermeture_end_date(Calendar fermeture_end_date) {
        this.fermeture_end_date = fermeture_end_date;
    }
}
