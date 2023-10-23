package champollion;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
public class Enseignant extends Personne {

    ArrayList<ServicePrevu> serviceprevu = new ArrayList<>();
    LinkedList<Intervention> interventions = new LinkedList<>();
    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        int hEquiTD = 0;
        for (ServicePrevu servicep : serviceprevu){
            hEquiTD += 1.5 * servicep.getVolumeCM();
            hEquiTD += servicep.getVolumeTD();
            hEquiTD += 0.75 * servicep.getVolumeTP();
        }
        return Math.round(hEquiTD);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        int equiTdUe = 0;

        for (ServicePrevu servicep : serviceprevu){
            if (servicep.getUe() == ue){
                equiTdUe += 1.5 * servicep.getVolumeCM();
                equiTdUe += servicep.getVolumeTD();
                equiTdUe += 0.75 * servicep.getVolumeTP();
            }
        }
        return Math.round(equiTdUe);
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param vCM le volume d'heures de cours magitral
     * @param vTD le volume d'heures de TD
     * @param vTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int vCM, int vTD, int vTP) {
        ServicePrevu sp = new ServicePrevu( vCM, vTD,vTP, ue, this);
        serviceprevu.add(sp);
    }

    public void ajouteIntervention(Intervention i) {
        interventions.add(i);
    }

    public int heuresPlanifiées(){
        int hP =0 ;
        for (int i = 0; i < interventions.size(); i++){

            switch (interventions.get(i).getType()){

                case CM:
                    hP += interventions.get(i).getDuree() * 1.5;
                    break;
                case TD:
                    hP += interventions.get(i).getDuree();
                    break;
                case TP:
                    hP += interventions.get(i).getDuree() * 0.75;
                    break;
                default:
                    break;
            }

        }
        return Math.round(hP);
    }

    public boolean sousService(){
        boolean res = true;
        if(heuresPlanifiées()>= 192){
            res = false;
        }
        return res;
    }

    public int resteAPlanifier(UE ue, TypeIntervention type) {
        // TODO: Implémenter cette méthode
        int hAPlanifier=0;
        for (ServicePrevu s : serviceprevu) {
            if (s.getUe().equals(ue)) {
                switch (type) {
                    case CM:
                        hAPlanifier = s.getVolumeCM() - hAPlanifier;
                    case TD:
                        hAPlanifier = s.getVolumeTD() - hAPlanifier;
                    case TP:
                        hAPlanifier = s.getVolumeTP() - hAPlanifier;
                        break;
                }
            }
        }
        return hAPlanifier;
    }
}
