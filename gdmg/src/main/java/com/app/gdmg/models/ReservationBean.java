package com.app.gdmg.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Calendar;
import java.util.Date;

public class ReservationBean {
    private String code;
    private String origine;
    private int adulte;
    private int enfant;
    private int bebe;
    private int animaux;
    private String precisionAnimaux;
    private String precisionEnfants;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateDebut;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateFin;
    private String adresse;
    private String complementAdresse;
    private String codePostal;
    private String ville;
    private String pays;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateCreation;
    private Float prixLocation;
    private Float taxeSejour;
    private Float prixMenage;
    private Float prixChauffage;
    private Float prixServiettes;
    private Float montantRegle;
    private Float resteAPercevoir;
    private String codeStatus;
    private String clientMail;

    public ReservationBean(String origine, int adulte, int enfant, int bebe, int animaux, String precisionAnimaux, String precisionEnfants, Date dateDebut, Date dateFin, String adresse, String complementAdresse, String codePostal, String ville, String pays, Date dateCreation, Float prixLocation, Float taxeSejour, Float prixMenage, Float prixChauffage, Float prixServiettes, Float montantRegle, Float resteAPercevoir, String codeStatus, String clientMail) {
        this.origine = origine;
        this.adulte = adulte;
        this.enfant = enfant;
        this.bebe = bebe;
        this.animaux = animaux;
        this.precisionAnimaux = precisionAnimaux;
        this.precisionEnfants = precisionEnfants;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.adresse = adresse;
        this.complementAdresse = complementAdresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
        this.dateCreation = dateCreation;
        this.prixLocation = prixLocation;
        this.taxeSejour = taxeSejour;
        this.prixMenage = prixMenage;
        this.prixChauffage = prixChauffage;
        this.prixServiettes = prixServiettes;
        this.montantRegle = montantRegle;
        this.resteAPercevoir = resteAPercevoir;
        this.codeStatus = codeStatus;
        this.clientMail = clientMail;
    }

    public String getClientMail() {
        return clientMail;
    }

    public void setClientMail(String clientMail) {
        this.clientMail = clientMail;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public int getAdulte() {
        return adulte;
    }

    public void setAdulte(int adulte) {
        this.adulte = adulte;
    }

    public int getEnfant() {
        return enfant;
    }

    public void setEnfant(int enfant) {
        this.enfant = enfant;
    }

    public int getBebe() {
        return bebe;
    }

    public void setBebe(int bebe) {
        this.bebe = bebe;
    }

    public int getAnimaux() {
        return animaux;
    }

    public void setAnimaux(int animaux) {
        this.animaux = animaux;
    }

    public String getPrecisionAnimaux() {
        return precisionAnimaux;
    }

    public void setPrecisionAnimaux(String precisionAnimaux) {
        this.precisionAnimaux = precisionAnimaux;
    }

    public String getPrecisionEnfants() {
        return precisionEnfants;
    }

    public void setPrecisionEnfants(String precisionEnfants) {
        this.precisionEnfants = precisionEnfants;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getComplementAdresse() {
        return complementAdresse;
    }

    public void setComplementAdresse(String complementAdresse) {
        this.complementAdresse = complementAdresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Float getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(Float prixLocation) {
        this.prixLocation = prixLocation;
    }

    public Float getTaxeSejour() {
        return taxeSejour;
    }

    public void setTaxeSejour(Float taxeSejour) {
        this.taxeSejour = taxeSejour;
    }

    public Float getPrixMenage() {
        return prixMenage;
    }

    public void setPrixMenage(Float prixMenage) {
        this.prixMenage = prixMenage;
    }

    public Float getPrixChauffage() {
        return prixChauffage;
    }

    public void setPrixChauffage(Float prixChauffage) {
        this.prixChauffage = prixChauffage;
    }

    public Float getPrixServiettes() {
        return prixServiettes;
    }

    public void setPrixServiettes(Float prixServiettes) {
        this.prixServiettes = prixServiettes;
    }

    public Float getMontantRegle() {
        return montantRegle;
    }

    public void setMontantRegle(Float montantRegle) {
        this.montantRegle = montantRegle;
    }

    public Float getResteAPercevoir() {
        return resteAPercevoir;
    }

    public void setResteAPercevoir(Float resteAPercevoir) {
        this.resteAPercevoir = resteAPercevoir;
    }

    public String getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(String codeStatus) {
        this.codeStatus = codeStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
