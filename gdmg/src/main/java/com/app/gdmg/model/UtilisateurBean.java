package com.app.gdmg.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table (name = "utilisateurs")
public class UtilisateurBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long utilisateur_id;

    private String utilisateur_password;
    private String utilisateur_mail;
    private String utilisateur_civilite;
    private String utilisateur_nom;
    private String utilisateur_prenom;
    private Boolean utilisateur_newsletter;
    private String utilisateur_telephone;
    private String utilisateur_telephone_2;

    @ManyToOne
    private RolesBean role;

    @OneToMany(mappedBy = "client")
    Collection<ReservationBean> reservationBeans;

    public long getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(long utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    public String getUtilisateur_password() {
        return utilisateur_password;
    }

    public void setUtilisateur_password(String utilisateur_password) {
        this.utilisateur_password = utilisateur_password;
    }

    public String getUtilisateur_mail() {
        return utilisateur_mail;
    }

    public void setUtilisateur_mail(String utilisateur_mail) {
        this.utilisateur_mail = utilisateur_mail;
    }

    public String getUtilisateur_civilite() {
        return utilisateur_civilite;
    }

    public void setUtilisateur_civilite(String utilisateur_civilite) {
        this.utilisateur_civilite = utilisateur_civilite;
    }

    public String getUtilisateur_nom() {
        return utilisateur_nom;
    }

    public void setUtilisateur_nom(String utilisateur_nom) {
        this.utilisateur_nom = utilisateur_nom;
    }

    public String getUtilisateur_prenom() {
        return utilisateur_prenom;
    }

    public void setUtilisateur_prenom(String utilisateur_prenom) {
        this.utilisateur_prenom = utilisateur_prenom;
    }

    public Boolean getUtilisateur_newsletter() {
        return utilisateur_newsletter;
    }

    public void setUtilisateur_newsletter(Boolean utilisateur_newsletter) {
        this.utilisateur_newsletter = utilisateur_newsletter;
    }

    public String getUtilisateur_telephone() {
        return utilisateur_telephone;
    }

    public void setUtilisateur_telephone(String utilisateur_telephone) {
        this.utilisateur_telephone = utilisateur_telephone;
    }

    public String getUtilisateur_telephone_2() {
        return utilisateur_telephone_2;
    }

    public void setUtilisateur_telephone_2(String utilisateur_telephone_2) {
        this.utilisateur_telephone_2 = utilisateur_telephone_2;
    }

    public RolesBean getRole() {
        return role;
    }

    public void setRole(RolesBean role) {
        this.role = role;
    }
}
