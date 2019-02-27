package PackageSerie3;

import java.io.Serializable;

public class Etudiant implements Serializable {

    private String nom;
    private String prenom;
    private AnneeEtude etude;

    public Etudiant(String nom, String prenom, AnneeEtude etude) {
        this.nom = nom;
        this.prenom = prenom;
        this.etude = etude;
    }

    public String toString()
    {
        return prenom +" "+ nom + " en " + etude;
    }




}
