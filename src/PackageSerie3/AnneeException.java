package PackageSerie3;

public class AnneeException extends Exception{

    public int anneeErreur;


    public AnneeException(int annee)
    {
        this.anneeErreur = annee;
    }


    public String getMessage()
    {
        return "L'annee introduite ( "+anneeErreur+" ) est incorrecte";
    }

}
