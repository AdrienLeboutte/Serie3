package PackageSerie3;

import java.io.Serializable;

public class AnneeEtude implements Serializable {

    private String intituleEtudes;
    private int annee;
    private String niveau;


    public AnneeEtude(String intituleEtudes, int annee, String niveau) throws  AnneeException, NiveauException {

        this.intituleEtudes = intituleEtudes;
        setAnnee(annee);
        setNiveau(niveau);
    }


    public void setAnnee(int annee) throws AnneeException {

        if(annee < 1 || annee > 3)
        {
            throw new AnneeException(annee);
        }
        this.annee = annee;
    }

    public void setNiveau(String niveau) throws NiveauException {

       niveau = niveau.toLowerCase();

        if((niveau.compareTo("bac")!= 0 )&& (niveau.compareTo("master") != 0))
        {
            throw new NiveauException(niveau);
        }

        this.niveau = niveau;
    }


    public String toString()
    {
        return niveau +" "+ annee +" en "+intituleEtudes;
    }



}
