package game;

import java.util.Scanner;


public class Main {

    public static void main(String args[]) {

        Chocolat N = new Chocolat();
        Dyn_Chocolat D = new Dyn_Chocolat();




        final Scanner gm = new Scanner(System.in);
        System.out.println("jeu du carré de la mort.");
        System.out.println("Veuillez choisir selon votre choix :");
        final int choix = gm.nextInt();
        //###choix des algortithme a utiliser

        switch (choix) {
            case 1: {
                System.out.println("-------Algorithme naif---------");
                System.out.println("Veuillez saisir la longueur de la table :");
                final int longueur = gm.nextInt();
                System.out.println("Donner la largeur de la table :");
                final int largeur = gm.nextInt();
                System.out.println("Positioner en positif le carré de la mort sur la longueur (entre 0 et "
                        + (longueur - 1) + ") :");
                final int positifx = gm.nextInt();
                System.out.println("Positioner en positif le carré de la mort sur la largeur (entre 0 et "
                        + (largeur - 1) + ") :");
                final int positify = gm.nextInt();
                long deb = System.nanoTime();
                System.out.println("Résultat : (" + longueur + "," + largeur + "," + positifx + "," + positify + ") : "
                        + N.algo_naif(longueur, largeur, positifx, positify));
                System.out.println(
                        "Le temps que l'algorithme naif a prit " + ((System.nanoTime() - deb) / 1000000000) + " secondes");
                deb = System.nanoTime();
            }


            case 2: {
                System.out.println("---------Algorithme Dynamique----------");
                System.out.println("Veuillez saisir la longueur de la  table : ");
                final int longueur = gm.nextInt();
                System.out.println("Donner la largeur de la table");
                final int largeur = gm.nextInt();
                System.out.println("Positioner en positif le carré de la mort sur la longueur (entre 0 et "
                        + (longueur - 1) + ") :");
                final int positifx = gm.nextInt();
                System.out.println("Positioner en positif le carré de la mort sur la largeur (entre 0 et "
                        + (largeur - 1) + ") :");
                final int positify = gm.nextInt();
                long deb = System.nanoTime();
                System.out.println("Résultat : (" + longueur + "," + largeur + "," + positifx + "," + positify + "):"
                        + D.algo_dynamique(longueur, largeur, positifx, positify));
                System.out.println("Le temps que l'algorithme Dynamique  a prit exactement " + ((System.nanoTime() - deb) / 1000000000) + "secondes");
                deb = System.nanoTime();


            }

            case 3 :{

                System.out.println("################################################");
                System.out.println("----------Detérminer tous les pairs (i,j) ------");
                System.out.println("--------- Configuration (127,127,i,j)--------");
                D.new_configuration();
            }

        }
    }
}
