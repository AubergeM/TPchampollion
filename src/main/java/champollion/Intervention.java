package champollion;
import java.util.Date;

public class Intervention {
    private Salle s;
    private UE ue;
    private Enseignant e;
    private Date debut;
    private int duree;
    private boolean annulee = false;
    private TypeIntervention type;

    public Intervention(Salle s, UE ue, Enseignant e, Date debut, int duree, TypeIntervention type){
        this.debut = debut;
        this.duree = duree;
        this.s = s;
        this.ue = ue;
        this.e = e;
        this.type = type;

    }
    public void annuler(){
        this.annulee = true;
    }

    public Date getDebut() {
        return debut;
    }

    public int getDuree() {
        return duree;
    }

    public TypeIntervention getType() {
        return type;
    }

    public boolean isAnnulee() {
        return annulee;
    }

}
