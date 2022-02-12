package fr.orsys.kingsley.fitness.business;

import java.time.LocalDateTime;

public class Course {
    
    private Long id;
    private LocalDateTime dateHeureDebut;
    private int dureeEnMinutes;
    private int distanceEnMetres;
    private Adherent adherent;
    private Tapis tapis;
    private float calories;
    
    public Course() {
    }
    
    public Course(float calories, LocalDateTime dateHeureDebut, int dureeEnMinutes, int distanceEnMetres, Adherent adherent, Tapis tapis) {
        this.calories = calories;
    	this.dateHeureDebut = dateHeureDebut;
        this.dureeEnMinutes = dureeEnMinutes;
        this.distanceEnMetres = distanceEnMetres;
        this.adherent = adherent;
        this.tapis = tapis;
    }
    
    public Course(Long id, float calories, LocalDateTime dateHeureDebut, int dureeEnMinutes, int distanceEnMetres, Adherent adherent, Tapis tapis) {
        this.id = id;
        this.calories = calories;
        this.dateHeureDebut = dateHeureDebut;
        this.dureeEnMinutes = dureeEnMinutes;
        this.distanceEnMetres = distanceEnMetres;
        this.adherent = adherent;
        this.tapis = tapis;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public LocalDateTime getDateHeureDebut() {
        return dateHeureDebut;
    }
    
    public void setDateHeureDebut(LocalDateTime dateHeureDebut) {
        this.dateHeureDebut = dateHeureDebut;
    }
    
    public int getDureeEnMinutes() {
        return dureeEnMinutes;
    }
    
    public void setDureeEnMinutes(int dureeEnMinutes) {
        this.dureeEnMinutes = dureeEnMinutes;
    }
    
    public int getDistanceEnMetres() {
        return distanceEnMetres;
    }
    
    public void setDistanceEnMetres(int distanceEnMetres) {
        this.distanceEnMetres = distanceEnMetres;
    }
    
    public Adherent getAdherent() {
        return adherent;
    }
    
    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }
    
    public Tapis getTapis() {
        return tapis;
    }
    
    public void setTapis(Tapis tapis) {
        this.tapis = tapis;
    }

	public float getCalories() {
		return calories;
	}

	public void setCalories(float calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", dateHeureDebut=" + dateHeureDebut + ", dureeEnMinutes=" + dureeEnMinutes
				+ ", distanceEnMetres=" + distanceEnMetres + ", adherent=" + adherent + ", tapis=" + tapis
				+ ", calories=" + calories + "]";
	}

}