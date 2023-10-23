package champollion;

public class Salle {
    private String intitule;
    private int capacite;

    public Salle(String intitule, int capacite){
        this.capacite = capacite;
        this.intitule = intitule;
    }

    public String getIntitule(){
        return intitule;
    }

    public int getCapacite(){
        return capacite;
    }
}
