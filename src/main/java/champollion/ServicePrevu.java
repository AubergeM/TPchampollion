package champollion;

public class ServicePrevu {
    private int vCM, vTD, vTP;
    private UE ue;
    private Enseignant enseignant;

    public ServicePrevu (int vCM, int vTD, int vTP, UE ue, Enseignant e){
        this.vCM = vCM;
        this.vTD = vTD;
        this.vTP = vTP;
        this.ue = ue;
        this.enseignant = e;

    }

    public UE getUe() {
        return ue;
    }

    public int getVolumeCM() {
        return vCM;
    }

    public int getVolumeTD() {
        return vTD;
    }

    public int getVolumeTP() {
        return vTP;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }
}
