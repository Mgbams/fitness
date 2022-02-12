package fr.orsys.kingsley.fitness.business;

public class Tapis {
    private Long id;
    private String numeroSerie;
    private String designation;
    
    public Tapis() {
    }
    
    public Tapis(String numeroSerie, String designation) {
        this.numeroSerie = numeroSerie;
        this.designation = designation;
    }
    
    public Tapis(Long id, String numeroSerie, String designation) {
        this.id = id;
        this.numeroSerie = numeroSerie;
        this.designation = designation;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNumeroSerie() {
        return numeroSerie;
    }
    
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    
    public String getDesignation() {
        return designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }

	@Override
	public String toString() {
		return "Tapis [id=" + id + ", numeroSerie=" + numeroSerie + ", designation=" + designation + "]";
	}
     
}