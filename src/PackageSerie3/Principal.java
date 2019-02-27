package PackageSerie3;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Principal {

    public static void main(String[] args) {

        ObjectOutputStream sortie = null; // pour ecriture

        ObjectInputStream entree =  null; // pour lecture

        try {

            AnneeEtude an1 = new AnneeEtude("Informatique", 1, "bac");
            AnneeEtude an2 = new AnneeEtude("Informatique", 2, "bac");
            AnneeEtude an3 = new AnneeEtude("Informatique", 3, "bac");
            AnneeEtude an4 = new AnneeEtude("Marketing", 3, "Master");

            Etudiant etu1 = new Etudiant("Leboutte", "Adrien", an2);
            Etudiant etu2 = new Etudiant("Hensen", "Florent", an1);
            Etudiant etu3 = new Etudiant("Servais", "David", an3);
            Etudiant etu4 = new Etudiant("Khan", "Zaib", an2);
            Etudiant etu5 = new Etudiant("Bontemp", "Sylvie", an4);
            Etudiant etu6 = new Etudiant("Demoustiez", "Romain", an3);
            Etudiant etu7 = new Etudiant("Labar", "Maxime", an3);
            Etudiant etu8 = new Etudiant("Rousseaux", "Corentin", an2);
            Etudiant etu9 = new Etudiant("Vandendaele", "Clement", an1);
            Etudiant etu10 = new Etudiant("Florian", "Janssens", an2);

            sortie  = new ObjectOutputStream(new FileOutputStream("DonneesEtudiant.txt"));

            entree = new ObjectInputStream(new FileInputStream("DonneesEtudiant.txt"));

            //***********************************Ecriture dans fichier d'objet Etudiant**************
            sortie.writeObject(etu1);
            sortie.writeObject(etu2);
            sortie.writeObject(etu3);
            sortie.writeObject(etu4);
            sortie.writeObject(etu5);
            sortie.writeObject(etu6);
            sortie.writeObject(etu7);
            sortie.writeObject(etu8);
            sortie.writeObject(etu9);
            sortie.writeObject(etu10);

            //*****************************************************************************************
            //**********************************Lecture dans fichier d'objet Etudiant*****************
            /* //etape3
           Etudiant etudiant;

           etudiant = (Etudiant)entree.readObject( );

           while(etudiant != null)
           {
               System.out.println(etudiant);
               etudiant = (Etudiant)entree.readObject();
           }
            */


            //*******************************************************************************************
            //**********************Etape 4******************************************************
            ZoneCommune commun = new ZoneCommune();

            Producteur producteur = new Producteur(commun);

            Consommateur consommateur = new Consommateur(commun);

            producteur.start();
            consommateur.start();

        }
        //*********************************************************************************************
        //*******************Exception pour annee etude**************************************************

        catch (NiveauException nivException)
        {
            JOptionPane.showMessageDialog(null, nivException.getMessage(), "Niveau Incorrecte", JOptionPane.ERROR_MESSAGE);
        }
        catch (AnneeException anException) {
            JOptionPane.showMessageDialog(null, anException.getMessage(), "Annee Incorrecte", JOptionPane.ERROR_MESSAGE);
        }

        //**********************************************************************************************


        //******************************Exception pout lecture **************************

        catch(EOFException eofException){
            JOptionPane.showMessageDialog(null,"Plus d'enregistrement");
        }
        catch(IOException ioException)
        {
            JOptionPane.showMessageDialog(null,ioException.getMessage( ));
        }

        catch(Exception exception) {
            JOptionPane.showMessageDialog(null,"Erreur autre que lecture");
        }

        //***********************************************************************************

        finally {
            if(entree != null)
            {
                try
                {
                    entree.close();
                }
                catch (IOException ioExeception)
                {
                    JOptionPane.showMessageDialog(null,ioExeception.getMessage( ));
                }
            }

            try {
                if(sortie != null) {
                    sortie.close();
                }


            }


            catch(IOException ioException)
            {
                JOptionPane.showMessageDialog(null,ioException.getMessage( ));
            }
        }

    }
}
