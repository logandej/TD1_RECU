public class Arbre {

    private int val;
    private Arbre filsG;
    private Arbre filsD;

    public Arbre(int v) {
        val = v;
        filsG = null;
        filsD = null;
    }

    public Arbre(int v, Arbre fg, Arbre fd) {
        val = v;
        filsG = fg;
        filsD = fd;
    }

    public static boolean estVide(Arbre a){
        return a==null;
    }

    public static int nbEntiers(Arbre a){
       if(estVide(a))
           return 0;
       return nbEntiers(a.filsG)+nbEntiers(a.filsD)+1;
    }

    public static int nbFeuilles(Arbre a){
        if(estVide(a)){
            return 0;
        }
        if(estVide(a.filsD) && estVide(a.filsG))
            return 1;
        return nbFeuilles(a.filsG)+nbFeuilles(a.filsD);
    }

    public static String toString(Arbre a, String s){
        if(estVide(a))
            return "";
        else return  "\u001B[31m"+toString(a.filsD ,s + "---") + s +a.val + "\n"+ "\u001B[34m"+toString(a.filsG ,s + "---");
    }

    public static boolean recherche(Arbre a, int x){
        if(estVide(a)){
            return false;
        }
        if(x== a.val){
            return true;
        }
        return recherche(a.filsG,x) || recherche(a.filsD,x);

    }

    public static boolean pereFilsEgaux(Arbre a){
        if(estVide(a.filsG)||estVide(a.filsD)){
            return false;
        }
        if(a.filsD.val== a.val || a.filsG.val==a.val){
            return true;
        }
        return pereFilsEgaux(a.filsG) || pereFilsEgaux(a.filsD);
    }
    public static void main(String[] args) {
        Arbre A7 = new Arbre(1,null,null);
        Arbre A6 = new Arbre(5,null,null);
        Arbre A5 = new Arbre(5,null,A7);
        Arbre A4 = new  Arbre(5,A6 ,A5);
        Arbre A3 = new  Arbre(3,null ,A4);
        Arbre A2 = new  Arbre(2,null ,null);
        Arbre A1 = new  Arbre(1,A2 ,A3);

        System.out.println("nombre de l'arbre = "+nbEntiers(A1));
        System.out.println(toString(A1," "));
        System.out.println("nombre de feuilles = "+nbFeuilles(A1));
        System.out.println(recherche(A1,5));
        System.out.println(pereFilsEgaux(A1));
    }
}
