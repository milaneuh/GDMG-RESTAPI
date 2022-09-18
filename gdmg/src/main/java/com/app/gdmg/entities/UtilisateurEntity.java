package com.app.gdmg.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "utilisateurs")
public class UtilisateurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long utilisateurId;

    private String password;
    @Column(unique = true)
    private String mail;
    private String civilite;
    private String nom;
    private String prenom;
    private Boolean newsletter;
    private String telephone;
    private String telephone2;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RolesEntity role;

    @OneToMany(mappedBy = "client")
    private List<ReservationEntity> reservations;

    public long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Boolean getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Boolean newsletter) {
        this.newsletter = newsletter;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public RolesEntity getRole() {
        return role;
    }

    public void setRole(RolesEntity role) {
        this.role = role;
    }

    public List<ReservationEntity> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationEntity> reservations) {
        this.reservations = reservations;
    }

    public UtilisateurEntity(String password, String mail, String civilite, String nom, String prenom, Boolean newsletter, String telephone, String telephone2, RolesEntity role) {

        this.password = password;
        this.mail = mail;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.newsletter = newsletter;
        this.telephone = telephone;
        this.telephone2 = telephone2;
        this.role = role;
    }

    public UtilisateurEntity() {
    }

    public String toString(){
        return "Id : "+this.utilisateurId+"\n"+
                "Mail : "+ this.mail +"\n"+
                "Password : "+this.password+"\n"+
                "Civilite : "+this.civilite+"\n"+
                "Nom : "+this.nom+"\n"+
                "Prenom : "+this.prenom+"\n"+
                "Newsletter : "+this.newsletter.toString()+"\n"+
                "Telephone : "+this.telephone+"\n"+
                "Telephone2 : "+this.telephone2+"\n";
    }
}
