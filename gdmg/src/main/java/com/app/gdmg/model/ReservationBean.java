package com.app.gdmg.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;

/**
 * Table des réservations
 */
@Entity
@Table (name = "reservations")
public class ReservationBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservation_id;

    private String reservation_origine;
    private int reservation_nb_adulte;
    private int reservation_nb_enfants;
    private int reservation_nb_bebe;
    private int reservation_nb_animaux;
    private String reservation_precision_animaux;
    private String reversation_precision_enfants;
    private Calendar reservation_date_debut;
    private Calendar reservation_date_fin;
    private String reservation_adresse;
    private String reservation_complement_adresse;
    private String reservation_code_postal;
    private String reservation_ville;
    private String reservation_pays;
    private Calendar reservation_date_creation;
    private Float reservation_prix_location;
    private Float reservation_taxe_sejour;

    private Float reservation_prix_menage;

    private Float reservation_prix_chauffage;

    private Float reservation_prix_serviettes;
    private Float reservation_montant_regle;
    private Float reservation_reste_a_percevoir;
    private Boolean reservation_menage;

    @ManyToOne
    private StatusBean statut;

    @ManyToOne
    private UtilisateurBean client;

    public String getReservation_origine() {
        return reservation_origine;
    }

    public void setReservation_origine(String reservation_origine) {
        this.reservation_origine = reservation_origine;
    }

    public Float getReservation_prix_menage() {
        return reservation_prix_menage;
    }

    public void setReservation_prix_menage(Float reservation_prix_menage) {
        this.reservation_prix_menage = reservation_prix_menage;
    }

    public Float getReservation_prix_chauffage() {
        return reservation_prix_chauffage;
    }

    public void setReservation_prix_chauffage(Float reservation_prix_chauffage) {
        this.reservation_prix_chauffage = reservation_prix_chauffage;
    }

    public Float getReservation_prix_serviettes() {
        return reservation_prix_serviettes;
    }

    public void setReservation_prix_serviettes(Float reservation_prix_serviettes) {
        this.reservation_prix_serviettes = reservation_prix_serviettes;
    }

    public UtilisateurBean getClient() {
        return client;
    }

    public void setClient(UtilisateurBean client) {
        this.client = client;
    }

    public long getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(long reservation_id) {
        this.reservation_id = reservation_id;
    }

    public int getReservation_nb_adulte() {
        return reservation_nb_adulte;
    }

    public void setReservation_nb_adulte(int reservation_nb_adulte) {
        this.reservation_nb_adulte = reservation_nb_adulte;
    }

    public int getReservation_nb_enfants() {
        return reservation_nb_enfants;
    }

    public void setReservation_nb_enfants(int reservation_nb_enfants) {
        this.reservation_nb_enfants = reservation_nb_enfants;
    }

    public int getReservation_nb_bebe() {
        return reservation_nb_bebe;
    }

    public void setReservation_nb_bebe(int reservation_nb_bebe) {
        this.reservation_nb_bebe = reservation_nb_bebe;
    }

    public int getReservation_nb_animaux() {
        return reservation_nb_animaux;
    }

    public void setReservation_nb_animaux(int reservation_nb_animaux) {
        this.reservation_nb_animaux = reservation_nb_animaux;
    }

    public String getReservation_precision_animaux() {
        return reservation_precision_animaux;
    }

    public void setReservation_precision_animaux(String reservation_precision_animaux) {
        this.reservation_precision_animaux = reservation_precision_animaux;
    }

    public String getReversation_precision_enfants() {
        return reversation_precision_enfants;
    }

    public void setReversation_precision_enfants(String reversation_precision_enfants) {
        this.reversation_precision_enfants = reversation_precision_enfants;
    }

    public String getReservation_adresse() {
        return reservation_adresse;
    }

    public void setReservation_adresse(String reservation_adresse) {
        this.reservation_adresse = reservation_adresse;
    }

    public String getReservation_complement_adresse() {
        return reservation_complement_adresse;
    }

    public void setReservation_complement_adresse(String reservation_complement_adresse) {
        this.reservation_complement_adresse = reservation_complement_adresse;
    }

    public String getReservation_code_postal() {
        return reservation_code_postal;
    }

    public void setReservation_code_postal(String reservation_code_postal) {
        this.reservation_code_postal = reservation_code_postal;
    }

    public String getReservation_ville() {
        return reservation_ville;
    }

    public void setReservation_ville(String reservation_ville) {
        this.reservation_ville = reservation_ville;
    }

    public String getReservation_pays() {
        return reservation_pays;
    }

    public void setReservation_pays(String reservation_pays) {
        this.reservation_pays = reservation_pays;
    }


    public Float getReservation_prix_location() {
        return reservation_prix_location;
    }

    public void setReservation_prix_location(Float reservation_prix_location) {
        this.reservation_prix_location = reservation_prix_location;
    }

    public Float getReservation_taxe_sejour() {
        return reservation_taxe_sejour;
    }

    public void setReservation_taxe_sejour(Float reservation_taxe_sejour) {
        this.reservation_taxe_sejour = reservation_taxe_sejour;
    }

    public Float getReservation_montant_regle() {
        return reservation_montant_regle;
    }

    public void setReservation_montant_regle(Float reservation_montant_regle) {
        this.reservation_montant_regle = reservation_montant_regle;
    }

    public Float getReservation_reste_a_percevoir() {
        return reservation_reste_a_percevoir;
    }

    public void setReservation_reste_a_percevoir(Float reservation_reste_a_percevoir) {
        this.reservation_reste_a_percevoir = reservation_reste_a_percevoir;
    }

    public Boolean getReservation_menage() {
        return reservation_menage;
    }

    public void setReservation_menage(Boolean reservation_menage) {
        this.reservation_menage = reservation_menage;
    }

    public StatusBean getStatut() {
        return statut;
    }

    public void setStatut(StatusBean statut) {
        this.statut = statut;
    }

    public Calendar getReservation_date_debut() {
        return reservation_date_debut;
    }

    public void setReservation_date_debut(Calendar reservation_date_debut) {
        this.reservation_date_debut = reservation_date_debut;
    }

    public Calendar getReservation_date_fin() {
        return reservation_date_fin;
    }

    public void setReservation_date_fin(Calendar reservation_date_fin) {
        this.reservation_date_fin = reservation_date_fin;
    }

    public Calendar getReservation_date_creation() {
        return reservation_date_creation;
    }

    public void setReservation_date_creation(Calendar reservation_date_creation) {
        this.reservation_date_creation = reservation_date_creation;
    }
}
