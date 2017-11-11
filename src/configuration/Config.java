package configuration;

import game.Chocolat;

import javax.security.auth.login.Configuration;
import java.util.ArrayList;

public class Config {

    public int  m,n,i,j;


    public Config(int m, int n, int i, int j) {
        this.m=m;
        this.n=n;
        this.i=i;
        this.j=j;
    }


    public String toString() {
        return "("+m+","+n+","+i+","+j+")";
    }

    private static int max(ArrayList<Integer> n) {
        int m = n.get(0);
        for (int i = 0; i < n.size(); i++) {
            if (n.get(i) > m) {
                m = n.get(i);
            }
        }

        return m;
    }

    private static int max(int x, int y) {
        if (x > y)
            return x;
        else
            return y;

    }

    public int hashCode(){
        return m*n*i*j;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Config)
            return equalsConfiguration((Config) obj);
        return super.equals(obj);
    }


    public boolean equalsConfiguration(Config configuration) {
        return this.i == configuration.i && this.j == configuration.j && this.m == configuration.m
                && this.n == configuration.n;
    }


}
