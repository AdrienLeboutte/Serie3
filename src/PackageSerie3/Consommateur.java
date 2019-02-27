package PackageSerie3;

public class Consommateur extends Thread {

    private ZoneCommune commun;

    private Etudiant etudiant;

    public Consommateur(ZoneCommune commun)
    {
        super("Consommateur");
        this.commun = commun;
    }


    public void run()
    {
        for(int indice = 0; indice <10; indice++)
        {
            try
            {
                Thread.sleep(3000);
            }
            catch (InterruptedException exception)
            {
                exception.printStackTrace();
            }

            System.out.println(commun.getEtudiant());
        }
    }

}
