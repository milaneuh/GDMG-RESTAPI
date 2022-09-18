package com.app.gdmg.models;

public class UtilisateurBean {

    private String password;
    private String mail;
    private String civilite;
    private String nom;
    private String prenom;
    private Boolean newsletter;
    private String telephone;
    private String telephone2;
    private String role;

    public UtilisateurBean(String password, String mail, String civilite, String nom, String prenom, Boolean newsletter, String telephone, String telephone2, String role) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String toString(){
        return "Mail : "+ this.mail +"\n"+
                "Password : "+this.password+"\n"+
                "Civilite : "+this.civilite+"\n"+
                "Nom : "+this.nom+"\n"+
                "Prenom : "+this.prenom+"\n"+
                "Newsletter : "+this.newsletter.toString()+"\n"+
                "Telephone : "+this.telephone+"\n"+
                "Telephone2 : "+this.telephone2+"\n"+
                "Role_id : "+this.role.toString();
    }
}
