package champollion;

public class UE {
    private final String myIntitule;
    private int heuresCM;
    private int heuresTD;
    private int heuresTP;

    public UE(String intitule, int heuresCM, int heuresTD, int heuresTP) {
        myIntitule = intitule;
        this.heuresCM = heuresCM;
        this.heuresTD = heuresTD;
        this.heuresTP = heuresTP;
    }

    public UE(String intitule) {
        this(intitule, 8, 15, 20);

    }

    public String getIntitule() {
        return myIntitule;
    }

    
}
