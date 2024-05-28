package com.example.annonce;

import java.time.LocalDateTime;
import java.util.Date;
import java.time.LocalTime;

public class Annonce {
    private int id;
    private String title;
    private int price;
    private String description;
    private Date dateDePublication;
    private Date dateDeFinDePublication;
    private LocalDateTime dateDeCreation;
    private LocalDateTime dateDeModification;

    // constructeur vide
    public Annonce(){}
    // constructeur
    public Annonce (int id,String title, int price, String description, Date dateDePublication , Date dateDeFinDePublication, LocalDateTime dateDeCreation, LocalDateTime dateDeModification){
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.dateDePublication = dateDePublication;
        this.dateDeFinDePublication = dateDeFinDePublication;
        this.dateDeCreation =dateDeCreation;
        this.dateDeModification = dateDeModification;
    }

    public int getId()
    {
      return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }
    public void setTitle( String title)
    {
        this.title = title;
    }

    public int getPrice()
    {
        return price;
    }
    public void setPrice (int price)
    {
        this.price = price;
    }

    public String getDescription(){ return description;}

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDePublication() {
        return dateDePublication;
    }

    public void setDateDePublication(Date dateDePublication) {
        this.dateDePublication = dateDePublication;
    }

    public Date getDateDeFinDePublication() {
        return dateDeFinDePublication;
    }

    public void setDateDeFinDePublication(Date dateDeFinDePublication) {
        this.dateDeFinDePublication = dateDeFinDePublication;
    }

    public LocalDateTime getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(LocalDateTime dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public LocalDateTime getDateDeModification() {
        return dateDeModification;
    }

    public void setDateDeModification(LocalDateTime dateDeModification) {
        this.dateDeModification = dateDeModification;
    }

    @Override
    public String toString() {
        return "Annonce{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", dateDePublication=" + dateDePublication +
                ", dateDeFinDePublication=" + dateDeFinDePublication +
                ", dateDeCreation=" + dateDeCreation +
                ", dateDeModification=" + dateDeModification +
                '}';
    }
}
