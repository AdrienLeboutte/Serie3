package PackageSerie3;

public class NiveauException extends Exception {

    private String niveauErreur;

    public NiveauException(String niveauErreur)
    {
        this.niveauErreur = niveauErreur;
    }

    public String getMessage()
    {
        return "Le niveau introduit " +niveauErreur+" est incorrecte";
    }
}
