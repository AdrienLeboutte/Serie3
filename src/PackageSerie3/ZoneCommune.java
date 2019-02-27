package PackageSerie3;

public class ZoneCommune {

    private Etudiant etudiant;
    private Boolean aEcraser = true;

    public synchronized Etudiant getEtudiant()
    {
        if(aEcraser)
        {
            try
            {
                wait();
            }
            catch(InterruptedException exception)
            {
                exception.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " lit la valeur " + etudiant);

        aEcraser = true;
        notify(); //reveille thread en attente

        return etudiant;
    }

    public synchronized void setEtudiant(Etudiant etudiant)
    {
        if(!aEcraser)
        {
            try
            {
                wait();
            }
            catch (InterruptedException exception)
            {
                exception.printStackTrace();
            }
        }
        this.etudiant = etudiant;

        System.out.println(Thread.currentThread().getName()+" ecrit la valeur "+this.etudiant);

        aEcraser = false;
        notify();
    }

}
