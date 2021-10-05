public class Polynome {

    private int coeff;
    private int deg; //deg >= 0
    private Polynome suiv;


    public Polynome(int c, int d, Polynome p){
        coeff = c;
        deg = d;
        suiv = p;
    }

    public static int puiss(int x, int n){
        if(n==0){
            return 1;
        }
        else return x * puiss(x,n-1);
    }

    public static String toString(Polynome p){
        if(p==null)
            return "";
        else{
            String rep = " + ";
            if(p.coeff<0){
                rep=" ";
            }
            return rep + p.coeff +"x^"+p.deg +  toString(p.suiv);
        }
    }

    public static int eval(Polynome p, int x){
        if(p==null){
            return 0;
        }
        return p.coeff * puiss(x,p.deg) + eval(p.suiv, x);
    }

    public static int degre(Polynome p){
        if(p==null)
            return 1;
        else {
            int max = 0;
            if(max < p.deg){
                max = p.deg;
                return max;

            }

            return degre(p.suiv);
        }


    }

    public static void main(String[] args) {
        Polynome p1 = new Polynome(-5,7, null);
        Polynome p2 = new Polynome(2,3, p1);
        Polynome p3 = new Polynome(-4,4, p2);

        System.out.println(toString(p2));
        System.out.println(eval(p2,2));


    }


}
