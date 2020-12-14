package com.example.projetandroidtsp.Models;

public class Profil {
    private long id;
    private String nom;
    private String prenom;
    private Integer age;
    private Integer nb_joue_total;
    private Integer nb_reussi_science;
    private Integer nb_reussi_animaux;
    private Integer nb_reussi_vehicules;
    private Integer nb_reussi_histoire_geo;
    private Integer nb_reussi_sports;
    private Integer nb_reussi_random;
    private Integer nb_reussi_culture_g;
    private Integer nb_reussi_divertissement;

    public Profil(long id, String nom, String prenom, Integer age, Integer nb_joue_total, Integer nb_reussi_science,Integer nb_reussi_animaux,Integer nb_reussi_vehicules,Integer nb_reussi_histoire_geo,Integer nb_reussi_sports,Integer nb_reussi_random,Integer nb_reussi_culture_g,Integer nb_reussi_divertissement){
        super();
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.age=age;
        this.nb_joue_total=nb_joue_total;
        this.nb_reussi_science=nb_reussi_science;
        this.nb_reussi_animaux=nb_reussi_animaux;
        this.nb_reussi_vehicules=nb_reussi_vehicules;
        this.nb_reussi_histoire_geo=nb_reussi_histoire_geo;
        this.nb_reussi_sports=nb_reussi_sports;
        this.nb_reussi_random=nb_reussi_random;
        this.nb_reussi_culture_g=nb_reussi_culture_g;
        this.nb_reussi_divertissement=nb_reussi_divertissement;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNb_joue_total() {
        return nb_joue_total;
    }

    public Integer getNb_reussi_animaux() {
        return nb_reussi_animaux;
    }

    public void setNb_joue_total(Integer nb_joue_total) {
        this.nb_joue_total = nb_joue_total;
    }

    public Integer getNb_reussi_science() {
        return nb_reussi_science;
    }

    public void setNb_reussi_science(Integer nb_reussi_science) {
        this.nb_reussi_science = nb_reussi_science;
    }

    public void setNb_reussi_animaux(Integer nb_reussi_animaux) {
        this.nb_reussi_animaux = nb_reussi_animaux;
    }

    public Integer getNb_reussi_vehicules() {
        return nb_reussi_vehicules;
    }

    public void setNb_reussi_vehicules(Integer nb_reussi_vehicules) {
        this.nb_reussi_vehicules = nb_reussi_vehicules;
    }

    public Integer getNb_reussi_histoire_geo() {
        return nb_reussi_histoire_geo;
    }

    public void setNb_reussi_histoire_geo(Integer nb_reussi_histoire_geo) {
        this.nb_reussi_histoire_geo = nb_reussi_histoire_geo;
    }

    public Integer getNb_reussi_sports() {
        return nb_reussi_sports;
    }

    public void setNb_reussi_sports(Integer nb_reussi_sports) {
        this.nb_reussi_sports = nb_reussi_sports;
    }

    public Integer getNb_reussi_random() {
        return nb_reussi_random;
    }

    public void setNb_reussi_random(Integer nb_reussi_random) {
        this.nb_reussi_random = nb_reussi_random;
    }

    public Integer getNb_reussi_culture_g() {
        return nb_reussi_culture_g;
    }

    public void setNb_reussi_culture_g(Integer nb_reussi_culture_g) {
        this.nb_reussi_culture_g = nb_reussi_culture_g;
    }

    public Integer getNb_reussi_divertissement() {
        return nb_reussi_divertissement;
    }

    public void setNb_reussi_divertissement(Integer nb_reussi_divertissement) {
        this.nb_reussi_divertissement = nb_reussi_divertissement;
    }
}
