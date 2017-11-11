package game;

import java.util.LinkedList;
import java.util.List;


/**
 * author KACI SOFIANE
 */

public class Chocolat {



    /**
     * @param m la largeur de la configuration
     * @param n la longeur de la configuration
     * @param i la largeur de carré de la mort
     * @param j la longeur  du carré de la mort
     * @return
     */


    //################## Vesrion Naif##################
    public static int algo_naif(int m, int n, int i, int j) {
        List<Integer> positif = new LinkedList<Integer>();
        List<Integer> negatif = new LinkedList<Integer>();

        if ((m == n) && (n == 1) && (i == j) && (i == 0)) {
            return 0;
        }


        for (int k = 1; k <= i; k++) {
            int res = algo_naif(m - k, n, i - k, j);

            if (res > 0) {
                positif.add(Integer.valueOf(res));
            } else {
                negatif.add(Integer.valueOf(res));
            }
        }

        for (int k = i + 1; k < m; k++) {
            int res = algo_naif(k, n, i, j);
            if (res > 0) {
                positif.add(Integer.valueOf(res));
            } else {
                negatif.add(Integer.valueOf(res));
            }
        }

        for (int k = 1; k <= j; k++) {
            int res = algo_naif(m, n - k, i, j - k);
            if (res > 0) {
                positif.add(Integer.valueOf(res));
            } else {
                negatif.add(Integer.valueOf(res));
            }
        }


        for (int k = j + 1; k < n; k++) {
            int res = algo_naif(m, k, i, j);
            if (res > 0) {
                positif.add(Integer.valueOf(res));
            } else {
                negatif.add(Integer.valueOf(res));
            }
        }

        /*## SI YA PLUS DE VALEUR NEGATIVES/ POSITIVE on ajoute soit dans +1 pour le maximum soit pour
        negatif dans le cas ou ya plus de valeurs positves sinon dans le positif */

        if (negatif.isEmpty()) {
            return -((maximum(positif)).intValue() + 1);
        } else {
            return -(maximum(negatif)).intValue() + 1;
        }
    }
    // la fonction maximum qui prend le maximum de la liste

    public static Integer maximum(List<Integer> list) {
        Integer p = list.get(0);
        for (Integer i : list) {
            if (i.compareTo(p) > 0) {
                p = i;
            }
        }
        return p;
    }

}