package PackageSerie3;

import javax.swing.*;
import java.io.*;

public class Producteur extends Thread {


    private ZoneCommune commun;


    public Producteur(ZoneCommune commun)
    {
        super("producteur");
        this.commun = commun;
    }

    public void run()
    {
        Etudiant etudiant;

        ObjectInputStream entree = null;

        try
        {
            entree = new ObjectInputStream(new FileInputStream("DonneesEtudiant.txt"));
        }
        catch (IOException exception)
        {
            JOptionPane.showMessageDialog(null,"Erreur ouverture fichier");
        }

        for(int indice = 0; indice < 10; indice++)
        {
            try
            {
                Thread.sleep(3000);
            }
            catch (InterruptedException exception)
            {
                exception.printStackTrace();
            }
            try
            {
                etudiant = (Etudiant)entree.readObject();
                commun.setEtudiant(etudiant);
            }
            catch (Exception exception)
            {
                JOptionPane.showMessageDialog(null,"Erreur lié à la lecture etudiant");
            }
        }


        try
        {
            entree.close();
        }

        catch (IOException exception)
        {
            JOptionPane.showMessageDialog(null,"Erreur lie a la fermeture fichie");
        }
    }



}
