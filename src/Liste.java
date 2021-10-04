public class Liste {
    private int val;
    private Liste suiv;
    public Liste(int x){//construit la liste avec un entier x
        this.val = x;
        this.suiv = null;
    }
    public Liste(int x, Liste l){
        this.val = x;
        this.suiv = l;
    }
    public static boolean estVide(Liste l){
        return l==null;
    }
    public Liste copie(Liste l){
//action : retourne une copie de l (en recopiant tous les maillons)
        if(estVide(l)){
            return null;
        }
        else{
            return new Liste(l.val, copie(l.suiv));
        }
    }
    public static String toString(Liste l){
        if(estVide(l))
            return "";
        else
            return l.val+" "+toString(l.suiv);
    }

    public static int longeur(Liste l){

        if(!estVide(l)){
            return 1+longeur(l.suiv);
        }
        else{
            return 0;
        }

    }
    public static boolean croissant(Liste l){
        if(longeur(l)>1){
            if(l.val<=l.suiv.val){
                return croissant(l.suiv);
            }
            else return false;
        }
        else {
            return true;
        }
    }

    public static Liste ajoutFinV1(Liste l, int x){
        if(estVide(l)){
               return new Liste(x);
        }
            Liste temp = ajoutFinV1(l.suiv,x);
            l.suiv=temp;
            return l;
    }
    public static Liste ajoutFinV3(Liste l, int x){
        if(estVide(l)){
            return new Liste(x);
        }
        Liste tmp = ajoutFinV3(l.suiv, x);
        Liste res = new Liste(l.val, tmp);
        return  res;
    }

    public static Liste concatV1(Liste l1, Liste l2){
        if(estVide(l1) || estVide(l2)){
            return null;
        }
        Liste res = ajoutFinV1(l1, l2.val);
        concatV1(l1,l2.suiv);
        return res;
    }

    public static Liste concatV2(Liste l1, Liste l2){
        if(estVide(l1) || estVide(l2)){
            return null;
        }
        Liste res = l1.copie(l2);
        ajoutFinV1(res,l2.val);
        concatV1(res,l2.suiv);
        return res;
    }

    public static void main(String[] args) {
        Liste liste = new Liste(3);
        Liste liste1 = new Liste(2, liste);
        Liste liste2 = new Liste(1, liste1);

        Liste liste11 = new Liste(8);
        Liste liste22 = new Liste(7, liste11);
        Liste liste33 = new Liste(89, liste22);

        liste.copie(liste1);
        liste.copie(liste2);



        System.out.println(toString(liste2));
        System.out.println(longeur(liste2));
        System.out.println(croissant(liste2));
        ajoutFinV1(liste2, 1);
        System.out.println(toString(liste2));



        liste11.copie(liste22);
        liste11.copie(liste33);

       /* System.out.println("\n\nConcate");
        System.out.println(toString(liste33));
        Liste listeconcat = concatV1(liste2,liste33);
        System.out.println(toString(listeconcat));*/

        System.out.println("testConcate");
        Liste resc = concatV2(liste2, liste33);
        System.out.println(toString(resc));
        liste1.suiv.val= 20;
        liste2.suiv.val= 50;
        System.out.println(toString(resc));

       /* System.out.println("\n\nConcate2");
        System.out.println(toString(liste33));
        Liste listeconcat2 = concatV2(liste2,liste33);
        System.out.println(toString(listeconcat2));*/


    }
}

