package com.example.tp5;

public class Contact {
    private String nom;
    private String prenom;
    private String imageURL;

    public Contact(String nom, String prenom, String imageUrl){
        this.nom = nom;
        this.prenom = prenom;
        this.imageURL = imageUrl;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getImageURL() {
        return imageURL;
    }
}
