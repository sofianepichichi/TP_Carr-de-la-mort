package game;

import configuration.Config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Dyn_Chocolat {


    private static HashMap<Config, Integer> M = new HashMap<>();

    public static int algo_dynamique(int m, int n, int i, int j) {

        Config C = new Config(m, n, i, j);
        // verification si la Config m,n est deja memoriser
        if (M.containsKey(C)) {
            return M.get(C);
        }

        ArrayList Negatif = new ArrayList();
        ArrayList Positif = new ArrayList();
        int res = 0;

        if (m == 1 && n == 1) {
            Config init = new Config(1, 1, 0, 0);
            M.put(init, 0);
        }
 // couper aprés le carré poissonie

        for(int k=1;k<m-i;k++){

            Config init=new Config(i+k,n,i,j);


            if (!M.containsKey(init)) { // si la configuration elle n'existe pas !!
                res = algo_dynamique(i+k,n,i,j);

                if (res > 0)
                    Positif.add(res);
                if (res <= 0)
                    Negatif.add(res);

                M.put(init, res);

            }
            else{

                res = M.get(init);
                if(res > 0) Positif.add(res);
                if(res <= 0) Negatif.add(res
                );
            }

        }
//couper avant le carré poissonie


        for(int k=1;k<i+1;k++){

            Config init=new Config(m-k,n,i-k,j);

            if (!M.containsKey(init)) { // si sur cette cofi nexiste pas !

               res = algo_dynamique(m-k,n,i-k,j);
                if (res > 0)
                    Positif.add(res);
                if (res <= 0)
                    Negatif.add(res);

                M.put(init, res);

            }
            else{

                res = M.get(init);
                if(res > 0) Positif.add(res);
                if(res <= 0) Negatif.add(res);
            }

        }



        for(int k=1;k<n-j;k++){

            Config init=new Config(m,j+k,i,j);


            if (!M.containsKey(init)) {
                res = algo_dynamique(m,j+k,i,j);

                if (res > 0)
                    Positif.add(res);
                if (res <= 0)
                    Negatif.add(res);
                M.put(init,res);
            }
            else{

                res = M.get(init);
                if(res > 0) Positif.add(res);
                if(res <= 0) Negatif.add(res);
            }

        }


        for(int k=1;k<j+1;k++){

            Config init=new Config(m,n-k,i,j-k);



            if (!M.containsKey(init)) {
                res= algo_dynamique(m,n-k,i,j-k);



                if (res > 0)
                    Positif.add(res);
                if (res <= 0)
                    Negatif.add(res);
                M.put(init, res);
            } else {

                res = M.get(init);
                if (res > 0)
                    Positif.add(res);
                if (res <= 0)
                    Negatif.add(res);
            }

        }

        if (Negatif.size()!= 0) {

            return  -max(Negatif) + 1; // on va essaie de de gagner le plus vite possible
        }

        if (Positif.size() != 0) { // on va essaie de perde aprés plusieurs coups, tarder l'adversaire a gagner

           return  -max(Positif) - 1;

        }

        return 0;
    }

    private static int max(ArrayList<Integer> n) {
        int m = n.get(0);
        for (int i = 1; i < n.size(); i++) {
            if (n.get(i) > m) {
                m = n.get(i);
            }
        }

        return m;
    }


    /* Fonction pour trouver la configuration qui donne 127 comme résultat*/

    public static void new_configuration() {
        LinkedList<String> list = new LinkedList<>();

        for(int i = 126; i >= 0; i--)
            for(int j = 126; j >= 0; j--) {
                System.out.print("configuration: 127, 127, " + i + ", " + j);
                int res = algo_dynamique(127,127,i,j);
                System.out.print(" = " + res);
                if(res == 127) {
                    System.out.print("idéal configuration");
                    list.add("configuration: 127, 127, " + i + ", " + j + " = " + res);
                }
                System.out.println("");
            }

        System.out.println("results obtenu :");

        for(String ch : list)
            System.out.println(ch);
    }



    }



